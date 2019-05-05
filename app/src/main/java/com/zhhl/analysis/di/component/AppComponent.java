package com.zhhl.analysis.di.component;

import com.google.gson.Gson;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.di.module.AppModule;
import com.zhhl.analysis.di.module.ClientModule;
import com.zhhl.analysis.di.module.NetworkModule;
import com.zhhl.analysis.net.IModel;
import com.zhhl.analysis.net.ITrajectoryAnalysis;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = {AppModule.class, ClientModule.class, NetworkModule.class})

public interface AppComponent {
    OriginApp application();

    Gson gson();

    OkHttpClient client();

    ITrajectoryAnalysis iWx();

    IModel iMd();

}