package com.zhhl.analysis.mvp.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.xdja.uaac.api.TokenCallback;
import com.xdja.uaac.api.UaacApi;
import com.zhhl.analysis.R;
import com.zhhl.analysis.activity.MainActivity;
import com.zhhl.analysis.common.BaseMvpActivity;
import com.zhhl.analysis.di.component.AppComponent;
import com.zhhl.analysis.di.component.DaggerSplashComponent;
import com.zhhl.analysis.di.module.SplashModule;
import com.zhhl.analysis.mvp.contacts.SplashContract;
import com.zhhl.analysis.mvp.presenter.SplashPresenter;

import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by miao on 2018/9/7.
 */

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashContract.View {

    //
//    @BindView(R.id.appName)
//    TextView appName;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.information)
    TextView information;
    private boolean finish;
    @BindView(R.id.root)
    ConstraintLayout splashView;
    @BindView(R.id.indicator)
    ProgressBar indicator;
    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
        DaggerSplashComponent
                .builder()
                .appComponent(appComponent)
                .splashModule(new SplashModule(this)) //请将SplashModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    public void dismissIndicator() {
        indicator.setVisibility(View.INVISIBLE);
        Snackbar.make(splashView, "您的账户没有在系统注册,请与管理员联系", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        description.setText("①人员轨迹查询，包括本人轨迹、关系人轨迹（同行、同住、同户）、常去地分析等；\n" +
//                "②车辆轨迹查询，包括卡口过车、小区车辆进出信息、临时停放车辆信息；\n" +
//                "③人车关联查询，通过人车关系模型（名下车辆、违章缴罚关系车辆、关系人车辆等），实现以人找车或以车找       人，并且展示人员、车辆的轨迹。");

//        information.setText("如需开通权限请联系吉林省公安厅科技通信处\n" +
//                "吉林省智慧互联信息科技有限公司");
        UaacApi.getToken(this, new TokenCallback() {
            @Override
            public void onSuccess(String token, boolean b) {
                new Handler(Looper.getMainLooper()).postDelayed(() -> mPresenter.login(token), 5000);
            }

            @Override
            public void onError(String s) {
                if (s.equals("票据不存在")) {
                    new Handler(Looper.getMainLooper()).postDelayed(() -> UaacApi.getToken(SplashActivity.this, this), 2000);
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public Context getContext() {
        return this;
    }
}