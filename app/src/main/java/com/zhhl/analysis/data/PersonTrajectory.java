package com.zhhl.analysis.data;



import com.zhhl.analysis.utils.DateUtil;

import java.util.ArrayList;

import androidx.annotation.NonNull;

import static com.zhhl.analysis.utils.DateUtil.parseDate;

/**
 * Created by miao on 2018/10/10.
 */
public class PersonTrajectory implements Comparable<PersonTrajectory> {
    private int type = 0;
    private long time;
    private String name;
    private String idNumber;

    public PersonTrajectory() {
    }

    public PersonTrajectory(PersonTrajectoryNoId.ObjBean o) {
        setData(o);
    }

    public PersonTrajectory(PersonTrajectorySZQY.ObjBean o) {
        setData(o);
    }

    public PersonTrajectory(PersonTrajectoryUnLock.ObjBean o) {
        setData(o);
    }

    public PersonTrajectory(PersonTrajectoryHouse.ObjBean o) {
        setData(o);
    }

    public PersonTrajectory(CarTrajectoryBayonet.ObjBean o) {
        setData(o);
    }

//    public PersonTrajectory(HunyinGuiji.HunyinBean hunyin) {
//        setData(hunyin);
//    }

//    private void setData(HunyinGuiji.HunyinBean hunyin) {
//        this.hunyin = hunyin;
//        type = 31;
//        time = System.currentTimeMillis();
//    }

    private void setData(CarTrajectoryBayonet.ObjBean o) {
        carBayonet = o;
        String csrq = carBayonet.getJgsj();
        time = parseDate("yyyy-MM-dd HH:mm:ss", csrq);
        type = 5;
    }


    private PersonTrajectoryHouse.ObjBean house; //1
    private PersonTrajectoryUnLock.ObjBean unLock;//2
    private PersonTrajectorySZQY.ObjBean szqy;//3
    private PersonTrajectoryNoId.ObjBean noId;//4
    private CarTrajectoryBayonet.ObjBean carBayonet;//5

    private SelfTrajectoryData.KecheBean kecheBean;//12
    private SelfTrajectoryData.MinhangBean minhangBean;//13
    private SelfTrajectoryData.ShangwangBean shangwangBean;//14
    private SelfTrajectoryData.TielugoupiaoBean tielugoupiaoBean;//15
    private SelfTrajectoryData.ZhudianBean zhudianBean;//16
    private SelfTrajectoryData.KakouBean kakouBean;//17


    private GuijiCQDWrapper wrapper;//21

    //    @Deprecated
//    private HunyinGuiji.HunyinBean hunyin;//31
//    @Deprecated
//    private GxrData.QinshuBean qinshu;//32
    private GxrData2.HunyinBean hunyin2;//33
    private GxrData2.QinshuBean qinshu2;//34

//    @Deprecated
//    private GxrData.HbtxBean hbtx;//41
//    @Deprecated
//    private GxrData.HctxBean hctx;//42
//    @Deprecated
//    private GxrData.KctxBean kctx;//43
//    @Deprecated
//    private GxrData.WbtxBean wbtx;//44
//    @Deprecated
//    private GxrData.ZstxBean zstx;//45

    private ArrayList<GxrData2.HbtxBean> hbtx2;//46
    private ArrayList<GxrData2.HctxBean> hctx2;//47
    private ArrayList<GxrData2.KctxBean> kctx2;//48
    private ArrayList<GxrData2.ZstxBean> zstx2;//49
    private ArrayList<GxrData2.HclzBean> hclz2;//50

//    private SimpleCarInfo carInfo;//51

    private GxclData.QsclBean gxcl;//61

    public ArrayList<GxrData2.HbtxBean> getHbtx2() {
        return hbtx2;
    }

    public ArrayList<GxrData2.HctxBean> getHctx2() {
        return hctx2;
    }

    public ArrayList<GxrData2.KctxBean> getKctx2() {
        return kctx2;
    }

    public ArrayList<GxrData2.HclzBean> getHclz2() {
        return hclz2;
    }

    public ArrayList<GxrData2.ZstxBean> getZstx2() {
        return zstx2;
    }

    public GxrData2.QinshuBean getQinshu2() {
        return qinshu2;
    }

    public GxrData2.HunyinBean getHunyin2() {
        return hunyin2;
    }


    private void setHunyin2(GxrData2.HunyinBean hunyin2) {
        this.hunyin2 = hunyin2;
        this.idNumber = hunyin2.getPeioucode();
        type = 33;
        time = System.currentTimeMillis() + 20;
    }

    private void setQinshu2(GxrData2.QinshuBean qinshu2) {
        this.qinshu2 = qinshu2;
        this.idNumber = qinshu2.getGmsfhm();
        type = 34;
        time = System.currentTimeMillis() + 10;
    }


