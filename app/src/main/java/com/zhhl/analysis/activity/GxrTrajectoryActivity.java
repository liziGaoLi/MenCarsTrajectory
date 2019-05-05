package com.zhhl.analysis.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.widget.ListView;

import com.zhhl.analysis.R;
import com.zhhl.analysis.adapter.GxrTrajectoryAdapter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GxrTrajectoryActivity extends AppCompatActivity {

    @BindView(R.id.mList)
    ListView mList;

    private final GxrTrajectoryAdapter mAdapter = new GxrTrajectoryAdapter(new ArrayList<>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        setContentView(R.layout.activity_gxr_trajectory);
        ButterKnife.bind(this);
        ArrayList<Parcelable> data = getIntent().getParcelableArrayListExtra("data");
        int type = getIntent().getIntExtra("type", 46);
        mList.setAdapter(mAdapter);
        mAdapter.setData(type, data);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return super.onTouchEvent(event);
    }
}
