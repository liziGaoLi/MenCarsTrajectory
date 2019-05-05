package com.zhhl.analysis.mvp.view.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zhhl.analysis.R;
//import com.zhhl.analysis.activity.CarTrajectoryAnalysis;
import com.zhhl.analysis.activity.GxrTrajectoryActivity;
import com.zhhl.analysis.activity.TimeSelectActivity;
import com.zhhl.analysis.adapter.GxclAdapter;
import com.zhhl.analysis.adapter.GxrAdapter;
import com.zhhl.analysis.adapter.PersonAnalysisAdapter;
import com.zhhl.analysis.adapter.YearStringAdapter;
import com.zhhl.analysis.common.BaseMvpActivity;
import com.zhhl.analysis.data.GxclData;
import com.zhhl.analysis.data.PersonTrajectory;
import com.zhhl.analysis.data.SelfTrajectoryData;
import com.zhhl.analysis.di.component.AppComponent;
import com.zhhl.analysis.di.component.DaggerPersonTrajectoryAnalysisComponent;
import com.zhhl.analysis.di.module.PersonTrajectoryAnalysisModule;
import com.zhhl.analysis.mvp.contacts.PersonTrajectoryAnalysisContract;
import com.zhhl.analysis.mvp.presenter.PersonTrajectoryAnalysisPresenter;
import com.zhhl.analysis.utils.DateUtil;
import com.zhhl.analysis.utils.DialogUtils;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhhl.analysis.Conts.yearData;


public class PersonTrajectoryAnalysisActivity extends BaseMvpActivity<PersonTrajectoryAnalysisPresenter> implements PersonTrajectoryAnalysisContract.View {
    private boolean self;

    private String sToday;
    private String _3day;
    private String _30day;

    private String start;
    private String end;

    private int date_flag = 1;
    private int gx_flag = 1;
    private int last_data_flag;

    @BindView(R.id.mTrajectoryYear)
    TextView mTrajectoryYear;
    @BindView(R.id.mTrajectoryName)
    TextView mTrajectoryName;
    @BindView(R.id.mTrajectoryPush)
    TextView mTrajectoryPush;
    @BindView(R.id.mTrajectoryList)
    ListView mTrajectoryList;
    @BindView(R.id.nodata)
    TextView nodata;
    @BindView(R.id.nameWrapper)
    ImageView nameWrapper;

    private static final int REQUEST_CODE = 100;
    private final GxrAdapter mGxrAdapter = new GxrAdapter(new ArrayList<>());
    private final GxclAdapter mGxclAdapter = new GxclAdapter(new ArrayList<>());

    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {
        DaggerPersonTrajectoryAnalysisComponent
                .builder()
                .appComponent(appComponent)
                .personTrajectoryAnalysisModule(new PersonTrajectoryAnalysisModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        getIntentData();
        setDate();
        initView2();
        start =_30day;
        end = sToday;
        createRequestDialog();
        clearAdapter();
        mPresenter.getDataRangeWx(start, end);
        mPresenter.getMyTrajectory(start, end);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_trajectory_analysis;
    }


    @Override
    public void showRequestDialog() {
        if (!dialog.isShowing())
            dialog.show();
    }

    @Override
    public void dismissRequestDialog() {
        dialog.dismiss();
    }

    @Override
    public void addData(ArrayList<PersonTrajectory> data) {
        adapter.add(data);
        mTrajectoryList.setAdapter(adapter);
        dismiss(adapter.getData());
    }

    private void setDate() {
        sToday = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis());
        _3day = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - 2L * 24 * 3600 * 1000);
        _30day = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000);
    }

    private void createRequestDialog() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在检索数据,请稍后....");
        dialog.setCancelable(false);
    }

    private void getIntentData() {
        String idNumber = getIntent().getStringExtra("idNumber");
        self = getIntent().getBooleanExtra("self", true);
        mPresenter.setIdNumber(idNumber);
    }

    @Override
    public void setTrajectoryName(String xm) {
        mTrajectoryName.setText(xm);
    }

    @Override
    public void clearAdapter() {
        adapter.clear();
        mTrajectoryList.setAdapter(adapter);
    }

    @Override
    public void setExceptionPerson(boolean isException) {
        mTrajectoryName.setTextColor(getResources().getColor( isException? android.R.color.holo_red_light  : android.R.color.white));
    }

    @Override
    public void setGxrAdapter(ArrayList<PersonTrajectory> transitionWrapper) {
        mGxrAdapter.setData(transitionWrapper);
        mTrajectoryList.setAdapter(mGxrAdapter);
        dismiss(mGxrAdapter.getData());
    }

    @Override
    public void setGxclAdapter(GxclData o) {
        mGxclAdapter.setData(new ArrayList<>(o.getQscl()));
        mTrajectoryList.setAdapter(mGxclAdapter);
        dismiss(mGxclAdapter.getData());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            start = data.getStringExtra("start");
            end = data.getStringExtra("end");
            dialog.setMessage("正在检索数据,请稍后....");
//            dialog.setMessage(BuildConfig.useTitle ? "当前检索数据量较大,请耐心等待" : "查询结果慢，请等待1~2分钟");
            invokeGx2(start, end);
            dismiss(adapter.getData());
        } else if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
            parseLastFlag();
            dialog.setMessage("正在检索数据,请稍后....");
            Toast.makeText(this, "您取消了自定义时间查询", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.nameWrapper)
    public void nameClick() {
//        if (mPresenter.getRenkou() == null) {
//            if (mProgress == null) mProgress = DialogUtils.createProgressDialog(this, "正在设置数据,请稍候");
//            mProgress.show();
//            return;
//        }
        showUserData();
    }

    @OnClick(R.id.mTrajectoryYear)
    void onYearPress() {
        popupWindow.showAsDropDown(mTrajectoryYear);
    }

    @OnClick({R.id.mTrajectoryPush})
    void onPush() {
        popupWindow2.showAsDropDown(mTrajectoryPush);
    }

    private void dismiss(ArrayList data) {
        noDataIfNeed(data);
    }
    ///////////////////////////////////////////

