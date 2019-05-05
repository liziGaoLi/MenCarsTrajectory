package com.zhhl.analysis.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by miao on 2019/1/23.
 */
public class GxrData2 {

    /**
     * hunyin : [{"peiou":"王丹","peioucode":"220124198211127620"}]
     * Message : 成功
     * qinshu : [{"isNewRecord":true,"gmsfhm":"22010319720808001X","xm":"邵显军","yhzgxdm":"户主"},{"isNewRecord":true,"gmsfhm":"22010220100127504X","xm":"田媛娇","yhzgxdm":"长女"},{"isNewRecord":true,"gmsfhm":"220124198211127620","xm":"王丹","yhzgxdm":"妻"}]
     * zstx : [{"isNewRecord":true,"xm":"仲崇良","gmsfhm":"220282199012206813","ldMc":"金沙宾馆","lgbm":"东田青年城","rzsj2":"2018-12-28 17:13:10","tfsj2":"2018-12-28 19:50:17","rzfh":"236"},{"isNewRecord":true,"xm":"仲崇良","gmsfhm":"220282199012206813","ldMc":"宜家简约宾馆","lgbm":"松原经济技术开发区","rzsj2":"2019-01-01 21:19:00","tfsj2":"2019-01-02 17:18:00","rzfh":"205","djsj":"20190101211914"}]
     * State : 1
     * hclz : [{"isNewRecord":true,"gmsfhm":"220183199606051012","xm":"冯金龙","ccrq":"20181130","cc":"C1009","sfd":"长春","mdd":"吉林","cxh":"05","zwh":"011F"},{"isNewRecord":true,"gmsfhm":"220183199606051012","xm":"冯金龙","ccrq":"20181109","cc":"C1018","sfd":"吉林","mdd":"长春","cxh":"01","zwh":"013A"}]
     * kctx : [{"isNewRecord":true,"zjqfZjhm":"220112199412280444","ckXm":"丁蕾","fcrq":"2018-06-18","fcjgmc":"白山市公路客运总站","fcsj":"16:00","ddzmc":"长春"},{"isNewRecord":true,"zjqfZjhm":"220112199412280444","ckXm":"丁蕾","fcrq":"2018-06-14","fcjgmc":"高速站客运站","fcsj":"16:00","ddzmc":"临江"},{"isNewRecord":true,"zjqfZjhm":"220112199412280444","ckXm":"丁蕾","fcrq":"2018-05-02","fcjgmc":"临江口岸公路客运总站","fcsj":"11:10","ddzmc":"长春"},{"isNewRecord":true,"zjqfZjhm":"220112199412280444","ckXm":"丁蕾","fcrq":"2018-04-25","fcjgmc":"高速站客运站","fcsj":"09:10","ddzmc":"临江"},{"isNewRecord":true,"zjqfZjhm":"220112199412280444","ckXm":"丁蕾","fcrq":"2018-03-23","fcjgmc":"高速站客运站","fcsj":"17:40","ddzmc":"东丰"}]
     * hbtx : [{"isNewRecord":true,"xm":"田媛娇","zjhm":"22010220100127504X","hbh":"8223","qfjcdm":"山东省烟台莱山机场","ddcfRq":"2018-10-04 00:00:00","ddcfSj":"11:00:00","ddjcdm":"吉林省长春龙嘉国际机场","ddddRq":"2018-10-04 00:00:00","ddddSj":"12:40:00"},{"isNewRecord":true,"xm":"田媛娇","zjhm":"22010220100127504X","hbh":"7593","qfjcdm":"吉林省长春龙嘉国际机场","ddcfRq":"2018-10-01 00:00:00","ddcfSj":"10:05:00","ddjcdm":"山东省烟台莱山机场","ddddRq":"2018-10-01 00:00:00","ddddSj":"11:50:00"},{"isNewRecord":true,"xm":"田岗岩","zjhm":"220102197802060410","hbh":"6668","qfjcdm":"山东省济南遥墙国际机场","ddcfRq":"2018-04-02 00:00:00","ddcfSj":"18:15:00","ddjcdm":"吉林省长春龙嘉国际机场","ddddRq":"2018-04-02 00:00:00","ddddSj":"20:20:00"},{"isNewRecord":true,"xm":"田岗岩","zjhm":"220102197802060410","hbh":"8403","qfjcdm":"山东省济南遥墙国际机场","ddcfRq":"2018-02-27 00:00:00","ddcfSj":"13:00:00","ddjcdm":"吉林省长春龙嘉国际机场","ddddRq":"2018-02-27 00:00:00","ddddSj":"15:10:00"},{"isNewRecord":true,"xm":"田岗岩","zjhm":"220102197802060410","hbh":"4958","qfjcdm":"吉林省长春龙嘉国际机场","ddcfRq":"2018-02-25 00:00:00","ddcfSj":"12:55:00","ddjcdm":"山东省济南遥墙国际机场","ddddRq":"2018-02-25 00:00:00","ddddSj":"15:10:00"},{"isNewRecord":true,"xm":"田岗岩","zjhm":"220102197802060410","hbh":"6466","qfjcdm":"海南省三亚凤凰国际机场","ddcfRq":"2018-02-24 00:00:00","ddcfSj":"17:20:00","ddjcdm":"吉林省长春龙嘉国际机场","ddddRq":"2018-02-24 00:00:00","ddddSj":"23:50:00"},{"isNewRecord":true,"xm":"田媛娇","zjhm":"22010220100127504X","hbh":"6466","qfjcdm":"海南省三亚凤凰国际机场","ddcfRq":"2018-02-24 00:00:00","ddcfSj":"17:20:00","ddjcdm":"吉林省长春龙嘉国际机场","ddddRq":"2018-02-24 00:00:00","ddddSj":"23:50:00"}]
     * hctx : [{"isNewRecord":true,"gmsfhm":"220183199606051012","xm":"冯金龙","ccrq":"20181130","cc":"C1009","sfd":"长春","mdd":"吉林","cxh":"05","zwh":"011F"},{"isNewRecord":true,"gmsfhm":"23232119871115353X","xm":"李春辉","ccrq":"20181128","cc":"C1228","sfd":"吉林","mdd":"长春","cxh":"06","zwh":"005C"},{"isNewRecord":true,"gmsfhm":"23232119871115353X","xm":"李春辉","ccrq":"20181120","cc":"C1016","sfd":"吉林","mdd":"长春","cxh":"05","zwh":"017D"},{"isNewRecord":true,"gmsfhm":"23232119871115353X","xm":"李春辉","ccrq":"20181109","cc":"C1018","sfd":"吉林","mdd":"长春","cxh":"03","zwh":"018A"},{"isNewRecord":true,"gmsfhm":"220183199606051012","xm":"冯金龙","ccrq":"20181109","cc":"C1018","sfd":"吉林","mdd":"长春","cxh":"01","zwh":"013A"},{"isNewRecord":true,"gmsfhm":"220183199606051012","xm":"冯金龙","ccrq":"20181109","cc":"G8007","sfd":"长春","mdd":"吉林","cxh":"02","zwh":"005C"}]
     */

