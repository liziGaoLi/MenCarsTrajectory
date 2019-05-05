package com.zhhl.analysis.di.module;

import com.google.gson.Gson;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.di.ActivityScope;
import com.zhhl.analysis.mvp.contacts.CarTrajectoryAnalysisContact;
import com.zhhl.analysis.mvp.model.CarTrajectoryAnalysisModel;
import com.zhhl.analysis.net.IModel;
import com.zhhl.analysis.net.ITrajectoryAnalysis;
import com.zhhl.analysis.net.proxy.ITrajectoryStaticProxy;

import dagger.Module;
import dagger.Provides;


/**
 * Created by miao on 2019/2/28.
 */

@Module
public class CarTrajectoryAnalysisModule {
    private CarTrajectoryAnalysisContact.View view;


    public CarTrajectoryAnalysisModule(CarTrajectoryAnalysisContact.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    CarTrajectoryAnalysisContact.View provideCarTrajectoryAnalysisView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    CarTrajectoryAnalysisContact.Model provideCarTrajectoryAnalysisModel(Gson gson, OriginApp application, ITrajectoryAnalysis iTrajectoryAnalysis, IModel iModel) {
        return new CarTrajectoryAnalysisModel(gson, application, (iTrajectoryAnalysis), new ITrajectoryStaticProxy(iModel));
    }
}