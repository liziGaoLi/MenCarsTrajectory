//package com.zhhl.analysis.activity;
//
//import android.app.AlertDialog;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.zhhl.analysis.R;
//import com.zhhl.analysis.adapter.PersonAnalysisAdapter;
//import com.zhhl.analysis.adapter.YearStringAdapter;
//import com.zhhl.analysis.data.ChangQuDiData;
//import com.zhhl.analysis.data.GuijiCQDWrapper;
//import com.zhhl.analysis.data.GxrData;
//import com.zhhl.analysis.data.PersonCars;
//import com.zhhl.analysis.data.PersonTrajectory;
//import com.zhhl.analysis.data.PersonTrajectoryHouse;
//import com.zhhl.analysis.data.PersonTrajectoryNoId;
//import com.zhhl.analysis.data.PersonTrajectorySZQY;
//import com.zhhl.analysis.data.PersonTrajectoryUnLock;
//import com.zhhl.analysis.data.SimpleCarInfo;
//import com.zhhl.analysis.data.HunyinGuiji;
//import com.zhhl.analysis.data.SelfTrajectoryData;
//import com.zhhl.analysis.net.HttpTools;
//import com.zhhl.analysis.net.IModel;
//import com.zhhl.analysis.net.ITrajectoryAnalysis;
//import com.zhhl.analysis.utils.DateUtil;
//import com.zhhl.analysis.utils.DialogUtils;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class TrajectoryAnalysis extends BaseActivity {
//
//
//    @BindView(R.id.nameWrapper)
//    ImageView nameWrapper;
//    private int date_flag = 1;
//    private int gx_flag = 1;
//
//    private int last_data_flag;
//
//    private ProgressDialog mProgress;
//
//    private int requestCounter = 0;
//    public static final String ACTION = "com.zhhl.activity.TrajectoryAmalysis";
//    @BindView(R.id.mTrajectoryYear)
//    TextView mTrajectoryYear;
//    @BindView(R.id.mTrajectoryName)
//    TextView mTrajectoryName;
//    @BindView(R.id.mTrajectoryPush)
//    TextView mTrajectoryPush;
//    @BindView(R.id.mTrajectoryList)
//    ListView mTrajectoryList;
//    @BindView(R.id.nodata)
//    TextView nodata;
//    private PopupWindow popupWindow;
//    private PopupWindow popupWindow2;
//
//    private ProgressDialog dialog;
//    private IModel iLocal;
//
//
//    private List<SelfTrajectoryData.RenkouBean> renkouBean;
//
//    private final ArrayList<PersonTrajectory> st_br = new ArrayList<>();
//    private final ArrayList<PersonTrajectory> gxr = new ArrayList<>();
//    private ArrayList<PersonTrajectory> czd = new ArrayList<>();
//    private final ArrayList<PersonTrajectory> gxcl = new ArrayList<>();
//
//    private final ArrayList<PersonTrajectory> ext_gxr = new ArrayList<>();
//
//    private final ArrayList<PersonCars.ObjBean> myCars = new ArrayList<>();
//    private final PersonAnalysisAdapter adapter = new PersonAnalysisAdapter(new ArrayList<>());
//    private final YearStringAdapter years = new YearStringAdapter(new ArrayList<>());
//
//    private String idNumber;
//
//    private boolean self;
//
//    private static final int REQUEST_CODE = 100;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this);
//        idNumber = getIntent().getStringExtra("idNumber");
//        self = getIntent().getBooleanExtra("self", true);
//        initView();
//        start = sToday;
//        end = sToday;
//        toQuery(start, end);
//    }
//
//    @Override
//    public int getContentRes() {
//        return R.layout.activity_trajectory_analysis;
//    }
//
//
//    private String sToday;
//    private String _3day;
//    private String _30day;
//
//
//    private String start;
//    private String end;
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//            start = data.getStringExtra("start");
//            end = data.getStringExtra("end");
//            invokeGx2(start, end);
//            dismiss(adapter.getData());
//        } else if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
//            parseLastFlag();
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
//    private void initView() {
//        iLocal = HttpTools.buildGuiji();
//        dialog = new ProgressDialog(this);
//        dialog.setMessage("正在加载,请稍后....");
//        dialog.setCancelable(false);
//        dialog.show();
//
//        sToday = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis());
//        _3day = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - 2L * 24 * 3600 * 1000);
//        _30day = DateUtil.format("yyyy-MM-dd", System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000);
//
//        ArrayList<String> dataYear = new ArrayList<>();
//        dataYear.add("当天");
//        dataYear.add("三天");
//        dataYear.add("一个月");
//        dataYear.add("自定义");
//
//        years.setData(dataYear);
//        mTrajectoryYear.setText(dataYear.get(0));
//        View view = View.inflate(this, R.layout.popup_list, null);
//        final ViewHolder viewHolder = new ViewHolder(view);
//
//        viewHolder.mList.setAdapter(this.years);
//        viewHolder.mList.setOnItemClickListener((parent, view1, position, id) -> {
//            String item = (String) viewHolder.mList.getAdapter().getItem(position);
//            mTrajectoryYear.setText(item);
//            mTrajectoryList.setSelection(0/*sitem.get(item)*/);
//            popupWindow.dismiss();
//            last_data_flag = date_flag;
//            switch (item) {
//                case "当天":
//                    date_flag = 1;
//                    start = sToday;
//                    end = sToday;
//                    invokeGx2(start, end);
//                    dismiss(adapter.getData());
//                    break;
//                case "三天":
//                    date_flag = 2;
//                    start = _3day;
//                    end = sToday;
//                    invokeGx2(start, end);
//                    dismiss(adapter.getData());
//                    break;
//                case "一个月":
//                    date_flag = 3;
//                    start = _30day;
//                    end = sToday;
//                    invokeGx2(start, end);
//                    dismiss(adapter.getData());
//                    break;
//                case "自定义":
//                    date_flag = 4;
//                    Intent in = new Intent(TrajectoryAnalysis.this, TimeSelectActivity.class);
//                    startActivityForResult(in, REQUEST_CODE);
//                    break;
//
//            }
//
//        });
//        popupWindow = new PopupWindow(view, (int) getResources().getDimension(R.dimen.dp_100), (int) getResources().getDimension(R.dimen.dp_200), true);
//        View view2 = View.inflate(this, R.layout.popup_list, null);
//        final ViewHolder viewHolder2 = new ViewHolder(view2);
//        ArrayList<String> a2 = new ArrayList<>();
//        a2.add("本人轨迹");
//
//        if (self) {
//            a2.add("关系人轨迹");
//            a2.add("关系车辆");
//            a2.add("常住地分析");
//        }
//        viewHolder2.mList.setAdapter(new YearStringAdapter(a2));
//        viewHolder2.mList.setOnItemClickListener((parent, view13, position, id) -> {
//            String item = (String) viewHolder2.mList.getAdapter().getItem(position);
//            mTrajectoryPush.setText(item);
//            switch (item) {
//                case "本人轨迹":
//                    gx_flag = 1;
//                    break;
//                case "关系人轨迹":
//                    gx_flag = 2;
//                    break;
//                case "关系车辆":
//                    gx_flag = 3;
//                    break;
//                case "常住地分析":
//                    gx_flag = 6;
//                    break;
//            }
//            invokeGx2(start, end);
//
//            popupWindow2.dismiss();
//            dismiss(adapter.getData());
//        });
//        popupWindow2 = new PopupWindow(view2, (int) getResources().getDimension(R.dimen.dp_150), (int) getResources().getDimension(R.dimen.dp_300), true);
//        mTrajectoryList.setAdapter(adapter);
//        mTrajectoryList.setOnItemClickListener((parent, view12, position, id) -> {
//            int type = adapter.getItem(position).getType();
////                if (self && type >= 31 && type < 40) {
//            Intent i;
//            switch (type) {
//                case 31:
//                    i = new Intent(TrajectoryAnalysis.this, TrajectoryAnalysis.class);
//                    i.putExtra("type", type);
//                    i.putExtra("self", false);
//                    i.putExtra("idNumber", adapter.getItem(position).getHunyin().getPeioucode());
//                    startActivity(i);
//                    break;
//                case 32:
//                    i = new Intent(TrajectoryAnalysis.this, TrajectoryAnalysis.class);
//                    i.putExtra("type", type);
//                    i.putExtra("self", false);
//                    i.putExtra("idNumber", adapter.getItem(position).getQinshu().getGmsfhm());
//                    startActivity(i);
//                    break;
//                case 41:
//                    i = new Intent(TrajectoryAnalysis.this, TrajectoryAnalysis.class);
//                    i.putExtra("type", type);
//                    i.putExtra("self", false);
//                    i.putExtra("idNumber", adapter.getItem(position).getHbtx().getIdcode());
//                    startActivity(i);
//                    break;
//                case 42:
//                    i = new Intent(TrajectoryAnalysis.this, TrajectoryAnalysis.class);
//                    i.putExtra("type", type);
//                    i.putExtra("self", false);
//                    i.putExtra("idNumber", adapter.getItem(position).getHctx().getHctxid());
//                    startActivity(i);
//                    break;
//                case 43:
//                    i = new Intent(TrajectoryAnalysis.this, TrajectoryAnalysis.class);
//                    i.putExtra("type", type);
//                    i.putExtra("self", false);
//                    i.putExtra("idNumber", adapter.getItem(position).getKctx().getIdcode());
//                    startActivity(i);
//                    break;
//                case 44:
//                    i = new Intent(TrajectoryAnalysis.this, TrajectoryAnalysis.class);
//                    i.putExtra("type", type);
//                    i.putExtra("self", false);
//                    i.putExtra("idNumber", adapter.getItem(position).getWbtx().getIdcode());
//                    startActivity(i);
//                    break;
//                case 45:
//                    i = new Intent(TrajectoryAnalysis.this, TrajectoryAnalysis.class);
//                    i.putExtra("type", type);
//                    i.putExtra("self", false);
//                    i.putExtra("idNumber", adapter.getItem(position).getZstx().getZsfzh());
//                    startActivity(i);
//                    break;
//                case 51:
//                    i = new Intent(TrajectoryAnalysis.this, CarTrajectoryAnalysis.class);
//                    i.putExtra("idNumber", adapter.getItem(position).getCarInfo().getCarCode());
//                    startActivity(i);
//                    break;
//            }
//
////                }
//        });
//    }
//
//    @OnClick(R.id.nameWrapper)
//    public void nameClick() {
//        if (renkouBean == null) {
//            if (mProgress == null) mProgress = DialogUtils.createProgressDialog(this, "正在设置数据,请稍候");
//            mProgress.show();
//            return;
//        }
//        showUserData();
//    }
//
//    private void invokeGx2(String start, String end) {
//        IModel i = HttpTools.buildGuiji();
//        switch (gx_flag) {
//            case 1:
//                st_br.clear();
////                requestCounter++;
////                i.selfTrajectory(idNumber, start, end, "0")
////                        .observeOn(AndroidSchedulers.mainThread())
////                        .subscribeOn(Schedulers.io())
////                        .subscribe(this::selfGuiji, this::onErr, this::onComplete)
////                        .isDisposed();
//
//                toQuery(start, end);
//                break;
//            case 2:
//                requestCounter++;
//                adapter.setData(parseData2(gxr, date_flag));
//                i.shangfangguiji1(idNumber, start, end, "1")
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribeOn(Schedulers.io())
//                        .subscribe(this::otherGuiji, this::err, this::onComplete)
//                        .isDisposed();
//                requestCounter++;
//                i.guanXiRenGuiji(idNumber).observeOn(AndroidSchedulers.mainThread())
//                        .subscribeOn(Schedulers.io())
//                        .subscribe(this::otherGuiji2, this::err2, this::onComplete)
//                        .isDisposed();
//                break;
//            case 3:
//                requestCounter++;
//                i.selfTrajectory(idNumber, start, end, "2")
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribeOn(Schedulers.io())
//                        .subscribe(this::otherCarGuiji, this::err, this::onComplete)
//                        .isDisposed();
//                break;
//            case 6:
//                requestCounter++;
//                i.frequented(idNumber, start, end, "3")
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribeOn(Schedulers.io())
//                        .subscribe(this::setCQD, this::onErr, this::onComplete)
//                        .isDisposed();
//                break;
//        }
//    }
//
//    private void otherGuiji2(GxrData gxrData) {
//        requestCounter--;
//        ext_gxr.clear();
//        parseGxrData(gxrData);
//    }
//
//    private void parseGxrData(GxrData gxrData) {
//        List<GxrData.HbtxBean> hbtx = gxrData.getHbtx();
//        List<GxrData.HctxBean> hctx = gxrData.getHctx();
//        List<GxrData.QinshuBean> qinshu = gxrData.getQinshu();
//        if (qinshu != null)
//            for (GxrData.QinshuBean qs : qinshu) {
//                if (!qs.getGmsfhm().equals(idNumber)) {
//                    List<GxrData.JdcListBean> jdclists = qs.getJdclist();
//                    if (jdclists != null) {
//                        for (GxrData.JdcListBean jdc : jdclists) {
//                            SimpleCarInfo carInfo = new SimpleCarInfo(jdc.getGajtglfzjgslmc() + jdc.getJdchphm().substring(1), "", jdc.getZwppmc(), "(车主:" + qs.getXm() + ")");
//                            ext_gxr.add(new PersonTrajectory(carInfo));
//                        }
//                    }
//                    ext_gxr.add(new PersonTrajectory(qs));
//                }
//            }
//
//        if (hctx != null)
//            for (GxrData.HctxBean hc : hctx) {
//                ext_gxr.add(new PersonTrajectory(hc));
//            }
//        if (hbtx != null)
//            for (GxrData.HbtxBean hb : hbtx) {
//                ext_gxr.add(new PersonTrajectory(hb));
//            }
//        if (gxrData.getKctx() != null)
//            for (GxrData.KctxBean kc : gxrData.getKctx())
//                ext_gxr.add(new PersonTrajectory(kc));
//        if (gxrData.getWbtx() != null)
//            for (GxrData.WbtxBean wb : gxrData.getWbtx())
//                ext_gxr.add(new PersonTrajectory(wb));
//        if (gxrData.getZstx() != null)
//            for (GxrData.ZstxBean zs : gxrData.getZstx())
//                ext_gxr.add(new PersonTrajectory(zs));
//        Collections.sort(ext_gxr);
//        adapter.addData(ext_gxr);
//        dismiss(adapter.getData());
//    }
//
//
//    private void otherCarGuiji(SelfTrajectoryData shangfangguiji) {
//        requestCounter--;
//        ArrayList<PersonTrajectory> wrappers = transitionWrapper(shangfangguiji);
//        gxcl.clear();
//        this.renkouBean = shangfangguiji.getRenkou();
//        gxcl.addAll(wrappers);
////        st_br.addAll(parseData2(br, date_flag));
//        Collections.sort(gxcl);
//        adapter.setData(gxcl);
//        dialog.dismiss();
//        dismiss(adapter.getData());
//    }
//
//    private void otherGuiji(HunyinGuiji hunyinGuiji) {
//        gxr.clear();
//        requestCounter--;
//        ArrayList<PersonTrajectory> wrappers = transitionWrapper(hunyinGuiji);
//        gxr.clear();
//        ArrayList<HunyinGuiji.HunyinBean> hunyin = new ArrayList<>(hunyinGuiji.getHunyin());
//        for (HunyinGuiji.HunyinBean hy : hunyin)
//            gxr.add(new PersonTrajectory(hy));
//        gxr.addAll(wrappers);
//        Collections.sort(gxr);
//        adapter.addData(gxr);
//        dialog.dismiss();
//        dismiss(adapter.getData());
//
//    }
//
//    private ArrayList<GuijiCQDWrapper> shangwang = new ArrayList<>();
//    private ArrayList<GuijiCQDWrapper> zhudian = new ArrayList<>();
//
//    private void setCQD(ChangQuDiData guiji3) {
//        requestCounter--;
//        shangwang.clear();
//        zhudian.clear();
//        List<ChangQuDiData.ShangwangBean> shangwang = guiji3.getShangwang();
//        for (ChangQuDiData.ShangwangBean sw : shangwang) {
//            GuijiCQDWrapper guijiCQDWrapper = new GuijiCQDWrapper();
//            guijiCQDWrapper.ldmc = sw.getYycsDwmc();
//            guijiCQDWrapper.tj = sw.getTj();
//            this.shangwang.add((guijiCQDWrapper));
//        }
//
//        List<ChangQuDiData.ZhudianTongjiBean> zhudian = guiji3.getZhudian();
//        for (ChangQuDiData.ZhudianTongjiBean sw : zhudian) {
//            GuijiCQDWrapper guijiCQDWrapper = new GuijiCQDWrapper();
//            guijiCQDWrapper.ldmc = sw.getLdMc();
//            guijiCQDWrapper.tj = sw.getTj();
//            this.zhudian.add((guijiCQDWrapper));
//        }
//        Collections.sort(this.shangwang);
//        Collections.sort(this.zhudian);
//        adapter.getData().clear();
//        if (this.shangwang.size() > 3) {
//            this.shangwang = new ArrayList<>(this.shangwang.subList(0, 3));
//        }
//        if (this.zhudian.size() > 3) {
//            this.zhudian = new ArrayList<>(this.zhudian.subList(0, 3));
//        }
//        adapter.add(toTrajectory(this.shangwang));
//        adapter.add(toTrajectory(this.zhudian));
//        dismiss(adapter.getData());
//
//    }
//
//    private ArrayList<PersonTrajectory> toTrajectory(List<GuijiCQDWrapper> source) {
//        ArrayList<PersonTrajectory> dest = new ArrayList<>();
//        for (GuijiCQDWrapper gj : source) {
//            dest.add(new PersonTrajectory(gj));
//        }
//        return dest;
//    }
//
//    private String getBy(int date_flag) {
//        switch (date_flag) {
//            case 1:
//                return sToday;
//            case 2:
//                return _3day;
//            case 3:
//                return _30day;
//            default:
//                return "2010-01-01";
//        }
//    }
//
//    private void toQuery(String start, String end) {
//        dialog.show();
//        ITrajectoryAnalysis build = HttpTools.build(ITrajectoryAnalysis.class);
////        requestCounter++;
////        build.getPersonCars(idNumber)
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribeOn(Schedulers.io())
////                .subscribe((cars) -> this.getMyCars(cars, start, end), this::err, this::onComplete)
////                .isDisposed();
//        /*
////        requestCounter++;
////        build.personTrajectory(idNumber)
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribeOn(Schedulers.io())
////                .subscribe(this::house, this::err, this::onComplete)
////                .isDisposed();
//
//      */
////        requestCounter++;
////        build.personTrajectory2(idNumber, start, end)
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribeOn(Schedulers.io())
////                .subscribe(this::house, this::err, this::onComplete)
////                .isDisposed();
//        requestCounter++;
//        build.noIdTrajectory(idNumber, start, end)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::noId, this::err, this::onComplete)
//                .isDisposed();
//        requestCounter++;
//        build.szqyTrajectory(idNumber, start, end)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::szqy, this::err, this::onComplete)
//                .isDisposed();
//        requestCounter++;
//        build.unLockTrajectory(idNumber, start, end)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::unLock, this::err, this::onComplete).isDisposed();
//        getMyGuiji(idNumber, start, end);
//    }
//
//
//    private void unLock(PersonTrajectoryUnLock personTrajectoryUnLock) {
//        requestCounter--;
//        ArrayList<PersonTrajectory> mData = new ArrayList<>();
//        if (personTrajectoryUnLock.isSuccess()) {
//            for (int i = 0; i < personTrajectoryUnLock.getObj().size(); i++) {
//                PersonTrajectoryUnLock.ObjBean objBean = personTrajectoryUnLock.getObj().get(i);
//                PersonTrajectory personTrajectory = new PersonTrajectory(objBean);
//                mData.add(personTrajectory);
//            }
//            st_br.addAll(mData);
//            Collections.sort(st_br);
//            adapter.setData(st_br);
//            adapter.notifyDataSetChanged();
//        }
//        dismiss(adapter.getData());
//    }
//
//
//    private void szqy(PersonTrajectorySZQY personTrajectorySZQY) {
//        requestCounter--;
//        ArrayList<PersonTrajectory> mData = new ArrayList<>();
//        if (personTrajectorySZQY.isSuccess()) {
//            for (int i = 0; i < personTrajectorySZQY.getObj().size(); i++) {
//                PersonTrajectorySZQY.ObjBean objBean = personTrajectorySZQY.getObj().get(i);
////                name.setText(objBean.getName());
//                PersonTrajectory personTrajectory = new PersonTrajectory(objBean);
//                mData.add(personTrajectory);
//            }
//            st_br.addAll(mData);
//            Collections.sort(st_br);
//            adapter.setData(st_br);
//            adapter.notifyDataSetChanged();
//        }
//        dismiss(adapter.getData());
//    }
//
//    private void noId(PersonTrajectoryNoId personTrajectoryNoId) {
//        requestCounter--;
//        ArrayList<PersonTrajectory> mData = new ArrayList<>();
//        if (personTrajectoryNoId.isSuccess()) {
//            for (int i = 0; i < personTrajectoryNoId.getObj().size(); i++) {
//                PersonTrajectoryNoId.ObjBean objBean = personTrajectoryNoId.getObj().get(i);
////                name.setText(objBean.getName());
//                PersonTrajectory personTrajectory = new PersonTrajectory(objBean);
//                mData.add(personTrajectory);
//            }
//        }
//        st_br.addAll(mData);
//        Collections.sort(st_br);
//        adapter.setData(st_br);
//        adapter.notifyDataSetChanged();
//        dismiss(adapter.getData());
//    }
//
//
//    private void house(PersonTrajectoryHouse personTrajectoryHouse) {
//        requestCounter--;
//        ArrayList<PersonTrajectory> mData = new ArrayList<>();
//        if (personTrajectoryHouse.isSuccess()) {
//            for (int i = 0; i < personTrajectoryHouse.getObj().size(); i++) {
//                PersonTrajectoryHouse.ObjBean objBean = personTrajectoryHouse.getObj().get(i);
////                name.setText(objBean.getXm());
//                mData.add(new PersonTrajectory(objBean));
//            }
//            st_br.addAll(mData);
//            Collections.sort(st_br);
//            adapter.setData(st_br);
//            adapter.notifyDataSetChanged();
//        }
//        dismiss(adapter.getData());
//    }
//
//    private void onComplete() {
//        System.out.println("complete");
//    }
//
//    private void err(Throwable throwable) {
//        requestCounter--;
//        throwable.printStackTrace();
//        dismiss();
//    }
//
//    private void err2(Throwable throwable) {
//        requestCounter--;
//        throwable.printStackTrace();
//        dismiss();
//        onError(throwable);
//    }
//
//    private void onErr(Throwable throwable) {
//        requestCounter--;
//        throwable.printStackTrace();
//        String message = throwable.getMessage();
//        if (message.contains("timeout")) {
//            Toast.makeText(this, "连接超时", Toast.LENGTH_SHORT).show();
//        }
//        Log.e("onErr: ", "===>", throwable);
//        dismiss();
//        onError(throwable);
//    }
//
////    private void getMyCars(PersonCars personCars, String start, String end) {
////        requestCounter--;
////        if (personCars.isSuccess()) {
////            this.myCars.clear();
////            this.myCars.addAll(personCars.getObj());
////            for (int i = 0; i < myCars.size(); i++) {
////                requestCounter++;
////                PersonCars.ObjBean objBean = myCars.get(i);
////                ITrajectoryAnalysis build = HttpTools.build(ITrajectoryAnalysis.class);
////                build.carTrajectory(objBean.getCar(), start, end).observeOn(AndroidSchedulers.mainThread())
////                        .subscribeOn(Schedulers.io())
////                        .subscribe(this::myCarT, this::err, this::onComplete).isDisposed();
//////                requestCounter++;
//////                build.carTrajectory2(objBean.getCar()).observeOn(AndroidSchedulers.mainThread())
//////                        .subscribeOn(Schedulers.io())
//////                        .subscribe(this::myCarT, this::err, this::onComplete).isDisposed();
////            }
////        }
////        dismiss();
////    }
//
////    private void myCarT(CarTrajectoryBayonet carTrajectoryBayonet) {
////        requestCounter--;
////        ArrayList<PersonTrajectory> mData = new ArrayList<>();
////        if (carTrajectoryBayonet.isSuccess()) {
////            for (int i = 0; i < carTrajectoryBayonet.getObj().size(); i++) {
////                CarTrajectoryBayonet.ObjBean objBean = carTrajectoryBayonet.getObj().get(i);
////                PersonTrajectory personTrajectory = new PersonTrajectory(objBean);
////                mData.add(personTrajectory);
////            }
////            st_br.addAll(mData);
////            Collections.sort(adapter.getData());
////            adapter.setData(st_br);
////            adapter.notifyDataSetChanged();
////        }
////
////        dismiss(adapter.getData());
////    }
//
//
//    private ArrayList<PersonTrajectory> parseData2(ArrayList<PersonTrajectory> data, int flag) {
//
//        ArrayList<PersonTrajectory> aList = new ArrayList<>();
//        long today = DateUtil.parseDate("yyyy-MM-dd", DateUtil.format("yyyy-MM-dd", System.currentTimeMillis()));
//        switch (flag) {
//            case 1:
//                for (int i = 0; i < data.size(); i++) {
//                    if (data.get(i).getTime() > today) {
//                        aList.add(data.get(i));
//                    }
//                }
//                Collections.sort(aList);
//                break;
//            case 2:
//                for (int i = 0; i < data.size(); i++) {
//                    if (data.get(i).getTime() > (today - 2L * 24 * 3600 * 1000)) {
//                        aList.add(data.get(i));
//                    }
//                }
//                Collections.sort(aList);
//                break;
//            case 3:
//                for (int i = 0; i < data.size(); i++) {
//                    if (data.get(i).getTime() > (today - 30L * 24 * 3600 * 1000)) {
//                        aList.add(data.get(i));
//                    }
//                }
//                Collections.sort(aList);
//                break;
//        }
//        return aList;
//    }
////    private void parseData(ArrayList<PersonTrajectory> data) {
////        int current = Integer.MAX_VALUE;
////
////        int yearInt = 0;
////        sitem.clear();
////        ArrayList<String> year = new ArrayList<>();
////        for (int i = 0; i < data.size(); i++) {
////            if (current > (yearInt = Integer.parseInt(DateUtil.format("yyyy", data.get(i).getTime())))) {
////                current = yearInt;
////                yearInt = 0;
////                year.add("" + current);
////                sitem.put("" + current, i);
////            }
////        }
////        years.setData(year);
////    }
//
//    @OnClick(R.id.mTrajectoryYear)
//    void onYearPress() {
//        popupWindow.showAsDropDown(mTrajectoryYear);
//    }
//
//    @OnClick({R.id.mTrajectoryPush})
//    void onPush() {
//        popupWindow2.showAsDropDown(mTrajectoryPush);
////        startActivity(new Intent(this, TrajectoryAnalysisCar.class));
//    }
//
//    static class ViewHolder {
//        @BindView(R.id.mList)
//        ListView mList;
//
//        ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//
//    }
//
//
//    private void selfGuiji(SelfTrajectoryData guiji) {
//        requestCounter--;
//        ArrayList<PersonTrajectory> wrappers = transitionWrapper(guiji);
//        if (guiji.getRenkou().size() > 0)
//            mTrajectoryName.setText(guiji.getRenkou().get(0).getXm());
//        this.renkouBean = guiji.getRenkou();
//        if (mProgress != null && mProgress.isShowing()) {
//            mProgress.dismiss();
//            showUserData();
//        }
//        st_br.addAll(wrappers);
//        Collections.sort(st_br);
//        adapter.setData(st_br);
//        dialog.dismiss();
//        dismiss(adapter.getData());
//    }
//
//    private void showUserData() {
//        if (self) {
//            if (renkouBean != null && renkouBean.size() > 0) {
//                SelfTrajectoryData.RenkouBean rk = this.renkouBean.get(0);
//                AlertDialog alertDialog = DialogUtils.create(this, R.layout.dialog_user_info, rk.getXm(), rk.getXbdm(), rk.getMzdm(), rk.getXldm(), rk.getGmsfhm(), rk.getDzmc());
//                alertDialog.show();
//            }
//        }
//    }
//
//    private ArrayList<PersonTrajectory> transitionWrapper(SelfTrajectoryData zaitaoguiji) {
//        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
//        List<SelfTrajectoryData.CheliangBean> cheliang = zaitaoguiji.getCheliang();
//        List<SelfTrajectoryData.KecheBean> keche = zaitaoguiji.getKeche();
//        List<SelfTrajectoryData.MinhangBean> minhang = zaitaoguiji.getMinhang();
//        List<SelfTrajectoryData.ShangwangBean> shangwang = zaitaoguiji.getShangwang();
//        List<SelfTrajectoryData.TielugoupiaoBean> tielugoupiao = zaitaoguiji.getTielugoupiao();
//        List<SelfTrajectoryData.ZhudianBean> zhudian = zaitaoguiji.getZhudian();
//        List<SelfTrajectoryData.KakouBean> kakou = zaitaoguiji.getKakou();
//
//        if (cheliang != null)
//            for (SelfTrajectoryData.CheliangBean c : cheliang) {
//                SimpleCarInfo simpleCarInfo = new SimpleCarInfo();
//                simpleCarInfo.setCarCode(c.getGajtglfzjgslmc() + c.getJdchphm().substring(1));
//                simpleCarInfo.setCarName(c.getZwppmc());
//                simpleCarInfo.setCompany(c.getZzcDwmc());
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(simpleCarInfo);
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (keche != null)
//            for (SelfTrajectoryData.KecheBean c : keche) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getCkXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (minhang != null)
//            for (SelfTrajectoryData.MinhangBean c : minhang) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (shangwang != null)
//            for (SelfTrajectoryData.ShangwangBean c : shangwang) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (tielugoupiao != null)
//            for (SelfTrajectoryData.TielugoupiaoBean c : tielugoupiao) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (zhudian != null)
//            for (SelfTrajectoryData.ZhudianBean c : zhudian) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (kakou != null)
//            for (SelfTrajectoryData.KakouBean c : kakou) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        return wrappers;
//    }
//
//
//    private ArrayList<PersonTrajectory> transitionWrapper(HunyinGuiji zaitaoguiji) {
//        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
//        List<SelfTrajectoryData.KecheBean> keche = zaitaoguiji.getKeche();
//        List<SelfTrajectoryData.MinhangBean> minhang = zaitaoguiji.getMinhang();
//        List<SelfTrajectoryData.TielugoupiaoBean> tielugoupiao = zaitaoguiji.getTielugoupiao();
//
//        if (keche != null)
//            for (SelfTrajectoryData.KecheBean c : keche) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getCkXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (minhang != null)
//            for (SelfTrajectoryData.MinhangBean c : minhang) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        if (tielugoupiao != null)
//            for (SelfTrajectoryData.TielugoupiaoBean c : tielugoupiao) {
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
////                name.setText(c.getXm());
//                wrappers.add(zaitaoguijiWrapper);
//            }
//        return wrappers;
//    }
//
//    private ArrayList<String> getMyCars() {
//        ArrayList<String> c = new ArrayList<>();
//        for (PersonCars.ObjBean car : myCars) {
//            c.add(car.getCar());
//        }
//        return c;
//    }
//
//    private void getMyGuiji(String guijisfzh, String start, String end) {
//        requestCounter++;
//        iLocal.selfTrajectory(guijisfzh, start, end, String.valueOf(0))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::selfGuiji, this::onErr, this::onComplete)
//                .isDisposed();
//    }
//
//
//    private void nodataIfNeed() {
//        if (adapter.getCount() == 0) {
//            nodata.setVisibility(View.VISIBLE);
//        } else {
//            nodata.setVisibility(View.GONE);
//        }
//    }
//
//    private void noDataIfNeed(ArrayList data) {
//        if (data.size() == 0) {
//            nodata.setVisibility(View.VISIBLE);
//        } else {
//            nodata.setVisibility(View.GONE);
//        }
//    }
//
//    private void dismiss() {
//        if (requestCounter <= 0) {
//            dialog.dismiss();
//            nodataIfNeed();
//        } else {
//            dialog.show();
//        }
//    }
//
//
//    private void dismiss(ArrayList data) {
//        if (requestCounter <= 0) {
//            dialog.dismiss();
//            noDataIfNeed(data);
////            new Thread(this::computationCqd).start();
//        } else {
//            dialog.show();
//        }
//    }
//}
//