//    private ProgressDialog mProgress;

    private PopupWindow popupWindow;
    private PopupWindow popupWindow2;

    private ProgressDialog dialog;

    private final PersonAnalysisAdapter adapter = new PersonAnalysisAdapter(new ArrayList<>());
    private final YearStringAdapter years = new YearStringAdapter(new ArrayList<>());

    private void parseLastFlag() {
        mTrajectoryYear.setText(yearData[last_data_flag - 1]);
    }

    private void initView2() {
        years.setData(new ArrayList<>(Arrays.asList(yearData)));
        mTrajectoryYear.setText(yearData[0]);
        View view = View.inflate(this, R.layout.popup_list, null);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mList.setAdapter(this.years);
        viewHolder.mList.setOnItemClickListener((parent, view1, position, id) -> {
            String item = (String) viewHolder.mList.getAdapter().getItem(position);
            mTrajectoryYear.setText(item);
            mTrajectoryList.setSelection(0/*sitem.get(item)*/);
            popupWindow.dismiss();
            last_data_flag = date_flag;
            switch (item) {
                case "当天":
                    date_flag = 1;
                    start = sToday;
                    end = sToday;
                    dialog.setMessage("正在检索数据,请稍后....");
                    invokeGx2(start, end);
                    dismiss(adapter.getData());
                    break;
                case "三天":
                    date_flag = 2;
                    start = _3day;
                    end = sToday;
                    dialog.setMessage("正在检索数据,请稍后....");
                    invokeGx2(start, end);
                    dismiss(adapter.getData());
                    break;
                case "一个月":
                    date_flag = 3;
                    start = _30day;
                    end = sToday;
                    dialog.setMessage("正在检索数据,请稍后....");
                    invokeGx2(start, end);
                    dismiss(adapter.getData());
                    break;
                case "自定义":
                    date_flag = 4;
                    Intent in = new Intent(PersonTrajectoryAnalysisActivity.this, TimeSelectActivity.class).putExtra("isPerson",true);
                    startActivityForResult(in, REQUEST_CODE);
                    break;
            }
        });
        popupWindow = new PopupWindow(view, (int) getResources().getDimension(R.dimen.dp_100), (int) getResources().getDimension(R.dimen.dp_200), true);
        View view2 = View.inflate(this, R.layout.popup_list, null);
        final ViewHolder viewHolder2 = new ViewHolder(view2);
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("本人轨迹");

        if (self) {
            a2.add("关系人轨迹");
            a2.add("关系车辆");
            a2.add("常住地分析");
        }
        viewHolder2.mList.setAdapter(new YearStringAdapter(a2));
        viewHolder2.mList.setOnItemClickListener((parent, view12, position, id) -> {
            String item = (String) viewHolder2.mList.getAdapter().getItem(position);
            mTrajectoryPush.setText(item);
            switch (item) {
                case "本人轨迹":
                    mTrajectoryYear.setVisibility(View.VISIBLE);
                    gx_flag = 1;
                    break;
                case "关系人轨迹":
                    mTrajectoryYear.setVisibility(View.VISIBLE);
                    gx_flag = 2;
                    break;
                case "关系车辆":
                    mTrajectoryYear.setVisibility(View.GONE);
                    gx_flag = 3;
                    break;
                case "常住地分析":
                    mTrajectoryYear.setVisibility(View.VISIBLE);
                    gx_flag = 6;
                    break;
            }
            invokeGx2(start, end);
            popupWindow2.dismiss();
            dismiss(adapter.getData());
        });
        popupWindow2 = new PopupWindow(view2, (int) getResources().getDimension(R.dimen.dp_150), (int) getResources().getDimension(R.dimen.dp_300), true);
        mTrajectoryList.setAdapter(adapter);
        mTrajectoryList.setOnItemClickListener((parent, views, position, id) -> {
            if (gx_flag == 2) {
                int type = mGxrAdapter.getItem(position).getType();
                switch (type) {
                    case 33:
//                        if (false)
                        personTrajectory(type, mGxrAdapter.getItem(position).getHunyin2().getPeioucode());
                        break;
                    case 34:
//                        if (false)
                        personTrajectory(type, mGxrAdapter.getItem(position).getQinshu2().getGmsfhm());
                        break;
                    case 46:
                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getHbtx2());
                        break;
                    case 47:
                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getHctx2());
                        break;
                    case 48:
                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getKctx2());
                        break;
                    case 49:
                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getZstx2());
                        break;
                    case 50:
                        personTrajectoryTx(type, mGxrAdapter.getItem(position).getHclz2());
                        break;
                }
            } else if (gx_flag == 3) {
                Intent i = new Intent(PersonTrajectoryAnalysisActivity.this, CarTrajectoryAnalysisActivity.class);
                i.putExtra("idNumber", mGxclAdapter.getItem(position).getJdchphm());
                startActivity(i);
            }
        });
    }

    private void personTrajectoryTx(int type, ArrayList<? extends Parcelable> o) {
        startActivity(
                new Intent(this, GxrTrajectoryActivity.class)
                        .putExtra("type", type)
                        .putExtra("self", false)
                        .putExtra("data", o));
    }

    private void personTrajectory(int type, String idNumber) {
        startActivity(new Intent(this, PersonTrajectoryAnalysisActivity.class).putExtra("type", type).putExtra("self", false).putExtra("idNumber", idNumber));
    }

    private void invokeGx2(String start, String end) {
        switch (gx_flag) {
            case 1:
                clearAdapter();
                mPresenter.getDataRangeWx(start, end);
                mPresenter.getMyTrajectory(start, end);
                break;
            case 2:
                clearAdapter();
                mPresenter.getGxrTrajectory2(start, end);
                break;
            case 3:
                clearAdapter();
                mPresenter.getGxclTrajectory();
                break;
            case 6:
                clearAdapter();
                mPresenter.getChangQuDi(start, end);
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    static class ViewHolder {
        @BindView(R.id.mList)
        ListView mList;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private void showUserData() {
        if (self) {
            if (mPresenter.getRenkou() != null && mPresenter.getRenkou().size() > 0) {
                SelfTrajectoryData.RenkouBean rk = this.mPresenter.getRenkou().get(0);
                DialogUtils.create(this, R.layout.dialog_user_info_2,
                        rk.getXm(),
                        rk.getXbdm(),
                        rk.getMzdm(),
                        rk.getXldm(),
                        rk.getGmsfhm(),
                        rk.getDzmc(),
                        mPresenter.getRylb(),
                        mPresenter.getLadw(),
                        mPresenter.getCarInfos()).show();
//                startActivity(new Intent(this, UserInfoActivity.class).putExtra("rk", rk).putExtra("carInfo", mPresenter.getCarInfos()));
            }
        }
    }

    private void noDataIfNeed(ArrayList data) {
        if (data.size() == 0) {
            nodata.setVisibility(View.VISIBLE);
        } else {
            nodata.setVisibility(View.GONE);
        }
    }
}