    @Deprecated
    private void setGxcl(GxclData.QsclBean gxcl) {
        this.gxcl = gxcl;
        type = 61;
        time = System.currentTimeMillis();
    }

    @Deprecated
    public GxclData.QsclBean getGxcl() {
        return gxcl;
    }

    @Deprecated
    public PersonTrajectory(GxclData.QsclBean o) {
        setGxcl(o);
    }

    public PersonTrajectory(GxrData2.HunyinBean o) {
        setHunyin2(o);
    }

    public PersonTrajectory(GxrData2.QinshuBean o) {
        setQinshu2(o);
    }

//    @Deprecated
//    private void setQinshu(GxrData.QinshuBean qinshu) {
//        this.qinshu = qinshu;
//        type = 32;
//        time = System.currentTimeMillis();
//    }
//
//    @Deprecated
//    public GxrData.HbtxBean getHbtx() {
//        return hbtx;
//    }
//
//    @Deprecated
//    public GxrData.HctxBean getHctx() {
//        return hctx;
//    }
//
//    @Deprecated
//    public GxrData.KctxBean getKctx() {
//        return kctx;
//    }
//
//    @Deprecated
//    public GxrData.WbtxBean getWbtx() {
//        return wbtx;
//    }
//
//    @Deprecated
//    public GxrData.ZstxBean getZstx() {
//        return zstx;
//    }

//    @Deprecated
//    public GxrData.QinshuBean getQinshu() {
//        return qinshu;
//    }
//
//    @Deprecated
//    private void setZstx(GxrData.ZstxBean zstx) {
//        this.zstx = zstx;
//        type = 45;
//        time = System.currentTimeMillis();
//    }
//
//    @Deprecated
//    private void setWbtx(GxrData.WbtxBean wbtx) {
//        this.wbtx = wbtx;
//        type = 44;
//        time = System.currentTimeMillis();
//    }
//
//    @Deprecated
//    private void setKctx(GxrData.KctxBean kctx) {
//        this.kctx = kctx;
//        this.time = System.currentTimeMillis();
//        type = 43;
//    }
//
//    @Deprecated
//    private void setHctx(GxrData.HctxBean hctx) {
//        this.hctx = hctx;
//        type = 42;
//        time = System.currentTimeMillis();
//    }
//
//    @Deprecated
//    private void setHbtx(GxrData.HbtxBean hbtx) {
//        this.hbtx = hbtx;
//        type = 41;
//        time = System.currentTimeMillis();
//    }

//    @Deprecated
//    public PersonTrajectory(GxrData.HbtxBean wrapper) {
//        setHbtx(wrapper);
//    }
//
//    @Deprecated
//    public PersonTrajectory(GxrData.HctxBean wrapper) {
//        setHctx(wrapper);
//    }
//
//    @Deprecated
//    public PersonTrajectory(GxrData.KctxBean wrapper) {
//        setKctx(wrapper);
//    }
//
//    @Deprecated
//    public PersonTrajectory(GxrData.WbtxBean wrapper) {
//        setWbtx(wrapper);
//    }
//
//    @Deprecated
//    public PersonTrajectory(GxrData.ZstxBean wrapper) {
//        setZstx(wrapper);
//    }

//    @Deprecated
//    public PersonTrajectory(GxrData.QinshuBean wrapper) {
//        setQinshu(wrapper);
//    }

    public PersonTrajectory(GuijiCQDWrapper wrapper) {
        setData(wrapper);
    }

    public GuijiCQDWrapper getWrapper() {
        return wrapper;
    }

