package com.zhhl.analysis.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.xdja.sslvpn.api.VpnApi50Impl;
import com.xdja.uaac.api.UaacApi;
import com.xdja.watermarklibrary.WaterMarkUtils;
import com.zhhl.analysis.app.App;
import com.zhhl.analysis.net.HttpTools;
import com.zhhl.analysis.R;
import com.zhhl.analysis.data.LoginBean;
import com.zhhl.analysis.net.proxy.ILogUploadImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @BindView(R.id.person)
    ImageView person;
    @BindView(R.id.car)
    ImageView car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorTextColorLight));
        ButterKnife.bind(this);
    }

    @Override
    public int getContentRes() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.person, R.id.car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.person:
                startActivity(new Intent(this, PersonAnalysisActivity.class));
                break;
            case R.id.car:
                startActivity(new Intent(this, CarAnalysisActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime <= 2000) {
            super.onBackPressed();
        } else {
            lastTime = System.currentTimeMillis();
            Toast.makeText(this, "请再按一次退出", Toast.LENGTH_SHORT).show();
        }
    }

    private long lastTime;
}
