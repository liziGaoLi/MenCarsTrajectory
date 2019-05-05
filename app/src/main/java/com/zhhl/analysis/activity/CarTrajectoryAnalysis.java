//package com.zhhl.analysis.activity;
//
//import android.app.AlertDialog;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ListView;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.zhhl.analysis.R;
//import com.zhhl.analysis.adapter.TrajectoryCarAdapter;
//import com.zhhl.analysis.adapter.YearStringAdapter;
//import com.zhhl.analysis.app.App;
//import com.zhhl.analysis.data.CarInformation;
//import com.zhhl.analysis.data.CarTrajectory;
//import com.zhhl.analysis.data.CarTrajectoryBayonet;
//import com.zhhl.analysis.net.HttpTools;
//import com.zhhl.analysis.net.IModel;
//import com.zhhl.analysis.net.ITrajectoryAnalysis;
//import com.zhhl.analysis.utils.DateUtil;
//import com.zhhl.analysis.utils.DialogUtils;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//
//import androidx.annotation.Nullable;
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
///**
// * Created by miao on 2018/10/26.
// */
//public class CarTrajectoryAnalysis extends BaseActivity {
//
//    public static final String ACTION = "com.zhhl.activity.TrajectoryAnalysis";
//
//    private int requestCounter = 0;
//
//    private CarInformation carInformation;
//
//    private boolean ready;
//    @BindView(R.id.mTrajectoryYear)
//    TextView mTrajectoryYear;
//    @BindView(R.id.mTrajectoryName)
//    TextView mTrajectoryName;
//    @BindView(R.id.mTrajectoryPush)
//    TextView mTrajectoryPush;
//    @BindView(R.id.mTrajectoryList)
//    ListView mTrajectoryList;
//    @BindView(R.id.nodata)
//    TextView noData;
//    private final YearStringAdapter years = new YearStringAdapter(new ArrayList<>());
//    private PopupWindow popupWindow;
//    private PopupWindow popupWindow2;
//    private final YearStringAdapter carName = new YearStringAdapter(new ArrayList<>());
//    private int date_flag;
//    private static final int REQUEST_CODE = 101;
//    private final ArrayList<CarTrajectory> all = new ArrayList<>();
//    private final ArrayList<CarTrajectory> brcl = new ArrayList<>();
//    private final ArrayList<CarTrajectory> gxcl = new ArrayList<>();
//    private final ArrayList<CarTrajectory> dkfcl = new ArrayList<>();
//
//    private String idNumber;
//    private final ArrayList<CarTrajectory> brcl_sj = new ArrayList<>();
//
//    private final TrajectoryCarAdapter adapter = new TrajectoryCarAdapter(new ArrayList<>());
//    private ProgressDialog dialog;
//
//    private IModel iModel;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this);
//        iModel = HttpTools.buildGuiji();
//        dialog = new ProgressDialog(this);
//        dialog.setMessage("正在检索数据,请稍后....");
//        dialog.setCancelable(false);
//        dialog.show();
//
//        idNumber = getIntent().getStringExtra("idNumber");
//        getCarInformation();
//        mTrajectoryName.setText(idNumber);
//        View view = View.inflate(this, R.layout.popup_list, null);
//        final ViewHolder viewHolder = new ViewHolder(view);
//        ArrayList<String> dataYear = new ArrayList<>();
//        dataYear.add("当天");
//        dataYear.add("三天");
////        dataYear.add("一个月");
//        dataYear.add("自定义");
//
//        years.setData(dataYear);
//        mTrajectoryYear.setText(dataYear.get(0));
//        viewHolder.mList.setAdapter(years);
//        viewHolder.mList.setOnItemClickListener((parent, view1, position, id) -> {
//            adapter.clear();
//            String item = (String) viewHolder.mList.getAdapter().getItem(position);
//            String from;
//            String to = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis());
//            switch (item) {
//                case "当天":
//                    last_data_flag = date_flag;
//                    date_flag = 1;
//                    dialog.setMessage("正在检索数据,请稍后....");
//                    reqOneDay();
//                    break;
//                case "三天":
//                    last_data_flag = date_flag;
//                    date_flag = 2;
//                    dialog.setMessage("正在检索数据,请稍后....");
//                    reqThreeDay();
//                    break;
//                case "一个月":
//                    last_data_flag = date_flag;
//                    date_flag = 3;
//                    from = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - (30L * 24 * 60 * 60 * 1000));
//                    dialog.setMessage("正在检索数据,请稍后....");
//                    getCarT(idNumber, from, to);
//                    break;
//                case "自定义":
//                    last_data_flag = date_flag;
//                    date_flag = 4;
//                    Intent intent = new Intent(CarTrajectoryAnalysis.this, TimeSelectActivity.class);
//                    startActivityForResult(intent, REQUEST_CODE);
//                    break;
//            }
//            mTrajectoryYear.setText(item);
//            popupWindow.dismiss();
//            mTrajectoryList.setSelection(0);
//            dismiss();
//        });
//        popupWindow = new PopupWindow(view, (int) getResources().getDimension(R.dimen.dp_100), (int) getResources().getDimension(R.dimen.dp_200), true);
//        View view2 = View.inflate(this, R.layout.popup_list, null);
//
//
//        final ViewHolder viewHolder2 = new ViewHolder(view2);
//        ArrayList<String> all = new ArrayList<>();
//        all.add("全部");
//        all.add("本人车辆");
//        all.add("关系车辆");
//        all.add("代扣分车辆");
//        carName.addData(all);
//        viewHolder2.mList.setAdapter(carName);
//        viewHolder2.mList.setOnItemClickListener((parent, view12, position, id) -> {
//            String item = (String) viewHolder2.mList.getAdapter().getItem(position);
//            switch (item) {
//                case "全部":
//                    adapter.setData(CarTrajectoryAnalysis.this.all);
//                    break;
//                case "本人车辆":
//                    adapter.setData(brcl);
//                    break;
//                case "关系车辆":
//                    adapter.setData(gxcl);
//                    break;
//                case "代扣分车辆":
//                    adapter.setData(dkfcl);
//                    break;
//            }
//            Collections.sort(adapter.getData());
////                parseData(adapter.getData());
//            if (years.getData().size() > 0)
//                mTrajectoryYear.setText(years.getItem(0));
//            mTrajectoryList.setSelection(0);
//            mTrajectoryPush.setText(item);
//            popupWindow2.dismiss();
//
//            nodataIfNeed();
//        });
//        popupWindow2 = new PopupWindow(view2, (int) getResources().getDimension(R.dimen.dp_100), (int) getResources().getDimension(R.dimen.dp_200), true);
//        reqOneDay();
//        mTrajectoryList.setAdapter(adapter);
//
//    }
//
//    private void getCarInformation() {
//        iModel.carInformation(idNumber)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::carInfo, this::onError, this::onComplete)
//                .isDisposed();
//
//
//    }
//
//    private void carInfo(CarInformation o) {
//        ready = true;
//        this.carInformation = o;
//    }
//
//    private void reqThreeDay() {
//        ITrajectoryAnalysis build = HttpTools.build(ITrajectoryAnalysis.class);
//        requestCounter++;
//        build.carTrajectory(idNumber,/* today, today*/App.app().getUserInfo().getUserInfo().getCode()).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::myCarBayonet, this::onError, () -> {
//                }).isDisposed();
//    }
//
//    private void reqOneDay() {
//        ITrajectoryAnalysis build = HttpTools.build(ITrajectoryAnalysis.class);
//        requestCounter++;
//        build.carTrajectory(idNumber,/* today, today*/App.app().getUserInfo().getUserInfo().getCode()).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::myCarBayonetOneDay, this::onError, () -> {
//                }).isDisposed();
//    }
//
//    private void myCarBayonetOneDay(CarTrajectoryBayonet carTrajectoryBayonet) {
//        requestCounter--;
//        if (carTrajectoryBayonet.isSuccess() && carTrajectoryBayonet.getObj() != null) {
//            List<CarTrajectoryBayonet.ObjBean> obj = carTrajectoryBayonet.getObj();
//            ArrayList<CarTrajectory> mData = new ArrayList<>();
//            for (int i = 0; i < obj.size(); i++) {
//                CarTrajectory carTrajectory = new CarTrajectory(obj.get(i));
//                if (carTrajectory.getTime() >= DateUtil.parseDate("yyyy-MM-dd", DateUtil.format("yyyy-MM-dd", System.currentTimeMillis()))) {
//                    mData.add(carTrajectory);
//                }
//            }
//
//            brcl.addAll(mData);
//            all.addAll(mData);
//            adapter.addData(mData);
//        } else {
//            if (carTrajectoryBayonet.getMsg().contains("ORA-")) {
//                Toast.makeText(this, "数据读取异常,请稍后再试", Toast.LENGTH_SHORT).show();
//            }
//        }
//        dismiss();
//
//    }
//
//    @Override
//    public int getContentRes() {
//        return R.layout.activity_trajectory_analysis_car;
//    }
//
//    private int last_data_flag;
//
//    @OnClick(R.id.mTrajectoryName)
//    void showCarInfo() {
//        if (ready && carInformation.getCheliang().size() > 0) {
//            CarInformation.CheliangBean carInfoData = carInformation.getCheliang().get(0);
//            AlertDialog carInfo = DialogUtils.carInfo(this, carInfoData.getJdcsyrJdcsyrmc(), carInfoData.getJdcsyrJtglywdxsfzmhm(), carInfoData.getZwppmc() + carInfoData.getJdccllxdm(), carInfoData.getJdccsysdm().trim() + "色", carInfoData.getJdcsyrLxdh());
//            carInfo.show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//            String start = data.getStringExtra("start");
//            String end = data.getStringExtra("end");
//            dialog.setMessage("正在检索数据,请稍后....");
//            getCarT(idNumber, start, end);
//            dismiss();
//        } else if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
//            parseLastFlag();
//            dialog.setMessage("正在检索数据,请稍后....");
//            Toast.makeText(this, "您取消了自定义时间查询", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void parseLastFlag() {
//
//        switch (last_data_flag) {
//            case 1:
//                mTrajectoryYear.setText("当天");
//                break;
//            case 2:
//                mTrajectoryYear.setText("三天");
//                break;
//            case 3:
//                mTrajectoryYear.setText("一个月");
//                break;
//            case 4:
//                mTrajectoryYear.setText("自定义");
//                break;
//        }
//
//    }
//
//    private void getCarT(String idNumber, String from, String to) {
//        ITrajectoryAnalysis i = HttpTools.build(ITrajectoryAnalysis.class);
//        requestCounter++;
//        i.carTrajectory(idNumber, from, to)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(CarTrajectoryAnalysis.this::myCarBayonet2, CarTrajectoryAnalysis.this::onError, () -> {
//                })
//                .isDisposed();
//    }
//
//    private void myCarBayonet2(CarTrajectoryBayonet carTrajectoryBayonet) {
//        requestCounter--;
//        brcl_sj.clear();
//        if (carTrajectoryBayonet.isSuccess()) {
//            List<CarTrajectoryBayonet.ObjBean> obj = carTrajectoryBayonet.getObj();
//            ArrayList<CarTrajectory> mData = new ArrayList<>();
//            for (int i = 0; i < obj.size(); i++) {
//                mData.add(new CarTrajectory(obj.get(i)));
//                mTrajectoryName.setText(obj.get(i).getHphm());
//            }
//            brcl_sj.addAll(mData);
//            Collections.sort(brcl_sj);
//            adapter.setData(brcl_sj);
//        } else {
//            if (carTrajectoryBayonet.getMsg().contains("ORA-")) {
//                Toast.makeText(this, "数据读取异常,请稍后再试", Toast.LENGTH_SHORT).show();
//            }
//        }
//        dismiss();
//    }
//
//
//    private void dismiss() {
//        if (requestCounter == 0) {
//            dialog.dismiss();
//            nodataIfNeed();
//        } else {
//            dialog.show();
//        }
//    }
//
//    private void myCarBayonet(CarTrajectoryBayonet carTrajectoryBayonet) {
//        requestCounter--;
//        if (carTrajectoryBayonet.isSuccess() && carTrajectoryBayonet.getObj() != null) {
//            List<CarTrajectoryBayonet.ObjBean> obj = carTrajectoryBayonet.getObj();
//            ArrayList<CarTrajectory> mData = new ArrayList<>();
//            for (int i = 0; i < obj.size(); i++) {
//                mData.add(new CarTrajectory(obj.get(i)));
//                mTrajectoryName.setText(obj.get(i).getHphm());
//            }
//
//            brcl.addAll(mData);
//            all.addAll(mData);
//            adapter.addData(mData);
//        } else {
//            if (carTrajectoryBayonet.getMsg().contains("ORA-")) {
//                Toast.makeText(this, "数据读取异常,请稍后再试", Toast.LENGTH_SHORT).show();
//            }
//        }
//        dismiss();
//    }
//
//    private void onComplete() {
//
//    }
//
//    private final HashMap<String, Integer> sitem = new HashMap<>();
//
//
//    @OnClick(R.id.mTrajectoryYear)
//    void onYearPress() {
//        popupWindow.showAsDropDown(mTrajectoryYear);
//    }
//
//    @OnClick({R.id.mTrajectoryPush})
//    void onPush() {
//        popupWindow2.showAsDropDown(mTrajectoryPush);
//    }
//
//    private void nodataIfNeed() {
//        if (adapter.getCount() == 0) {
//            noData.setVisibility(View.VISIBLE);
//        } else {
//            noData.setVisibility(View.GONE);
//        }
//    }
//
//    static class ViewHolder {
//        @BindView(R.id.mList)
//        ListView mList;
//
//        ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//    }
//
//    @Override
//    void onError(Throwable t) {
//        super.onError(t);
//        requestCounter--;
//        dismiss();
//    }
//}
//
//
//
