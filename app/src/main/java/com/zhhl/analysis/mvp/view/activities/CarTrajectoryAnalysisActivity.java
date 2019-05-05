package com.zhhl.analysis.mvp.view.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zhhl.analysis.R;
import com.zhhl.analysis.activity.TimeSelectActivity;
import com.zhhl.analysis.adapter.TrajectoryCarAdapter;
import com.zhhl.analysis.adapter.YearStringAdapter;
import com.zhhl.analysis.common.BaseMvpActivity;
import com.zhhl.analysis.data.CarInformation;
import com.zhhl.analysis.data.CarTrajectory;
import com.zhhl.analysis.di.component.AppComponent;
import com.zhhl.analysis.di.component.DaggerCarTrajectoryAnalysisComponent;
import com.zhhl.analysis.di.module.CarTrajectoryAnalysisModule;
import com.zhhl.analysis.mvp.contacts.CarTrajectoryAnalysisContact;
import com.zhhl.analysis.mvp.presenter.CarTrajectoryAnalysisPresenter;
import com.zhhl.analysis.utils.DateUtil;
import com.zhhl.analysis.utils.DialogUtils;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by miao on 2019/2/28.
 */

public class CarTrajectoryAnalysisActivity extends BaseMvpActivity<CarTrajectoryAnalysisPresenter> implements CarTrajectoryAnalysisContact.View {

    @BindView(R.id.mTrajectoryYear)
    TextView mTrajectoryYear;
    @BindView(R.id.mTrajectoryName)
    TextView mTrajectoryName;
    @BindView(R.id.mTrajectoryPush)
    TextView mTrajectoryPush;
    @BindView(R.id.mTrajectoryList)
    ListView mTrajectoryList;
    @BindView(R.id.nodata)
    TextView noData;

    private String idNumber;

    private ProgressDialog dialog;

    private final TrajectoryCarAdapter adapter = new TrajectoryCarAdapter(new ArrayList<>());
    private PopupWindow popupWindow;
    private PopupWindow popupWindow2;
    private int date_flag;
    private static final int REQUEST_CODE = 101;

    private String aMonthAgo;
    private String today;
    private boolean ready;
    private CarInformation carInformation;

    @Override
    protected void initData() {
        getIntentData();
        createDialog();
        setData();
        init2();
        mPresenter.requestOneDay();
        mPresenter.getCarInformation();
        dialog.show();
    }