    private void setData(GuijiCQDWrapper wrapper) {
        type = 21;
        time = System.currentTimeMillis();
        this.wrapper = wrapper;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public PersonTrajectoryHouse.ObjBean getHouse() {
        return house;
    }

    public PersonTrajectorySZQY.ObjBean getSzqy() {
        return szqy;
    }

    public PersonTrajectoryUnLock.ObjBean getUnLock() {
        return unLock;
    }

    public PersonTrajectoryNoId.ObjBean getNoId() {
        return noId;
    }

    public CarTrajectoryBayonet.ObjBean getCarBayonet() {
        return carBayonet;
    }

    public PersonTrajectory(SelfTrajectoryData.KecheBean kecheBean) {
        setData(kecheBean);
    }

    public PersonTrajectory(SelfTrajectoryData.MinhangBean minhangBean) {
        setData(minhangBean);
    }

    public PersonTrajectory(SelfTrajectoryData.ShangwangBean shangwangBean) {
        setData(shangwangBean);
    }

    public PersonTrajectory(SelfTrajectoryData.TielugoupiaoBean tielugoupiaoBean) {
        setData(tielugoupiaoBean);
    }

    public PersonTrajectory(SelfTrajectoryData.ZhudianBean zhudianBean) {
        setData(zhudianBean);
    }

    public PersonTrajectory(SelfTrajectoryData.KakouBean kakouBean) {
        setData(kakouBean);
    }

    private void setData(SelfTrajectoryData.KakouBean kakouBean) {
        this.type = 17;
        this.kakouBean = kakouBean;
        this.time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", kakouBean.getTgsj());
        name = kakouBean.getHphm();
    }

    private void setData(SelfTrajectoryData.KecheBean kecheBean) {
        this.kecheBean = kecheBean;
        type = 12;
        time = DateUtil.parseDate("yyyy-MM-ddHH:mm", kecheBean.getFcrq() + kecheBean.getFcsj());
        name = kecheBean.getCkXm();
    }

    private void setData(SelfTrajectoryData.MinhangBean minhangBean) {
        this.type = 13;
        this.minhangBean = minhangBean;
        time = DateUtil.parseDate("yyyy-MM-ddHH:mm:ss", minhangBean.getDdcfRq().split(" ")[0] + minhangBean.getDdcfSj());
        name = minhangBean.getXm();
    }

    private void setData(SelfTrajectoryData.ShangwangBean shangwangBean) {
        this.type = 14;
        this.shangwangBean = shangwangBean;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", shangwangBean.getSwKssj());
        name = shangwangBean.getXm();
    }

    private void setData(SelfTrajectoryData.TielugoupiaoBean tielugoupiaoBean) {
        this.type = 15;
        this.tielugoupiaoBean = tielugoupiaoBean;
        time = DateUtil.parseDate("yyyyMMdd", tielugoupiaoBean.getCcrq());
        name = tielugoupiaoBean.getXm();
    }

    private void setData(SelfTrajectoryData.ZhudianBean zhudianBean) {
        this.type = 16;
        this.zhudianBean = zhudianBean;
        this.time = DateUtil.parseDate("yyyyMMddHHmm", zhudianBean.getRzsj());
        name = zhudianBean.getXm();
    }

    public SelfTrajectoryData.KecheBean getKecheBean() {
        return kecheBean;
    }

    public SelfTrajectoryData.MinhangBean getMinhangBean() {
        return minhangBean;
    }

    public SelfTrajectoryData.ShangwangBean getShangwangBean() {
        return shangwangBean;
    }

    public SelfTrajectoryData.TielugoupiaoBean getTielugoupiaoBean() {
        return tielugoupiaoBean;
    }

    public SelfTrajectoryData.ZhudianBean getZhudianBean() {
        return zhudianBean;
    }

    public SelfTrajectoryData.KakouBean getKakouBean() {
        return kakouBean;
    }

    private void setData(PersonTrajectoryHouse.ObjBean o) {
        house = o;
        String csrq = house.getCsrq();
        time = parseDate("yyyyMMdd", csrq);
        type = 1;
    }

    private void setData(PersonTrajectoryUnLock.ObjBean o) {
        this.unLock = o;
        String createDate = unLock.getCreateDate();
        time = createDate == null ? 0 : DateUtil.parseDate("yyyy-MM-dd HH:mm", createDate);
        this.type = 2;
    }

    private void setData(PersonTrajectorySZQY.ObjBean o) {
        this.szqy = o;
        String createDate = szqy.getCreateDate();
        time = createDate == null ? 0 : DateUtil.parseDate("yyyy-MM-dd HH:mm", createDate);
        this.type = 3;
    }

    private void setData(PersonTrajectoryNoId.ObjBean o) {
        this.noId = o;
        String createDate = noId.getCreateDate();
        time = createDate == null ? 0 : DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", createDate);
        this.type = 4;
    }

//    public HunyinGuiji.HunyinBean getHunyin() {
//        return hunyin;
//    }

    @Override
    public int compareTo(@NonNull PersonTrajectory o) {
        if (this.time - o.time < 0) return 1;
        else if (this.time - o.time > 0) return -1;
        else return 0;
    }

//    public SimpleCarInfo getCarInfo() {
//        return carInfo;
//    }
//
//    public PersonTrajectory(SimpleCarInfo carInfo) {
//        setCarInfo(carInfo);
//    }

//    private void setCarInfo(SimpleCarInfo carInfo) {
//        this.carInfo = carInfo;
//        type = 51;
//        time = System.currentTimeMillis();
//    }


    public PersonTrajectory setHbtx(ArrayList<GxrData2.HbtxBean> hbtxBeans) {
        this.hbtx2 = hbtxBeans;
        type = 46;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setHctx(ArrayList<GxrData2.HctxBean> hctx2) {
        this.hctx2 = hctx2;
        type = 47;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setHclz(ArrayList<GxrData2.HclzBean> hclz2) {
        this.hclz2 = hclz2;
        type = 50;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setKctx(ArrayList<GxrData2.KctxBean> kctx2) {
        this.kctx2 = kctx2;
        type = 48;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setZstx(ArrayList<GxrData2.ZstxBean> zstx2) {
        this.zstx2 = zstx2;
        type = 49;
        time = System.currentTimeMillis();
        return this;
    }

}
