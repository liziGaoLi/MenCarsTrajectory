package com.zhhl.analysis.common;

import android.app.Application;

import com.zhhl.analysis.di.component.AppComponent;
import com.zhhl.analysis.di.component.DaggerAppComponent;
import com.zhhl.analysis.di.module.AppModule;

/**
 * Created by miao on 2019/1/18.
 */
public class OriginApp extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void setAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
//                .clientModule(new ClientModule())
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setAppComponent();
    }
}
