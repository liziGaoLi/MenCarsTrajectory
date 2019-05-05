package com.zhhl.analysis.common;

import android.os.Bundle;

import com.xdja.watermarklibrary.WaterMarkUtils;
import com.zhhl.analysis.R;
import com.zhhl.analysis.app.App;
import com.zhhl.analysis.di.component.AppComponent;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P mPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyWaterShadow();
        setContentView(layoutId());
        ButterKnife.bind(this);
        componentInject();
        initData();
    }

    private void applyWaterShadow() {
        if (App.app().getUserInfo() != null)
            WaterMarkUtils.addWaterMark(this, App.app().getUserInfo().getUserInfo().getName() + " " + App.app().getUserInfo().getUserInfo().getCode(), 270 + 45, getResources().getColor(R.color.wt), 60);
    }

    protected abstract void initData();

    protected abstract int layoutId();

    private void componentInject() {
        setUpActivityComponent(((App) getApplication()).getAppComponent());
    }

    protected abstract void setUpActivityComponent(AppComponent appComponent);
}