    private String Message;
    private String State;
    private List<HunyinBean> hunyin;
    private List<QinshuBean> qinshu;
    private List<ZstxBean> zstx;
    private List<HclzBean> hclz;
    private List<KctxBean> kctx;
    private List<HbtxBean> hbtx;
    private List<HctxBean> hctx;

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

    public List<HunyinBean> getHunyin() {
        return hunyin;
    }

    public void setHunyin(List<HunyinBean> hunyin) {
        this.hunyin = hunyin;
    }

    public List<QinshuBean> getQinshu() {
        return qinshu;
    }

    public void setQinshu(List<QinshuBean> qinshu) {
        this.qinshu = qinshu;
    }

    public List<ZstxBean> getZstx() {
        return zstx;
    }

    public void setZstx(List<ZstxBean> zstx) {
        this.zstx = zstx;
    }

    public List<HclzBean> getHclz() {
        return hclz;
    }

    public void setHclz(List<HclzBean> hclz) {
        this.hclz = hclz;
    }

    public List<KctxBean> getKctx() {
        return kctx;
    }

    public void setKctx(List<KctxBean> kctx) {
        this.kctx = kctx;
    }

    public List<HbtxBean> getHbtx() {
        return hbtx;
    }

    public void setHbtx(List<HbtxBean> hbtx) {
        this.hbtx = hbtx;
    }

    public List<HctxBean> getHctx() {
        return hctx;
    }

    public void setHctx(List<HctxBean> hctx) {
        this.hctx = hctx;
    }

    public static class HunyinBean {
        /**
         * peiou : 王丹
         * peioucode : 220124198211127620
         */

        private String peiou;
        private String peioucode;

        public String getPeiou() {
            return peiou;
        }

        public void setPeiou(String peiou) {
            this.peiou = peiou;
        }

        public String getPeioucode() {
            return peioucode;
        }

        public void setPeioucode(String peioucode) {
            this.peioucode = peioucode;
        }
    }

    public static class QinshuBean {
        /**
         * isNewRecord : true
         * gmsfhm : 22010319720808001X
         * xm : 邵显军
         * yhzgxdm : 户主
         */

        private boolean isNewRecord;
        private String gmsfhm;
        private String xm;
        private String yhzgxdm;

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

        public String getYhzgxdm() {
            return yhzgxdm;
        }

        public void setYhzgxdm(String yhzgxdm) {
            this.yhzgxdm = yhzgxdm;
        }
    }

