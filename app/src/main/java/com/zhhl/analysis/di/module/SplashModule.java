package com.zhhl.analysis.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.di.ActivityScope;
import com.zhhl.analysis.mvp.contacts.SplashContract;
import com.zhhl.analysis.mvp.model.SplashModel;
import com.zhhl.analysis.net.IModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by miao on 2018/9/7.
 */

@Module
public class SplashModule {
    private SplashContract.View view;

    /**
     * 构建SplashModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view contract
     */
    public SplashModule(SplashContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SplashContract.View provideSplashView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SplashContract.Model provideSplashModel(Gson gson, OriginApp application, IModel iModel) {
        return new SplashModel(gson, application,iModel);
    }
}