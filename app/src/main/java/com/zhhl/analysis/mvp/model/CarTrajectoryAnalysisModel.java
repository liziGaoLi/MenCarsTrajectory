package com.zhhl.analysis.mvp.model;

import com.google.gson.Gson;
import com.zhhl.analysis.common.BaseModel;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.data.CarInformation;
import com.zhhl.analysis.data.CarTrajectoryBayonet;
import com.zhhl.analysis.mvp.contacts.CarTrajectoryAnalysisContact;
import com.zhhl.analysis.net.IModel;
import com.zhhl.analysis.net.ITrajectoryAnalysis;

import io.reactivex.Observable;

/**
 * Created by miao on 2019/2/28.
 */

public class CarTrajectoryAnalysisModel extends BaseModel implements CarTrajectoryAnalysisContact.Model {

    private final ITrajectoryAnalysis iTrajectoryAnalysis;
    private final IModel iModel;

    public CarTrajectoryAnalysisModel(Gson gson, OriginApp application, ITrajectoryAnalysis iTrajectoryAnalysis, IModel iModel) {
        super(application, gson);
        this.iTrajectoryAnalysis = iTrajectoryAnalysis;
        this.iModel = iModel;
    }


    @Override
    public Observable<CarTrajectoryBayonet> customDateTrajectory(String idNumber, String start, String end) {
        return iTrajectoryAnalysis.carTrajectory(idNumber, start, end);
    }

    @Override
    public Observable<CarInformation> carInformation(String idNumber) {
        return iModel.carInformation(idNumber);
    }

    @Override
    public Observable<CarTrajectoryBayonet> carTrajectoryOneToThree(String idNumber, String code) {
        return iTrajectoryAnalysis.carTrajectory(idNumber, code);
    }
}

