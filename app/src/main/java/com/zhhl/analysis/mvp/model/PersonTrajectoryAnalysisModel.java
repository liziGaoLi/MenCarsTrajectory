package com.zhhl.analysis.mvp.model;

import com.google.gson.Gson;
import com.zhhl.analysis.common.BaseModel;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.data.ChangQuDiData;
import com.zhhl.analysis.data.GxclData;
import com.zhhl.analysis.data.GxrData2;
import com.zhhl.analysis.data.PersonTrajectoryNoId;
import com.zhhl.analysis.data.PersonTrajectorySZQY;
import com.zhhl.analysis.data.PersonTrajectoryUnLock;
import com.zhhl.analysis.data.SelfTrajectoryData;
import com.zhhl.analysis.mvp.contacts.PersonTrajectoryAnalysisContract;
import com.zhhl.analysis.net.IModel;
import com.zhhl.analysis.net.ITrajectoryAnalysis;

import io.reactivex.Observable;

public class PersonTrajectoryAnalysisModel extends BaseModel implements PersonTrajectoryAnalysisContract.Model {

    private final ITrajectoryAnalysis iWx;
    private final IModel iMd;

    public PersonTrajectoryAnalysisModel(OriginApp application, Gson gson, ITrajectoryAnalysis iWx, IModel iMd) {
        super(application, gson);
        this.iWx = iWx;
        this.iMd = iMd;
    }


    @Override
    public Observable<PersonTrajectoryNoId> noId(String idNumber, String start, String end) {
        return iWx.noIdTrajectory(idNumber, start, end);
    }

    @Override
    public Observable<PersonTrajectorySZQY> szqy(String idNumber, String start, String end) {
        return iWx.szqyTrajectory(idNumber, start, end);
    }

    @Override
    public Observable<PersonTrajectoryUnLock> unlock(String idNumber, String start, String end) {
        return iWx.unLockTrajectory(idNumber, start, end);
    }

    @Override
    public Observable<SelfTrajectoryData> trajectory0(String idNumber, String start, String end, String value) {
        return iMd.selfTrajectory(idNumber, start, end, value);
    }

//    @Override
//    public Observable<HunyinGuiji> trajectory1(String idNumber, String start, String end, String value) {
//        return iMd.shangfangguiji1(idNumber, start, end, value);
//    }

//    @Override
//    public Observable<GxrData> trajectoryGxr(String idNumber) {
//        return iMd.guanXiRenGuiji(idNumber);
//    }

    @Override
    public Observable<ChangQuDiData> getChangQuDi(String idNumber, String start, String end, String value) {
        return iMd.frequented(idNumber, start, end, value);
    }

    @Override
    public Observable<GxclData> trajectoryGxcl(String idNumber) {
        return iMd.trajectoryGxcl(idNumber);
    }

    @Override
    public Observable<GxrData2> trajectoryGxr(String idNumber, String start, String end) {
        return iMd.trajectoryGxr(idNumber, start, end);
    }
}

