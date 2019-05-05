package com.zhhl.analysis.common;

import android.widget.Toast;

import com.google.gson.Gson;

public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    protected M mModel;
    protected V mRootView;
    protected Gson gson=new Gson();

    protected BasePresenter(M m, V v) {
        this.mModel = m;
        this.mRootView = v;
    }



    protected void onComplete() {

    }

    public  void onError(Throwable throwable){
        throwable.printStackTrace();
        String err = throwable.getMessage();
        if (err.contains("timeout")){
            Toast.makeText(mRootView.getContext(), "连接超时", Toast.LENGTH_SHORT).show();
        }
    }
}