    public static class ZstxBean implements Parcelable {
        /**
         * isNewRecord : true
         * xm : 仲崇良
         * gmsfhm : 220282199012206813
         * ldMc : 金沙宾馆
         * lgbm : 东田青年城
         * rzsj2 : 2018-12-28 17:13:10
         * tfsj2 : 2018-12-28 19:50:17
         * rzfh : 236
         * djsj : 20190101211914
         */

        private boolean isNewRecord;
        private String xm;
        private String gmsfhm;
        private String ldMc;
        private String lgbm;
        private String rzsj2;
        private String tfsj2;
        private String rzfh;
        private String djsj;

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

        public String getRzsj2() {
            return rzsj2;
        }

        public void setRzsj2(String rzsj2) {
            this.rzsj2 = rzsj2;
        }

        public String getTfsj2() {
            return tfsj2;
        }

        public void setTfsj2(String tfsj2) {
            this.tfsj2 = tfsj2;
        }

        public String getRzfh() {
            return rzfh;
        }

        public void setRzfh(String rzfh) {
            this.rzfh = rzfh;
        }

        public String getDjsj() {
            return djsj;
        }

        public void setDjsj(String djsj) {
            this.djsj = djsj;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
            dest.writeString(this.xm);
            dest.writeString(this.gmsfhm);
            dest.writeString(this.ldMc);
            dest.writeString(this.lgbm);
            dest.writeString(this.rzsj2);
            dest.writeString(this.tfsj2);
            dest.writeString(this.rzfh);
            dest.writeString(this.djsj);
        }

        public ZstxBean() {
        }

        protected ZstxBean(Parcel in) {
            this.isNewRecord = in.readByte() != 0;
            this.xm = in.readString();
            this.gmsfhm = in.readString();
            this.ldMc = in.readString();
            this.lgbm = in.readString();
            this.rzsj2 = in.readString();
            this.tfsj2 = in.readString();
            this.rzfh = in.readString();
            this.djsj = in.readString();
        }

        public static final Parcelable.Creator<ZstxBean> CREATOR = new Parcelable.Creator<ZstxBean>() {
            @Override
            public ZstxBean createFromParcel(Parcel source) {
                return new ZstxBean(source);
            }

            @Override
            public ZstxBean[] newArray(int size) {
                return new ZstxBean[size];
            }
        };
    }

    public static class HclzBean implements Parcelable {
        /**
         * isNewRecord : true
         * gmsfhm : 220183199606051012
         * xm : 冯金龙
         * ccrq : 20181130
         * cc : C1009
         * sfd : 长春
         * mdd : 吉林
         * cxh : 05
         * zwh : 011F
         */

        private boolean isNewRecord;
        private String gmsfhm;
        private String xm;
        private String ccrq;
        private String cc;
        private String sfd;
        private String mdd;
        private String cxh;
        private String zwh;

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

        public String getCxh() {
            return cxh;
        }

        public void setCxh(String cxh) {
            this.cxh = cxh;
        }

        public String getZwh() {
            return zwh;
        }

        public void setZwh(String zwh) {
            this.zwh = zwh;
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
            dest.writeString(this.ccrq);
            dest.writeString(this.cc);
            dest.writeString(this.sfd);
            dest.writeString(this.mdd);
            dest.writeString(this.cxh);
            dest.writeString(this.zwh);
        }

        public HclzBean() {
        }

        protected HclzBean(Parcel in) {
            this.isNewRecord = in.readByte() != 0;
            this.gmsfhm = in.readString();
            this.xm = in.readString();
            this.ccrq = in.readString();
            this.cc = in.readString();
            this.sfd = in.readString();
            this.mdd = in.readString();
            this.cxh = in.readString();
            this.zwh = in.readString();
        }

        public static final Parcelable.Creator<HclzBean> CREATOR = new Parcelable.Creator<HclzBean>() {
            @Override
            public HclzBean createFromParcel(Parcel source) {
                return new HclzBean(source);
            }

            @Override
            public HclzBean[] newArray(int size) {
                return new HclzBean[size];
            }
        };
    }

    public static class KctxBean implements Parcelable {
        /**
         * isNewRecord : true
         * zjqfZjhm : 220112199412280444
         * ckXm : 丁蕾
         * fcrq : 2018-06-18
         * fcjgmc : 白山市公路客运总站
         * fcsj : 16:00
         * ddzmc : 长春
         */

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

        public String getZjqfZjhm() {
            return zjqfZjhm;
        }

        public void setZjqfZjhm(String zjqfZjhm) {
            this.zjqfZjhm = zjqfZjhm;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
            dest.writeString(this.zjqfZjhm);
            dest.writeString(this.ckXm);
            dest.writeString(this.fcrq);
            dest.writeString(this.fcjgmc);
            dest.writeString(this.fcsj);
            dest.writeString(this.ddzmc);
        }

