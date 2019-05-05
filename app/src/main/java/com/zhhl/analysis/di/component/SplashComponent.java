package com.zhhl.analysis.di.component;

import com.zhhl.analysis.di.ActivityScope;
import com.zhhl.analysis.di.module.SplashModule;
import com.zhhl.analysis.mvp.view.activities.SplashActivity;

import dagger.Component;

/**
 * Created by miao on 2018/9/7.
 */

@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}