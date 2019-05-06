package com.zhhl.analysis.net.proxy;

import android.os.Process;
import android.util.Log;

import com.xdja.sslvpn.api.VpnApi50;
import com.zhhl.analysis.app.App;
import com.zhhl.analysis.data.LoginBean;
import com.zhhl.analysis.mvp.model.LogReportData;
import com.zhhl.analysis.net.HttpTools;
import com.zhhl.analysis.utils.MacUtils;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ILogUploadImpl {
    private ILogUpload iLogUpload;
    private VpnApi50 vpnApi50;

    public ILogUploadImpl(VpnApi50 vpnApi50) {
        this.iLogUpload = HttpTools.build(ILogUpload.class, "http://192.168.20.228:7103/");//"http://192.168.20.228:7122/"
        this.vpnApi50 = vpnApi50;
    }


    public void log(String params, String url, String response) {
        LoginBean.UserInfoBean userInfo = App.app().getUserInfo().getUserInfo();
        Log.e("log: ", "pid :" + Process.myPid());
        /**
         * String policeId,
         *  String sn,
         *  String cardNo,
         *  String logType,
         *  String params,
         *  String url,
         *  String terminalIp,
         *  String module,
         *  String formatParam,
         *  String response,
         *  String responseTime,
         *  String sourceIp,
         *  String sourcePort
         */
        if (App.app().getUserInfo() != null)
            if (userInfo != null)//java.security.NoSuchAlgorithmException: The BC provider no longer provides an implementation for CertificateFactory.X.509
                upload(userInfo.getCode(), ""/*vpnApi50.getDefaultCertSN()*/, userInfo.getIdentifier(),
                        "12", params, url, MacUtils.getIPAddress(App.app()),
                        "人车轨迹分析", "", response, "500", "192.168.20.228",
                        "7103")
                        .observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.computation())
                        .subscribe(this::logres, this::err, this::complete)
                        .isDisposed();
    }

    Observable<Object> upload(String policeId,
                              String sn,
                              String cardNo,
                              String logType,
                              String params,
                              String url,
                              String terminalIp,
                              String module,
                              String formatParam,
                              String response,
                              String responseTime,
                              String sourceIp,
                              String sourcePort
    ) {
        LogReportData logReportData = new LogReportData(cardNo, formatParam, logType, module, params, policeId, System.currentTimeMillis() + "-" + policeId, response, responseTime, System.currentTimeMillis() + "-" + policeId, sn, sourceIp, sourcePort, terminalIp, url);
        return iLogUpload.upload((logReportData));
    }

    private void complete() {

    }

    private void err(Throwable throwable) {
        throwable.printStackTrace();
    }

    private void logres(Object o) {
        Log.e("logReport>>>: ", o.toString());
    }
}
