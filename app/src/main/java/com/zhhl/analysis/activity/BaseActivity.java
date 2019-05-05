package com.zhhl.analysis.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.xdja.watermarklibrary.WaterMarkUtils;
import com.zhhl.analysis.R;
import com.zhhl.analysis.app.App;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by miao on 2018/12/14.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentRes());
        if (App.app().getUserInfo() != null)
            WaterMarkUtils.addWaterMark(this, App.app().getUserInfo().getUserInfo().getName() + " " + App.app().getUserInfo().getUserInfo().getCode(), 270 + 45, getResources().getColor(R.color.wt), 60);
    }

    protected abstract int getContentRes();


    void onError(Throwable t) {
        String err = t.getMessage();
        if (err.contains("timeout")) {
            Toast.makeText(this, "连接超时", Toast.LENGTH_SHORT).show();
        }
    }
}
