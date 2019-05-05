//package com.zhhl.analysis.data;
//
//import java.util.List;
//
////
////import java.util.List;
////
/////**
//// * Created by miao on 2018/12/19.
//// */
//public class GxrData {
//
//    private String State;
//    private List<HunyinBean> hunyin;
//    private List<QinshuBean> qinshu;
//    private List<ZstxBean> zstx;
//    private List<HctxBean> hctx;
//    private List<KctxBean> kctx;
//    private List<WbtxBean> wbtx;
//    private List<HbtxBean> hbtx;
//    private String Message;
//
//    public List<HunyinBean> getHunyin() {
//        return hunyin;
//    }
//
//    public void setHunyin(List<HunyinBean> hunyin) {
//        this.hunyin = hunyin;
//    }
//
//    public String getMessage() {
//        return Message;
//    }
//
//    public void setMessage(String Message) {
//        this.Message = Message;
//    }
//
//    public List<ZstxBean> getZstx() {
//        return zstx;
//    }
//
//    public void setZstx(List<ZstxBean> zstx) {
//        this.zstx = zstx;
//    }
//
//    public String getState() {
//        return State;
//    }
//
//    public void setState(String State) {
//        this.State = State;
//    }
//
//    public List<WbtxBean> getWbtx() {
//        return wbtx;
//    }
//
//    public void setWbtx(List<WbtxBean> wbtx) {
//        this.wbtx = wbtx;
//    }
//
//    public List<KctxBean> getKctx() {
//        return kctx;
//    }
//
//    public void setKctx(List<KctxBean> kctx) {
//        this.kctx = kctx;
//    }
//
//    public List<HctxBean> getHctx() {
//        return hctx;
//    }
//
//    public void setHctx(List<HctxBean> hctx) {
//        this.hctx = hctx;
//    }
//
//    public List<QinshuBean> getQinshu() {
//        return qinshu;
//    }
//
//    public void setQinshu(List<QinshuBean> qinshu) {
//        this.qinshu = qinshu;
//    }
//
//    public List<HbtxBean> getHbtx() {
//        return hbtx;
//    }
//
//    public void setHbtx(List<HbtxBean> hbtx) {
//        this.hbtx = hbtx;
//    }
//
//    static class HunyinBean {
//        /**
//         * peiou : 苏英华
//         * peioucode : 220105197301281636
//         */
//
//        private String peiou;
//        private String peioucode;
//
//        public String getPeiou() {
//            return peiou;
//        }
//
//        public void setPeiou(String peiou) {
//            this.peiou = peiou;
//        }
//
//        public String getPeioucode() {
//            return peioucode;
//        }
//
//        public void setPeioucode(String peioucode) {
//            this.peioucode = peioucode;
//        }
//    }
//
//    public static class ZstxBean {
//        /**
//         * yuanyin :
//         * zname :
//         * zsfzh :
//         */
//
//        private String yuanyin;
//        private String zname;
//        private String zsfzh;
//
//        public String getYuanyin() {
//            return yuanyin;
//        }
//
//        public void setYuanyin(String yuanyin) {
//            this.yuanyin = yuanyin;
//        }
//
//        public String getZname() {
//            return zname;
//        }
//
//        public void setZname(String zname) {
//            this.zname = zname;
//        }
//
//        public String getZsfzh() {
//            return zsfzh;
//        }
//
//        public void setZsfzh(String zsfzh) {
//            this.zsfzh = zsfzh;
//        }
//    }
//
//    public static class WbtxBean {
//        /**
//         * yuanyin :
//         * name :
//         * idcode :
//         */
//
//        private String yuanyin;
//        private String name;
//        private String idcode;
//
//        public String getYuanyin() {
//            return yuanyin;
//        }
//
//        public void setYuanyin(String yuanyin) {
//            this.yuanyin = yuanyin;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getIdcode() {
//            return idcode;
//        }
//
//        public void setIdcode(String idcode) {
//            this.idcode = idcode;
//        }
//    }
//
//    public static class KctxBean {
//        /**
//         * yuanyin :
//         * name :
//         * idcode :
//         */
//
//        private String yuanyin;
//        private String name;
//        private String idcode;
//
//        public String getYuanyin() {
//            return yuanyin;
//        }
//
//        public void setYuanyin(String yuanyin) {
//            this.yuanyin = yuanyin;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getIdcode() {
//            return idcode;
//        }
//
//        public void setIdcode(String idcode) {
//            this.idcode = idcode;
//        }
//    }
//
//    public static class HctxBean {
//        /**
//         * yuanyin : 在20181118乘坐五棵树到长春的4306次的01车厢号和在20181118乘坐长春到五棵树的4305次的03车厢号身边都有此人
//         * hctxname : 刘敬军
//         * hctxid : 152201197109202014
//         */
//
//        private String yuanyin;
//        private String name;
//        private String idcode;
//
//        public String getYuanyin() {
//            return yuanyin;
//        }
//
//        public void setYuanyin(String yuanyin) {
//            this.yuanyin = yuanyin;
//        }
//
//        public String getHctxname() {
//            return name;
//        }
//
//        public void setHctxname(String hctxname) {
//            this.name = hctxname;
//        }
//
//        public String getHctxid() {
//            return idcode;
//        }
//
//        public void setHctxid(String hctxid) {
//            this.idcode = hctxid;
//        }
//    }
//
//    public static class QinshuBean {
//        /**
//         * isNewRecord : true
//         * gmsfhm : 220105197301281636
//         * xm : 苏英华
//         * yhzgxdm : 户主
//         */
//
//        private boolean isNewRecord;
//        private String gmsfhm;
//        private String xm;
//        private String yhzgxdm;
//        private String code;
//        private List<JdcListBean> jdclist;
//
//        public String getCode() {
//            return code;
//        }
//
//        public void setCode(String code) {
//            this.code = code;
//        }
//
//        public boolean isIsNewRecord() {
//            return isNewRecord;
//        }
//
//        public void setIsNewRecord(boolean isNewRecord) {
//            this.isNewRecord = isNewRecord;
//        }
//
//        public String getGmsfhm() {
//            return gmsfhm;
//        }
//
//        public void setGmsfhm(String gmsfhm) {
//            this.gmsfhm = gmsfhm;
//        }
//
//        public String getXm() {
//            return xm;
//        }
//
//        public void setXm(String xm) {
//            this.xm = xm;
//        }
//
//        public String getYhzgxdm() {
//            return yhzgxdm;
//        }
//
//        public void setYhzgxdm(String yhzgxdm) {
//            this.yhzgxdm = yhzgxdm;
//        }
//
//        public List<JdcListBean> getJdclist() {
//            return jdclist;
//        }
//
//        public void setJdclist(List<JdcListBean> jdclist) {
//            this.jdclist = jdclist;
//        }
//    }
//
//    public static class JdcListBean {
//
//        /**
//         * isNewRecord : true
//         * jdchphm : EFU822
//         * zwppmc : 五本牌
//         * gajtglfzjgslmc : 吉E
//         */
//
//        private boolean isNewRecord;
//        private String jdchphm;
//        private String zwppmc;
//        private String gajtglfzjgslmc;
//
//        public boolean isIsNewRecord() {
//            return isNewRecord;
//        }
//
//        public void setIsNewRecord(boolean isNewRecord) {
//            this.isNewRecord = isNewRecord;
//        }
//
//        public String getJdchphm() {
//            return jdchphm;
//        }
//
//        public void setJdchphm(String jdchphm) {
//            this.jdchphm = jdchphm;
//        }
//
//        public String getZwppmc() {
//            return zwppmc;
//        }
//
//        public void setZwppmc(String zwppmc) {
//            this.zwppmc = zwppmc;
//        }
//
//        public String getGajtglfzjgslmc() {
//            return gajtglfzjgslmc;
//        }
//
//        public void setGajtglfzjgslmc(String gajtglfzjgslmc) {
//            this.gajtglfzjgslmc = gajtglfzjgslmc;
//        }
//    }
//
//    public static class HbtxBean {
//        /**
//         * idcode : 220104196504040639
//         * yuanyin : 在2018-06-23从YNT到CGQ的1594次航班和在2018-06-17从CGQ到YNT的8452次航班上都有此人出现
//         * name : 陈志昕
//         */
//
//        private String idcode;
//        private String yuanyin;
//        private String name;
//
//        public String getIdcode() {
//            return idcode;
//        }
//
//        public void setIdcode(String idcode) {
//            this.idcode = idcode;
//        }
//
//        public String getYuanyin() {
//            return yuanyin;
//        }
//
//        public void setYuanyin(String yuanyin) {
//            this.yuanyin = yuanyin;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//}
