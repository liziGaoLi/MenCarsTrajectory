package com.zhhl.analysis.mvp.presenter;

import com.zhhl.analysis.app.App;
import com.zhhl.analysis.common.BasePresenter;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.data.ChangQuDiData;
import com.zhhl.analysis.data.GuijiCQDWrapper;
import com.zhhl.analysis.data.GxclData;
import com.zhhl.analysis.data.GxrData2;
import com.zhhl.analysis.data.PersonTrajectory;
import com.zhhl.analysis.data.PersonTrajectoryNoId;
import com.zhhl.analysis.data.PersonTrajectorySZQY;
import com.zhhl.analysis.data.PersonTrajectoryUnLock;
import com.zhhl.analysis.data.SelfTrajectoryData;
import com.zhhl.analysis.data.SimpleCarInfo;
import com.zhhl.analysis.di.ActivityScope;
import com.zhhl.analysis.mvp.contacts.PersonTrajectoryAnalysisContract;
import com.zhhl.analysis.net.Api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@ActivityScope
public class

PersonTrajectoryAnalysisPresenter extends BasePresenter<PersonTrajectoryAnalysisContract.Model, PersonTrajectoryAnalysisContract.View> {
    private int requestCounter = 0;
    private String idNumber;
    private List<SelfTrajectoryData.RenkouBean> renkouBean;
    private ArrayList<String> rylb = new ArrayList<>();
    private ArrayList<SimpleCarInfo> carInfos = new ArrayList<>();

    private String ladw;

    public ArrayList<String> getRylb() {
        return rylb;
    }

    @Inject
    public PersonTrajectoryAnalysisPresenter(PersonTrajectoryAnalysisContract.Model model, PersonTrajectoryAnalysisContract.View rootView
            , OriginApp application) {
        super(model, rootView);
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void getDataRangeWx(String start, String end) {

        requestCreate();
        mModel.noId(idNumber, start, end)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((d)->noId(d,idNumber,start,end), this::onError, this::onComplete)
                .isDisposed();
        requestCreate();
        mModel.szqy(idNumber, start, end)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((d)->this.szqy(d,idNumber,start,end), this::onError, this::onComplete)
                .isDisposed();
        requestCreate();
        mModel.unlock(idNumber, start, end)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((data)->this.unLock(data,idNumber,start,end), this::onError, this::onComplete).isDisposed();
    }

    public void getMyTrajectory(String start, String end) {
        requestCreate();
        mModel.trajectory0(idNumber, start, end, "0")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::selfTrajectory, this::onError, this::onComplete)
                .isDisposed();
    }


    public void getChangQuDi(String start, String end) {

        requestCreate();
        mModel.getChangQuDi(idNumber, start, end, "3")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::setCQD, this::onError, this::onComplete)
                .isDisposed();
    }

    private void requestCreate() {
        requestCounter++;
        if (requestCounter > 0) {
            mRootView.showRequestDialog();
        }
    }

    private void requestDistroy() {
        requestCounter--;
        if (requestCounter <= 0) {
            mRootView.dismissRequestDialog();
        }
    }


    private void selfTrajectory(SelfTrajectoryData guiji) {
        requestDistroy();
        ArrayList<PersonTrajectory> wrappers = transitionWrapper(guiji);
        if (guiji.getRenkou().size() > 0)
            mRootView.setTrajectoryName(guiji.getRenkou().get(0).getXm());
        this.renkouBean = guiji.getRenkou();


        rylb.clear();
        if (guiji.getRylb() != null)
            rylb.addAll(guiji.getRylb());


        ladw = guiji.getLadw();
//        rylb.add("涉恐");
//        rylb.add("涉稳");
//        rylb.add("在逃");
//        rylb.add("涉毒");
//        rylb.add("前科");
//        rylb.add("精神病");
//        rylb.add("上访");   rylb.add("涉恐");
//        rylb.add("涉稳");
//        rylb.add("在逃");
//        rylb.add("涉毒");
//        rylb.add("前科");
//        rylb.add("精神病");
//        rylb.add("上访");
//        rylb.add("上访");
        mRootView.setExceptionPerson(rylb.size() > 0);
        mRootView.addData(wrappers);
    }


    private void unLock(PersonTrajectoryUnLock personTrajectoryUnLock, String idNumber, String start, String end) {
        requestDistroy();
        ArrayList<PersonTrajectory> data = new ArrayList<>();
        if (personTrajectoryUnLock.isSuccess()) {
            for (int i = 0; i < personTrajectoryUnLock.getObj().size(); i++) {
                PersonTrajectoryUnLock.ObjBean objBean = personTrajectoryUnLock.getObj().get(i);
                PersonTrajectory personTrajectory = new PersonTrajectory(objBean);
                data.add(personTrajectory);
            }
        }
        mRootView.addData(data);
        App.app().getLogReport().log("{\n" +
                "  \"idNumber\": \"" + idNumber + "\",\n" +
                "  \"formToDate\": \"" + start + "\",\n" +
                "  \"formEndDate\": \"" + end + "\",\n" +
                "}", Api.unLockTrajectory, gson.toJson(personTrajectoryUnLock));
//        @Field("idNumber") String idNumber, @Field("formToDate") String formToDate, @Field("formEndDate") String formEndDate
    }


    private void szqy(PersonTrajectorySZQY personTrajectorySZQY,String idNumber,String start,String end) {
        requestDistroy();
        ArrayList<PersonTrajectory> data = new ArrayList<>();
        if (personTrajectorySZQY.isSuccess()) {
            for (int i = 0; i < personTrajectorySZQY.getObj().size(); i++) {
                PersonTrajectorySZQY.ObjBean objBean = personTrajectorySZQY.getObj().get(i);
                PersonTrajectory personTrajectory = new PersonTrajectory(objBean);
                data.add(personTrajectory);
            }
        }
        App.app().getLogReport().log("{\n" +
                "  \"idNumber\": \"" + idNumber + "\",\n" +
                "  \"formToDate\": \"" + start + "\",\n" +
                "  \"formEndDate\": \"" + end + "\",\n" +
                "}", Api.szqyTrajectory, gson.toJson(personTrajectorySZQY));
        mRootView.addData(data);
    }

    private void noId(PersonTrajectoryNoId personTrajectoryNoId, String idNumber, String start, String end) {
        requestDistroy();
        ArrayList<PersonTrajectory> data = new ArrayList<>();
        if (personTrajectoryNoId.isSuccess()) {
            for (int i = 0; i < personTrajectoryNoId.getObj().size(); i++) {
                PersonTrajectoryNoId.ObjBean objBean = personTrajectoryNoId.getObj().get(i);
                PersonTrajectory personTrajectory = new PersonTrajectory(objBean);
                data.add(personTrajectory);
            }
        }
        App.app().getLogReport().log("{\n" +
                "  \"idNumber\": \"" + idNumber + "\",\n" +
                "  \"formToDate\": \"" + start + "\",\n" +
                "  \"formEndDate\": \"" + end + "\",\n" +
                "}", Api.noIdTrajectory, gson.toJson(personTrajectoryNoId));
        mRootView.addData(data);
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
        requestDistroy();
    }

    private ArrayList<PersonTrajectory> transitionWrapper(SelfTrajectoryData zaitaoguiji) {
        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
        List<SelfTrajectoryData.CheliangBean> cheliang = zaitaoguiji.getCheliang();
        List<SelfTrajectoryData.KecheBean> keche = zaitaoguiji.getKeche();
        List<SelfTrajectoryData.MinhangBean> minhang = zaitaoguiji.getMinhang();
        List<SelfTrajectoryData.ShangwangBean> shangwang = zaitaoguiji.getShangwang();
        List<SelfTrajectoryData.TielugoupiaoBean> tielugoupiao = zaitaoguiji.getTielugoupiao();
        List<SelfTrajectoryData.ZhudianBean> zhudian = zaitaoguiji.getZhudian();
        List<SelfTrajectoryData.KakouBean> kakou = zaitaoguiji.getKakou();

        if (cheliang != null) {
            carInfos.clear();
            for (SelfTrajectoryData.CheliangBean c : cheliang) {
                SimpleCarInfo simpleCarInfo = new SimpleCarInfo();
                simpleCarInfo.setCarCode(c.getGajtglfzjgslmc() + c.getJdchphm().substring(1));
                simpleCarInfo.setCarName(c.getZwppmc());
                simpleCarInfo.setCompany(c.getZzcDwmc());
                carInfos.add(simpleCarInfo);
            }
        }
        if (keche != null)
            for (SelfTrajectoryData.KecheBean c : keche) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (minhang != null)
            for (SelfTrajectoryData.MinhangBean c : minhang) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (shangwang != null)
            for (SelfTrajectoryData.ShangwangBean c : shangwang) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (tielugoupiao != null)
            for (SelfTrajectoryData.TielugoupiaoBean c : tielugoupiao) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (zhudian != null)
            for (SelfTrajectoryData.ZhudianBean c : zhudian) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (kakou != null)
            for (SelfTrajectoryData.KakouBean c : kakou) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        return wrappers;
    }

    public List<SelfTrajectoryData.RenkouBean> getRenkou() {
        return renkouBean;
    }

    private void setCQD(ChangQuDiData changQuDiData) {
        requestDistroy();
        ArrayList<GuijiCQDWrapper> shangwang = new ArrayList<>();
        ArrayList<GuijiCQDWrapper> zhudian = new ArrayList<>();
        List<ChangQuDiData.ShangwangBean> sshangwang = changQuDiData.getShangwang();
        for (ChangQuDiData.ShangwangBean sw : sshangwang) {
            GuijiCQDWrapper guijiCQDWrapper = new GuijiCQDWrapper();
            guijiCQDWrapper.ldmc = sw.getYycsDwmc();
            guijiCQDWrapper.tj = sw.getTj();
            shangwang.add((guijiCQDWrapper));
        }

        List<ChangQuDiData.ZhudianTongjiBean> szhudian = changQuDiData.getZhudian();
        for (ChangQuDiData.ZhudianTongjiBean sw : szhudian) {
            GuijiCQDWrapper guijiCQDWrapper = new GuijiCQDWrapper();
            guijiCQDWrapper.ldmc = sw.getLdMc();
            guijiCQDWrapper.tj = sw.getTj();
            zhudian.add((guijiCQDWrapper));
        }
        Collections.sort(shangwang);
        Collections.sort(zhudian);
        if (shangwang.size() > 3) {
            shangwang = new ArrayList<>(shangwang.subList(0, 3));
        }
        if (zhudian.size() > 3) {
            zhudian = new ArrayList<>(zhudian.subList(0, 3));
        }

        mRootView.addData(toTrajectory(shangwang));
        mRootView.addData(toTrajectory(zhudian));
    }

    private ArrayList<PersonTrajectory> toTrajectory(List<GuijiCQDWrapper> source) {
        ArrayList<PersonTrajectory> dest = new ArrayList<>();
        for (GuijiCQDWrapper gj : source) {
            dest.add(new PersonTrajectory(gj));
        }
        return dest;
    }

    public void getGxclTrajectory() {
        requestCreate();
        mModel.trajectoryGxcl(idNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::gxclRes, this::onError, this::onComplete)
                .isDisposed();
    }

    private void gxclRes(GxclData o) {
        requestDistroy();
        mRootView.setGxclAdapter(o);

    }

    public void getGxrTrajectory2(String start, String end) {
        requestCreate();
        mModel.trajectoryGxr(idNumber, start, end)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::gxrRes, this::onError, this::onComplete)
                .isDisposed();
    }

    private void gxrRes(GxrData2 o) {
        requestDistroy();
        mRootView.setGxrAdapter(transitionWrapper(o));

    }


    private ArrayList<PersonTrajectory> transitionWrapper(GxrData2 gxrData) {
        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
        List<GxrData2.HunyinBean> hunyin = gxrData.getHunyin();
        List<GxrData2.QinshuBean> qinshu = gxrData.getQinshu();
        List<GxrData2.KctxBean> keche = gxrData.getKctx();
        List<GxrData2.HbtxBean> minhang = gxrData.getHbtx();
        List<GxrData2.HclzBean> hclz = gxrData.getHclz();
        List<GxrData2.HctxBean> hctx = gxrData.getHctx();
        List<GxrData2.ZstxBean> zhudian = gxrData.getZstx();

        HashMap<String, PersonTrajectory> gxr = new HashMap<>();

        if (keche != null) {
            HashMap<String, ArrayList<GxrData2.KctxBean>> kc = new HashMap<>();
            for (GxrData2.KctxBean c : keche) {
                ArrayList<GxrData2.KctxBean> kctxBeans = kc.get(c.getZjqfZjhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    kc.put(c.getZjqfZjhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : kc.keySet()) {
                wrappers.add(new PersonTrajectory().setKctx(kc.get(key)));
            }
        }
        if (minhang != null) {
            HashMap<String, ArrayList<GxrData2.HbtxBean>> hb = new HashMap<>();
            for (GxrData2.HbtxBean c : minhang) {
                ArrayList<GxrData2.HbtxBean> kctxBeans = hb.get(c.getZjhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hb.put(c.getZjhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }

            for (String key : hb.keySet()) {
                wrappers.add(new PersonTrajectory().setHbtx(hb.get(key)));
            }

        }

        if (hclz != null) {
            HashMap<String, ArrayList<GxrData2.HclzBean>> hc = new HashMap<>();
            for (GxrData2.HclzBean c : hclz) {
                ArrayList<GxrData2.HclzBean> kctxBeans = hc.get(c.getGmsfhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hc.put(c.getGmsfhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : hc.keySet()) {
                wrappers.add(new PersonTrajectory().setHclz(hc.get(key)));
            }
        }
        if (hctx != null) {
            HashMap<String, ArrayList<GxrData2.HctxBean>> hc = new HashMap<>();
            for (GxrData2.HctxBean c : hctx) {
                ArrayList<GxrData2.HctxBean> kctxBeans = hc.get(c.getGmsfhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hc.put(c.getGmsfhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : hc.keySet()) {
                wrappers.add(new PersonTrajectory().setHctx(hc.get(key)));
            }
        }
        if (zhudian != null) {
            HashMap<String, ArrayList<GxrData2.ZstxBean>> hc = new HashMap<>();
            for (GxrData2.ZstxBean c : zhudian) {
                ArrayList<GxrData2.ZstxBean> kctxBeans = hc.get(c.getGmsfhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hc.put(c.getGmsfhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : hc.keySet()) {
                wrappers.add(new PersonTrajectory().setZstx(hc.get(key)));
            }
        }
        if (qinshu != null) {
            for (GxrData2.QinshuBean c : qinshu) {
                PersonTrajectory trajectory = new PersonTrajectory(c);
                if (!trajectory.getIdNumber().equals(idNumber))
                    gxr.put(trajectory.getIdNumber(), trajectory);
            }
        }
        if (hunyin != null)
            for (GxrData2.HunyinBean c : hunyin) {
                PersonTrajectory trajectory = new PersonTrajectory(c);
                if (!trajectory.getIdNumber().equals(idNumber))
                    gxr.put(trajectory.getIdNumber(), trajectory);
            }

        for (String idNumber : gxr.keySet()) {
            wrappers.add(gxr.get(idNumber));
        }
        return wrappers;
    }

    public String getLadw() {
        return ladw;
    }

    public ArrayList<SimpleCarInfo> getCarInfos() {
        return carInfos;
    }
}
