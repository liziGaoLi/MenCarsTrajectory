package com.zhhl.analysis.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by miao on 2018/11/25.
 */
public class SelfTrajectoryData {

    private String Message;
    private String State;
    private List<TielugoupiaoBean> tielugoupiao;
    private List<CheliangBean> cheliang;
    private List<ShangwangBean> shangwang;
    private List<KecheBean> keche;
    private List<MinhangBean> minhang;
    private List<ZhudianBean> zhudian;
    private List<KakouBean> kakou;
    private List<RenkouBean> renkou;
    private List<String> rylb;
    private String ladw;

    public String getLadw() {
        return ladw;
    }

    public void setLadw(String ladw) {
        this.ladw = ladw;
    }

    public List<String> getRylb() {
        return rylb;
    }

    public void setRylb(List<String> rylb) {
        this.rylb = rylb;
    }

    public List<RenkouBean> getRenkou() {
        return renkou;
    }

    public void setRenkou(List<RenkouBean> renkou) {
        this.renkou = renkou;
    }

    public static class RenkouBean implements Parcelable {

        private boolean isNewRecord;
        private String gmsfhm;
        private String xm;
        private String xbdm;
        private String mzdm;
        private String dzmc;
        private String xldm;




        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getGmsfhm() {
            return gmsfhm;
        }

