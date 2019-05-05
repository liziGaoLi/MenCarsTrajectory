package com.zhhl.analysis.app;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.xdja.sslvpn.api.VpnApi50Impl;
import com.xdja.uaac.api.UaacApi;
import com.zhhl.analysis.activity.MainActivity;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.data.LoginBean;
import com.zhhl.analysis.net.HttpTools;
import com.zhhl.analysis.net.Login;
import com.zhhl.analysis.net.proxy.ILogUploadImpl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

//import com.xdja.uaac.api.UaacApi;
//import com.zhhl.android.policemovecareful.HttpTools;
//import com.zhhl.android.policemovecareful.Login;
//import com.zhhl.android.policemovecareful.activity.MainActivity;
//import com.zhhl.android.policemovecareful.bean.LoginBean;

/**
 * Created by miao on 2018/9/21.
 */
public class App extends OriginApp {


    private String Token;
    private LoginBean userInfo;
    private ILogUploadImpl logReport;

    public String getToken() {
        return Token;
    }

    private void setToken(String token) {
        Token = token;
    }

    private static App app;

    public static App app() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    public void setUserInfo(LoginBean userInfo) {
        this.userInfo = userInfo;
    }

    public LoginBean getUserInfo() {
        return userInfo;
    }


    public ILogUploadImpl getLogReport() {
        if (logReport==null)
            logReport =new ILogUploadImpl(new VpnApi50Impl(this));
        return logReport;
    }

    public void setLogReport(ILogUploadImpl logReport) {
        this.logReport = logReport;
    }

}
