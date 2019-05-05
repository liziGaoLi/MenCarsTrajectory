package com.zhhl.analysis.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhhl.analysis.R;
import com.zhhl.analysis.data.SelfTrajectoryData;
import com.zhhl.analysis.data.SimpleCarInfo;
import com.zhhl.analysis.mvp.view.activities.CarTrajectoryAnalysisActivity;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    LinearLayout mRoot;
    ArrayList<SimpleCarInfo> carInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        setContentView(R.layout.activity_user_info);
        SelfTrajectoryData.RenkouBean rk = getIntent().getParcelableExtra("rk");
        carInfo = getIntent().getParcelableArrayListExtra("carInfo");
        mRoot = findViewById(R.id.mRoot);
        TextView sname = findViewById(R.id.name);
        TextView sexs = findViewById(R.id.sex);
        TextView minzus = findViewById(R.id.type);
        TextView xls = findViewById(R.id.xl);
        TextView sfzhs = findViewById(R.id.sfzh);
        TextView jtzzs = findViewById(R.id.jtzz);
        findViewById(R.id.sfzImg).setVisibility(View.INVISIBLE);
        sname.setText(rk.getXm());
        sexs.setText(rk.getXbdm());
        minzus.setText(rk.getMzdm() == null ? "其它" : rk.getMzdm());
        xls.setText(rk.getXldm() == null ? "其它" : rk.getXldm());
        sfzhs.setText(rk.getGmsfhm());
        jtzzs.setText(rk.getDzmc());
        for (int i = 0; i < carInfo.size(); i++) {
            new ViewHolder(i, View.inflate(this, R.layout.item_car_info_users, null), carInfo.get(i));
        }
    }


    public class ViewHolder {

        TextView carId;
        TextView cpTitle;

        ViewHolder(int idx, View view, SimpleCarInfo carInfo) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            view.setLayoutParams(params);
            mRoot.addView(view, params);
            carId = view.findViewById(R.id.carCode);
            cpTitle = view.findViewById(R.id.cp_title);
            carId.setText(carInfo.getCarCode());
            cpTitle.setVisibility(idx == 0 ? View.VISIBLE : View.INVISIBLE);
            view.setOnClickListener((v) -> startActivity(new Intent(UserInfoActivity.this, CarTrajectoryAnalysisActivity.class).putExtra("idNumber", carInfo.getCarCode())));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}