        public void setGmsfhm(String gmsfhm) {
            this.gmsfhm = gmsfhm;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getXbdm() {
            return xbdm;
        }

        public void setXbdm(String xbdm) {
            this.xbdm = xbdm;
        }

        public String getMzdm() {
            return mzdm;
        }

        public void setMzdm(String mzdm) {
            this.mzdm = mzdm;
        }

        public String getDzmc() {
            return dzmc;
        }

        public void setDzmc(String dzmc) {
            this.dzmc = dzmc;
        }

        public String getXldm() {
            return xldm;
        }

        public void setXldm(String xldm) {
            this.xldm = xldm;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
            dest.writeString(this.gmsfhm);
            dest.writeString(this.xm);
            dest.writeString(this.xbdm);
            dest.writeString(this.mzdm);
            dest.writeString(this.dzmc);
            dest.writeString(this.xldm);
        }

        public RenkouBean() {
        }

        protected RenkouBean(Parcel in) {
            this.isNewRecord = in.readByte() != 0;
            this.gmsfhm = in.readString();
            this.xm = in.readString();
            this.xbdm = in.readString();
            this.mzdm = in.readString();
            this.dzmc = in.readString();
            this.xldm = in.readString();
        }

        public static final Parcelable.Creator<RenkouBean> CREATOR = new Parcelable.Creator<RenkouBean>() {
            @Override
            public RenkouBean createFromParcel(Parcel source) {
                return new RenkouBean(source);
            }

            @Override
            public RenkouBean[] newArray(int size) {
                return new RenkouBean[size];
            }
        };
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public List<TielugoupiaoBean> getTielugoupiao() {
        return tielugoupiao;
    }

    public void setTielugoupiao(List<TielugoupiaoBean> tielugoupiao) {
        this.tielugoupiao = tielugoupiao;
    }

    public List<CheliangBean> getCheliang() {
        return cheliang;
    }

    public void setCheliang(List<CheliangBean> cheliang) {
        this.cheliang = cheliang;
    }

    public List<ShangwangBean> getShangwang() {
        return shangwang;
    }

    public void setShangwang(List<ShangwangBean> shangwang) {
        this.shangwang = shangwang;
    }

    public List<KecheBean> getKeche() {
        return keche;
    }

    public void setKeche(List<KecheBean> keche) {
        this.keche = keche;
    }

    public List<MinhangBean> getMinhang() {
        return minhang;
    }

    public void setMinhang(List<MinhangBean> minhang) {
        this.minhang = minhang;
    }

    public List<ZhudianBean> getZhudian() {
        return zhudian;
    }

    public void setZhudian(List<ZhudianBean> zhudian) {
        this.zhudian = zhudian;
    }

    public List<KakouBean> getKakou() {
        return kakou;
    }

    public void setKakou(List<KakouBean> kakou) {
        this.kakou = kakou;
    }

    public static class TielugoupiaoBean {
        private boolean isNewRecord;
        private String gmsfhm;
        private String xm;
        private String ccrq;
        private String cc;
        private String sfd;
        private String mdd;


        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getGmsfhm() {
            return gmsfhm;
        }

        public void setGmsfhm(String gmsfhm) {
            this.gmsfhm = gmsfhm;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getCcrq() {
            return ccrq;
        }

        public void setCcrq(String ccrq) {
            this.ccrq = ccrq;
        }

        public String getCc() {
            return cc;
        }

        public void setCc(String cc) {
            this.cc = cc;
        }

        public String getSfd() {
            return sfd;
        }

        public void setSfd(String sfd) {
            this.sfd = sfd;
        }

        public String getMdd() {
            return mdd;
        }

        public void setMdd(String mdd) {
            this.mdd = mdd;
        }

    }

    public static class CheliangBean {
        private String jdchphm;
        private String zwppmc;
        private String clxh;
        private String zzcDwmc;
        private String jdcsyrJtglywdxsfzmhm;
        private String jdcsyrJdcsyrmc;
        private String gajtglfzjgslmc;
        private String jdcsyrXzzDzmc;

        public String getJdchphm() {
            return jdchphm;
        }

        public void setJdchphm(String jdchphm) {
            this.jdchphm = jdchphm;
        }

        public String getZwppmc() {
            return zwppmc;
        }

        public void setZwppmc(String zwppmc) {
            this.zwppmc = zwppmc;
        }

        public String getClxh() {
            return clxh;
        }

        public void setClxh(String clxh) {
            this.clxh = clxh;
        }

        public String getZzcDwmc() {
            return zzcDwmc;
        }

        public void setZzcDwmc(String zzcDwmc) {
            this.zzcDwmc = zzcDwmc;
        }

        public String getJdcsyrJtglywdxsfzmhm() {
            return jdcsyrJtglywdxsfzmhm;
        }

        public void setJdcsyrJtglywdxsfzmhm(String jdcsyrJtglywdxsfzmhm) {
            this.jdcsyrJtglywdxsfzmhm = jdcsyrJtglywdxsfzmhm;
        }

        public String getJdcsyrJdcsyrmc() {
            return jdcsyrJdcsyrmc;
        }

        public void setJdcsyrJdcsyrmc(String jdcsyrJdcsyrmc) {
            this.jdcsyrJdcsyrmc = jdcsyrJdcsyrmc;
        }

        public String getGajtglfzjgslmc() {
            return gajtglfzjgslmc;
        }

        public void setGajtglfzjgslmc(String gajtglfzjgslmc) {
            this.gajtglfzjgslmc = gajtglfzjgslmc;
        }

        public String getJdcsyrXzzDzmc() {
            return jdcsyrXzzDzmc;
        }

        public void setJdcsyrXzzDzmc(String jdcsyrXzzDzmc) {
            this.jdcsyrXzzDzmc = jdcsyrXzzDzmc;
        }

    }

    public static class ShangwangBean {
        /**
         * isNewRecord : true
         * xxzjbh : 220100131805877
         * ssdsXzqhdm : 220156
         * yycsdm : 22010510006432
         * yycsDwmc : 潘多拉网络俱乐部
         * zdbh : 215
         * xm : 杨兆坤
         * cyzjdm : 11
         * zjhm : 220105199301070432
         * qhnxxdzDzmc : 二道区东盛大街(王大勺东100米处)
         * xxrksj : 2013-01-01 00:00:00
         * fzjgDwmc : 公安
         * gjdm : CHN
         * pcsBm : 220105270000
         * pcsMc : 吉林省长春市公安局二道区分局和顺街派出所
         * swKssj : 2012-12-31 12:13:45
         * xwSj : 2013-01-01 07:02:32
         * sjlyXzqhdm : 220100
         * rgxksj : 2017-10-13 06:49:22
         */
        private boolean isNewRecord;
        private long xxzjbh;
        private String ssdsXzqhdm;
        private String yycsdm;
        private String yycsDwmc;
        private String zdbh;
        private String xm;
        private String cyzjdm;
        private String zjhm;
        private String qhnxxdzDzmc;
        private String xxrksj;
        private String fzjgDwmc;
        private String gjdm;
        private String pcsBm;
        private String pcsMc;
        private String swKssj;
        private String xwSj;
        private String sjlyXzqhdm;
        private String rgxksj;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public long getXxzjbh() {
            return xxzjbh;
        }

        public void setXxzjbh(long xxzjbh) {
            this.xxzjbh = xxzjbh;
        }

        public String getSsdsXzqhdm() {
            return ssdsXzqhdm;
        }

        public void setSsdsXzqhdm(String ssdsXzqhdm) {
            this.ssdsXzqhdm = ssdsXzqhdm;
        }

        public String getYycsdm() {
            return yycsdm;
        }

        public void setYycsdm(String yycsdm) {
            this.yycsdm = yycsdm;
        }

        public String getYycsDwmc() {
            return yycsDwmc;
        }

        public void setYycsDwmc(String yycsDwmc) {
            this.yycsDwmc = yycsDwmc;
        }

        public String getZdbh() {
            return zdbh;
        }

        public void setZdbh(String zdbh) {
            this.zdbh = zdbh;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getCyzjdm() {
            return cyzjdm;
        }

        public void setCyzjdm(String cyzjdm) {
            this.cyzjdm = cyzjdm;
        }

        public String getZjhm() {
            return zjhm;
        }

        public void setZjhm(String zjhm) {
            this.zjhm = zjhm;
        }

        public String getQhnxxdzDzmc() {
            return qhnxxdzDzmc;
        }

        public void setQhnxxdzDzmc(String qhnxxdzDzmc) {
            this.qhnxxdzDzmc = qhnxxdzDzmc;
        }

        public String getXxrksj() {
            return xxrksj;
        }

        public void setXxrksj(String xxrksj) {
            this.xxrksj = xxrksj;
        }

        public String getFzjgDwmc() {
            return fzjgDwmc;
        }

        public void setFzjgDwmc(String fzjgDwmc) {
            this.fzjgDwmc = fzjgDwmc;
        }

        public String getGjdm() {
            return gjdm;
        }

        public void setGjdm(String gjdm) {
            this.gjdm = gjdm;
        }

        public String getPcsBm() {
            return pcsBm;
        }

        public void setPcsBm(String pcsBm) {
            this.pcsBm = pcsBm;
        }

        public String getPcsMc() {
            return pcsMc;
        }

        public void setPcsMc(String pcsMc) {
            this.pcsMc = pcsMc;
        }

        public String getSwKssj() {
            return swKssj;
        }

        public void setSwKssj(String swKssj) {
            this.swKssj = swKssj;
        }

        public String getXwSj() {
            return xwSj;
        }

        public void setXwSj(String xwSj) {
            this.xwSj = xwSj;
        }

        public String getSjlyXzqhdm() {
            return sjlyXzqhdm;
        }

        public void setSjlyXzqhdm(String sjlyXzqhdm) {
            this.sjlyXzqhdm = sjlyXzqhdm;
        }

        public String getRgxksj() {
            return rgxksj;
        }

        public void setRgxksj(String rgxksj) {
            this.rgxksj = rgxksj;
        }
    }

    public static class KecheBean {

        private boolean isNewRecord;
        private String zjqfZjhm;
        private String ckXm;
        private String fcrq;
        private String fcjgmc;
        private String fcsj;
        private String ddzmc;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getZjqfzjhm() {
            return zjqfZjhm;
        }

        public void setZjqfzjhm(String zjqfzjhm) {
            this.zjqfZjhm = zjqfzjhm;
        }

        public String getCkXm() {
            return ckXm;
        }

        public void setCkXm(String ckXm) {
            this.ckXm = ckXm;
        }

        public String getFcrq() {
            return fcrq;
        }

        public void setFcrq(String fcrq) {
            this.fcrq = fcrq;
        }


        public String getFcjgmc() {
            return fcjgmc;
        }

        public void setFcjgmc(String fcjgmc) {
            this.fcjgmc = fcjgmc;
        }

        public String getFcsj() {
            return fcsj;
        }

        public void setFcsj(String fcsj) {
            this.fcsj = fcsj;
        }

        public String getDdzmc() {
            return ddzmc;
        }

        public void setDdzmc(String ddzmc) {
            this.ddzmc = ddzmc;
        }

    }

    public static class MinhangBean {
        private boolean isNewRecord;
        private String xm;
        private String zjhm;
        private String cyhkgsdm;
        private String hbh;
        private String qfjcdm;
        private String ddcfRq;
        private String ddcfSj;
        private String ddjcdm;
        private String ddddSj;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getZjhm() {
            return zjhm;
        }

        public void setZjhm(String zjhm) {
            this.zjhm = zjhm;
        }

        public String getCyhkgsdm() {
            return cyhkgsdm;
        }

        public void setCyhkgsdm(String cyhkgsdm) {
            this.cyhkgsdm = cyhkgsdm;
        }

        public String getHbh() {
            return hbh;
        }

        public void setHbh(String hbh) {
            this.hbh = hbh;
        }

        public String getQfjcdm() {
            return qfjcdm;
        }

        public void setQfjcdm(String qfjcdm) {
            this.qfjcdm = qfjcdm;
        }

        public String getDdcfRq() {
            return ddcfRq;
        }

        public void setDdcfRq(String ddcfRq) {
            this.ddcfRq = ddcfRq;
        }

        public String getDdcfSj() {
            return ddcfSj;
        }

        public void setDdcfSj(String ddcfSj) {
            this.ddcfSj = ddcfSj;
        }

        public String getDdjcdm() {
            return ddjcdm;
        }

        public void setDdjcdm(String ddjcdm) {
            this.ddjcdm = ddjcdm;
        }

        public String getDdddSj() {
            return ddddSj;
        }

        public void setDdddSj(String ddddSj) {
            this.ddddSj = ddddSj;
        }

    }

    public static class ZhudianBean {

        private boolean isNewRecord;
        private String xm;
        private String gmsfhm;
        private String ldMc;
        private String lgbm;
        private String rzsj;
        private String tfsj;
        private String zzxz;


        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getGmsfhm() {
            return gmsfhm;
        }

        public void setGmsfhm(String gmsfhm) {
            this.gmsfhm = gmsfhm;
        }

        public String getLdMc() {
            return ldMc;
        }

        public void setLdMc(String ldMc) {
            this.ldMc = ldMc;
        }

        public String getLgbm() {
            return lgbm;
        }

        public void setLgbm(String lgbm) {
            this.lgbm = lgbm;
        }

        public String getRzsj() {
            return rzsj;
        }

        public void setRzsj(String rzsj) {
            this.rzsj = rzsj;
        }

        public String getTfsj() {
            return tfsj;
        }

        public void setTfsj(String tfsj) {
            this.tfsj = tfsj;
        }

        public String getZzxz() {
            return zzxz;
        }

        public void setZzxz(String zzxz) {
            this.zzxz = zzxz;
        }

    }

    public static class KakouBean {
        /**
         * id : 1DBE2D2CE73B7A7E072CA1ACF6A41E7E
         * isNewRecord : false
         * cjdwdm : 220303000000
         * cjsj : 2010-01-11 00:00:00
         * hphm : 吉C48181
         * hpzl : 01
         * kkmc : 四平南桥
         * kkszdqh : 220303
         * kkszdz : 四平南桥
         * ssgajgjgdm : 220303020100
         * ssgajgjgmc : 四平市交警支队公路巡警大队南桥中队
         * tgfx : 南向北
         * tgsj : 2010-01-11 23:37:01
         * rgxksj : 2018-08-03 14:34:45
         */

        private String id;
        private boolean isNewRecord;
        private String cjdwdm;
        private String cjsj;
        private String hphm;
        private String hpzl;
        private String kkmc;
        private String kkszdqh;
        private String kkszdz;
        private String ssgajgjgdm;
        private String ssgajgjgmc;
        private String tgfx;
        private String tgsj;
        private String rgxksj;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getCjdwdm() {
            return cjdwdm;
        }

        public void setCjdwdm(String cjdwdm) {
            this.cjdwdm = cjdwdm;
        }

        public String getCjsj() {
            return cjsj;
        }

        public void setCjsj(String cjsj) {
            this.cjsj = cjsj;
        }

        public String getHphm() {
            return hphm;
        }

        public void setHphm(String hphm) {
            this.hphm = hphm;
        }

        public String getHpzl() {
            return hpzl;
        }

        public void setHpzl(String hpzl) {
            this.hpzl = hpzl;
        }

        public String getKkmc() {
            return kkmc;
        }

        public void setKkmc(String kkmc) {
            this.kkmc = kkmc;
        }

        public String getKkszdqh() {
            return kkszdqh;
        }

        public void setKkszdqh(String kkszdqh) {
            this.kkszdqh = kkszdqh;
        }

        public String getKkszdz() {
            return kkszdz;
        }

        public void setKkszdz(String kkszdz) {
            this.kkszdz = kkszdz;
        }

        public String getSsgajgjgdm() {
            return ssgajgjgdm;
        }

        public void setSsgajgjgdm(String ssgajgjgdm) {
            this.ssgajgjgdm = ssgajgjgdm;
        }

        public String getSsgajgjgmc() {
            return ssgajgjgmc;
        }

        public void setSsgajgjgmc(String ssgajgjgmc) {
            this.ssgajgjgmc = ssgajgjgmc;
        }

        public String getTgfx() {
            return tgfx;
        }

        public void setTgfx(String tgfx) {
            this.tgfx = tgfx;
        }

        public String getTgsj() {
            return tgsj;
        }

        public void setTgsj(String tgsj) {
            this.tgsj = tgsj;
        }

        public String getRgxksj() {
            return rgxksj;
        }

        public void setRgxksj(String rgxksj) {
            this.rgxksj = rgxksj;
        }
    }
}
