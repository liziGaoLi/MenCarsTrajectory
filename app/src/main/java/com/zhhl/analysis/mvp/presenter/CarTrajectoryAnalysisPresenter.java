package com.zhhl.analysis.mvp.presenter;

import android.widget.Toast;

import com.zhhl.analysis.app.App;
import com.zhhl.analysis.common.BasePresenter;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.data.CarInformation;
import com.zhhl.analysis.data.CarTrajectory;
import com.zhhl.analysis.data.CarTrajectoryBayonet;
import com.zhhl.analysis.di.ActivityScope;
import com.zhhl.analysis.mvp.contacts.CarTrajectoryAnalysisContact;
import com.zhhl.analysis.net.Api;
import com.zhhl.analysis.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by miao on 2019/2/28.
 */

@ActivityScope
public class CarTrajectoryAnalysisPresenter extends BasePresenter<CarTrajectoryAnalysisContact.Model, CarTrajectoryAnalysisContact.View> {
    private OriginApp mApplication;
    private String idNumber;

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Inject
    public CarTrajectoryAnalysisPresenter(CarTrajectoryAnalysisContact.Model model, CarTrajectoryAnalysisContact.View rootView
            , OriginApp application) {
        super(model, rootView);
        this.mApplication = application;
    }


    public void requestOneDay() {
        mModel.carTrajectoryOneToThree(idNumber, App.app().getUserInfo().getUserInfo().getCode()).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((data) -> this.myCarBayonetOneDay(data, idNumber, App.app().getUserInfo().getUserInfo().getCode()), this::onError, this::onComplete)
                .isDisposed();

    }


    public void requestThreeDay() {
        mModel.carTrajectoryOneToThree(idNumber, App.app().getUserInfo().getUserInfo().getCode()).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((data) -> this.myCarBayonetThreeDay(data, idNumber, App.app().getUserInfo().getUserInfo().getCode()), this::onError, this::onComplete)
                .isDisposed();
    }

    public void customDateTrajectory(String idNumber, String start, String end) {
        mModel.customDateTrajectory(idNumber, start, end)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((d) -> this.customDateTrajectory(d, idNumber, start, end), this::onError, this::onComplete)
                .isDisposed();
    }

    public void getCarInformation() {
        mModel.carInformation(idNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::carInfo, this::onError, this::onComplete)
                .isDisposed();
    }


    private void carInfo(CarInformation o) {
        mRootView.putData(o);
    }

    private void myCarBayonetOneDay(CarTrajectoryBayonet carTrajectoryBayonet, String code, String carCode) {
        if (carTrajectoryBayonet.isSuccess() && carTrajectoryBayonet.getObj() != null) {
            List<CarTrajectoryBayonet.ObjBean> obj = carTrajectoryBayonet.getObj();
            ArrayList<CarTrajectory> mData = new ArrayList<>();
            for (int i = 0; i < obj.size(); i++) {
                CarTrajectory carTrajectory = new CarTrajectory(obj.get(i));
                if (carTrajectory.getTime() >= DateUtil.parseDate("yyyy-MM-dd", DateUtil.format("yyyy-MM-dd", System.currentTimeMillis()))) {
                    mData.add(carTrajectory);
                }
            }
            mRootView.changeData(mData);

        } else {
            if (carTrajectoryBayonet.getMsg().contains("ORA-")) {
                Toast.makeText(mRootView.getContext(), "数据读取异常,请稍后再试", Toast.LENGTH_SHORT).show();
            }
        }
        App.app().getLogReport().log("{\n" +
                "  \"hphm\": \"" + carCode + "\",\n" +
                "  \"jh\": \"" + code + "\",\n" +
                "}", Api.carTrajectory, gson.toJson(carTrajectoryBayonet));

        mRootView.dialogDismiss();

    }

    private void customDateTrajectory(CarTrajectoryBayonet carTrajectoryBayonet, String idNumber, String start, String end) {
        if (carTrajectoryBayonet.isSuccess()) {
            List<CarTrajectoryBayonet.ObjBean> obj = carTrajectoryBayonet.getObj();
            ArrayList<CarTrajectory> mData = new ArrayList<>();
            for (int i = 0; i < obj.size(); i++) {
                mData.add(new CarTrajectory(obj.get(i)));
            }
            mRootView.changeData(mData);
        } else {
            if (carTrajectoryBayonet.getMsg().contains("ORA-")) {
                Toast.makeText(mRootView.getContext(), "数据读取异常,请稍后再试", Toast.LENGTH_SHORT).show();
            }
        }
        App.app().getLogReport().log("{\n" +
                "  \"hphm\": \"" + idNumber + "\",\n" +
                "  \"formToDate\": \"" + start + "\",\n" +
                "  \"formEndDate\": \"" + end + "\"\n" +
                "}", Api.carTrajectory3, gson.toJson(carTrajectoryBayonet));
        mRootView.dialogDismiss();
    }

    private void myCarBayonetThreeDay(CarTrajectoryBayonet carTrajectoryBayonet, String code, String carCode) {
        if (carTrajectoryBayonet.isSuccess() && carTrajectoryBayonet.getObj() != null) {
            List<CarTrajectoryBayonet.ObjBean> obj = carTrajectoryBayonet.getObj();
            ArrayList<CarTrajectory> mData = new ArrayList<>();
            for (int i = 0; i < obj.size(); i++) {
                mData.add(new CarTrajectory(obj.get(i)));
            }
            mRootView.changeData(mData);
        } else {
            if (carTrajectoryBayonet.getMsg().contains("ORA-")) {
                Toast.makeText(mRootView.getContext(), "数据读取异常,请稍后再试", Toast.LENGTH_SHORT).show();
            }
        }
        App.app().getLogReport().log("{\n" +
                "  \"hphm\": \"" + carCode + "\",\n" +
                "  \"jh\": \"" + code + "\",\n" +
                "}", Api.carTrajectory, gson.toJson(carTrajectoryBayonet));
        mRootView.dialogDismiss();
    }


    @Override
    public void onError(Throwable t) {
        super.onError(t);
        mRootView.dialogDismiss();
    }

    public ArrayList<String> getDateRange() {
        ArrayList<String> dataYear = new ArrayList<>();
        dataYear.add("当天");
        dataYear.add("三天");
        dataYear.add("自定义");
        return dataYear;
    }

    public ArrayList<String> getTypeName() {
        ArrayList<String> all = new ArrayList<>();
        all.add("全部");
        all.add("本人车辆");
        all.add("关系车辆");
        all.add("代扣分车辆");
        return all;
    }
}