        public KctxBean() {
        }

        protected KctxBean(Parcel in) {
            this.isNewRecord = in.readByte() != 0;
            this.zjqfZjhm = in.readString();
            this.ckXm = in.readString();
            this.fcrq = in.readString();
            this.fcjgmc = in.readString();
            this.fcsj = in.readString();
            this.ddzmc = in.readString();
        }

        public static final Parcelable.Creator<KctxBean> CREATOR = new Parcelable.Creator<KctxBean>() {
            @Override
            public KctxBean createFromParcel(Parcel source) {
                return new KctxBean(source);
            }

            @Override
            public KctxBean[] newArray(int size) {
                return new KctxBean[size];
            }
        };
    }

    public static class HbtxBean implements Parcelable {
        /**
         * isNewRecord : true
         * xm : 田媛娇
         * zjhm : 22010220100127504X
         * hbh : 8223
         * qfjcdm : 山东省烟台莱山机场
         * ddcfRq : 2018-10-04 00:00:00
         * ddcfSj : 11:00:00
         * ddjcdm : 吉林省长春龙嘉国际机场
         * ddddRq : 2018-10-04 00:00:00
         * ddddSj : 12:40:00
         */

        private boolean isNewRecord;
        private String xm;
        private String zjhm;
        private String hbh;
        private String qfjcdm;
        private String ddcfRq;
        private String ddcfSj;
        private String ddjcdm;
        private String ddddRq;
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

        public String getDdddRq() {
            return ddddRq;
        }

        public void setDdddRq(String ddddRq) {
            this.ddddRq = ddddRq;
        }

        public String getDdddSj() {
            return ddddSj;
        }

        public void setDdddSj(String ddddSj) {
            this.ddddSj = ddddSj;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
            dest.writeString(this.xm);
            dest.writeString(this.zjhm);
            dest.writeString(this.hbh);
            dest.writeString(this.qfjcdm);
            dest.writeString(this.ddcfRq);
            dest.writeString(this.ddcfSj);
            dest.writeString(this.ddjcdm);
            dest.writeString(this.ddddRq);
            dest.writeString(this.ddddSj);
        }

        public HbtxBean() {
        }

        protected HbtxBean(Parcel in) {
            this.isNewRecord = in.readByte() != 0;
            this.xm = in.readString();
            this.zjhm = in.readString();
            this.hbh = in.readString();
            this.qfjcdm = in.readString();
            this.ddcfRq = in.readString();
            this.ddcfSj = in.readString();
            this.ddjcdm = in.readString();
            this.ddddRq = in.readString();
            this.ddddSj = in.readString();
        }

        public static final Parcelable.Creator<HbtxBean> CREATOR = new Parcelable.Creator<HbtxBean>() {
            @Override
            public HbtxBean createFromParcel(Parcel source) {
                return new HbtxBean(source);
            }

            @Override
            public HbtxBean[] newArray(int size) {
                return new HbtxBean[size];
            }
        };
    }

    public static class HctxBean implements Parcelable {
        /**
         * isNewRecord : true
         * gmsfhm : 220183199606051012
         * xm : 冯金龙
         * ccrq : 20181130
         * cc : C1009
         * sfd : 长春
         * mdd : 吉林
         * cxh : 05
         * zwh : 011F
         */

        private boolean isNewRecord;
        private String gmsfhm;
        private String xm;
        private String ccrq;
        private String cc;
        private String sfd;
        private String mdd;
        private String cxh;
        private String zwh;

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

        public String getCxh() {
            return cxh;
        }

        public void setCxh(String cxh) {
            this.cxh = cxh;
        }

        public String getZwh() {
            return zwh;
        }

        public void setZwh(String zwh) {
            this.zwh = zwh;
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
            dest.writeString(this.ccrq);
            dest.writeString(this.cc);
            dest.writeString(this.sfd);
            dest.writeString(this.mdd);
            dest.writeString(this.cxh);
            dest.writeString(this.zwh);
        }

        public HctxBean() {
        }

        protected HctxBean(Parcel in) {
            this.isNewRecord = in.readByte() != 0;
            this.gmsfhm = in.readString();
            this.xm = in.readString();
            this.ccrq = in.readString();
            this.cc = in.readString();
            this.sfd = in.readString();
            this.mdd = in.readString();
            this.cxh = in.readString();
            this.zwh = in.readString();
        }

        public static final Parcelable.Creator<HctxBean> CREATOR = new Parcelable.Creator<HctxBean>() {
            @Override
            public HctxBean createFromParcel(Parcel source) {
                return new HctxBean(source);
            }

            @Override
            public HctxBean[] newArray(int size) {
                return new HctxBean[size];
            }
        };
    }
}