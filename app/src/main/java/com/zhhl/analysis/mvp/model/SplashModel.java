package com.zhhl.analysis.mvp.model;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.zhhl.analysis.common.BaseModel;
import com.zhhl.analysis.common.OriginApp;
import com.zhhl.analysis.mvp.contacts.SplashContract;
import com.zhhl.analysis.net.IModel;

import io.reactivex.Observable;

/**
 * Created by miao on 2018/9/7.
 */

public class SplashModel extends BaseModel implements SplashContract.Model {

    private final IModel iModel;

    public SplashModel(Gson gson, OriginApp application, IModel iModel) {
        super(application, gson);
        this.iModel = iModel;
    }


    @Override
    public Observable<Boolean> checkPermission(String code, String requiredId) {
        Log.e("checkPermission: ", requiredId);
        return iModel.checkPermission(code, requiredId);
    }
}

