package com.zhhl.analysis.di.component;

import com.zhhl.analysis.di.ActivityScope;
import com.zhhl.analysis.di.module.CarTrajectoryAnalysisModule;
import com.zhhl.analysis.mvp.view.activities.CarTrajectoryAnalysisActivity;

import dagger.Component;

/**
 * Created by miao on 2019/2/28.
 */

@ActivityScope
@Component(modules = CarTrajectoryAnalysisModule.class, dependencies = AppComponent.class)
public interface CarTrajectoryAnalysisComponent {
    void inject(CarTrajectoryAnalysisActivity activity);
}