    private void setData() {
        mTrajectoryName.setText(idNumber);
        mTrajectoryList.setAdapter(adapter);
        aMonthAgo = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - (30L * 24 * 60 * 60 * 1000));
        today = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis());
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_trajectory_analysis_car;
    }

    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
        DaggerCarTrajectoryAnalysisComponent
                .builder()
                .appComponent(appComponent)
                .carTrajectoryAnalysisModule(new CarTrajectoryAnalysisModule(this)) //请将CarTrajectoryAnalysisModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.mTrajectoryYear)
    void onYearPress() {
        popupWindow.showAsDropDown(mTrajectoryYear);
    }

    @OnClick({R.id.mTrajectoryPush})
    void onPush() {
        popupWindow2.showAsDropDown(mTrajectoryPush);
    }

    @OnClick(R.id.mTrajectoryName)
    void showCarInfo() {
        if (ready && carInformation.getCheliang().size() > 0) {
            CarInformation.CheliangBean carInfoData = carInformation.getCheliang().get(0);
            AlertDialog carInfo = DialogUtils.carInfo(this, carInfoData.getJdcsyrJdcsyrmc(), carInfoData.getJdcsyrJtglywdxsfzmhm(), carInfoData.getZwppmc() + carInfoData.getJdccllxdm(), carInfoData.getJdccsysdm().trim() + "色", carInfoData.getJdcsyrLxdh());
            carInfo.show();
        }
    }

    private void init2() {
        View view = View.inflate(this, R.layout.popup_list, null);
        final CarTrajectoryAnalysisActivity.ViewHolder viewHolder = new CarTrajectoryAnalysisActivity.ViewHolder(view);
        YearStringAdapter years = new YearStringAdapter(mPresenter.getDateRange());
        mTrajectoryYear.setText(years.getData().get(0));
        viewHolder.mList.setAdapter(years);
        viewHolder.mList.setOnItemClickListener((parent, view1, position, id) -> {
            String item = (String) viewHolder.mList.getAdapter().getItem(position);
            switch (item) {
                case "当天":
                    resetDateFlag(1);
                    adapter.clear();
                    mPresenter.requestOneDay();
                    break;
                case "三天":
                    resetDateFlag(2);
                    adapter.clear();
                    mPresenter.requestThreeDay();
                    break;
                case "一个月":
                    resetDateFlag(3);
                    adapter.clear();
                    mPresenter.customDateTrajectory(idNumber, aMonthAgo, today);
                    break;
                case "自定义":
                    resetDateFlag(4);
                    Intent intent = new Intent(CarTrajectoryAnalysisActivity.this, TimeSelectActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                    break;
            }
            mTrajectoryYear.setText(item);
            popupWindow.dismiss();
            mTrajectoryList.setSelection(0);
            if (!item.equals("自定义")) {
                dialog.show();
            }
        });
        popupWindow = new PopupWindow(view, (int) getResources().getDimension(R.dimen.dp_100), (int) getResources().getDimension(R.dimen.dp_200), true);
        View view2 = View.inflate(this, R.layout.popup_list, null);

        final CarTrajectoryAnalysisActivity.ViewHolder viewHolder2 = new CarTrajectoryAnalysisActivity.ViewHolder(view2);
        viewHolder2.mList.setAdapter(new YearStringAdapter(mPresenter.getTypeName()));
        viewHolder2.mList.setOnItemClickListener((parent, view12, position, id) -> {
            String item = (String) viewHolder2.mList.getAdapter().getItem(position);
            switch (item) {
                case "全部":
//                    adapter.setData(CarTrajectoryAnalysisActivity.this.all);
                    break;
                case "本人车辆":
//                    adapter.setData(brcl);
                    break;
                case "关系车辆":
//                    adapter.setData(gxcl);
                    break;
                case "代扣分车辆":
//                    adapter.setData(dkfcl);
                    break;
            }
            Collections.sort(adapter.getData());
            if (years.getData().size() > 0)
                mTrajectoryYear.setText(years.getItem(0));
            mTrajectoryList.setSelection(0);
            mTrajectoryPush.setText(item);
            popupWindow2.dismiss();
        });
        popupWindow2 = new PopupWindow(view2, (int) getResources().getDimension(R.dimen.dp_100), (int) getResources().getDimension(R.dimen.dp_200), true);
    }

    private void resetDateFlag(int flag) {
        last_data_flag = date_flag;
        date_flag = flag;
    }

    private int last_data_flag;

    private void parseLastFlag() {
        switch (last_data_flag) {
            case 1:
                mTrajectoryYear.setText("当天");
                break;
            case 2:
                mTrajectoryYear.setText("三天");
                break;
            case 3:
                mTrajectoryYear.setText("一个月");
                break;
            case 4:
                mTrajectoryYear.setText("自定义");
                break;
        }

    }

    private void getIntentData() {
        idNumber = getIntent().getStringExtra("idNumber");
        mPresenter.setIdNumber(idNumber);
    }

    private void createDialog() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在检索数据,请稍后....");
        dialog.setCancelable(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String start = data.getStringExtra("start");
            String end = data.getStringExtra("end");
            dialog.show();
            mPresenter.customDateTrajectory(idNumber, start, end);
        } else if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
            parseLastFlag();
            Toast.makeText(this, "您取消了自定义时间查询", Toast.LENGTH_SHORT).show();
        }
    }

    private void noDataIfNeed() {
        if (adapter.getCount() == 0) {
            noData.setVisibility(View.VISIBLE);
        } else {
            noData.setVisibility(View.GONE);
        }
    }

    @Override
    public void putData(CarInformation o) {
        ready = true;
        this.carInformation = o;
    }

    @Override
    public void changeData(ArrayList<CarTrajectory> mData) {
        adapter.addData(mData);
        noDataIfNeed();
    }

    @Override
    public void dialogDismiss() {
        dialog.dismiss();
    }

    static class ViewHolder {
        @BindView(R.id.mList)
        ListView mList;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

}