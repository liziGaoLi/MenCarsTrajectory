package com.zhhl.analysis.data;

import java.util.List;

public class ChangQuDiData {
    /**
     * Message : 成功
     * shangwang : [{"isNewRecord":true,"yycsDwmc":"金时代网城","tj":"4"},{"isNewRecord":true,"yycsDwmc":"网通家园佰乐网吧","tj":"4"},{"isNewRecord":true,"yycsDwmc":"净月开发区海威网吧（2店）","tj":"46"},{"isNewRecord":true,"yycsDwmc":"会员之家网吧","tj":"28"},{"isNewRecord":true,"yycsDwmc":"启梦网络俱乐部","tj":"10"},{"isNewRecord":true,"yycsDwmc":"大时代网络沙龙","tj":"21"},{"isNewRecord":true,"yycsDwmc":"长春市都市春天网吧","tj":"2"},{"isNewRecord":true,"yycsDwmc":"泰成网咖","tj":"4"},{"isNewRecord":true,"yycsDwmc":"超越网吧","tj":"23"},{"isNewRecord":true,"yycsDwmc":"兴星网吧","tj":"2"},{"isNewRecord":true,"yycsDwmc":"海威网络有限公司","tj":"3"},{"isNewRecord":true,"yycsDwmc":"新都市网吧","tj":"2"},{"isNewRecord":true,"yycsDwmc":"慧通网络休闲小站","tj":"12"},{"isNewRecord":true,"yycsDwmc":"迅驰网吧","tj":"8"},{"isNewRecord":true,"yycsDwmc":"润雨网吧","tj":"4"},{"isNewRecord":true,"yycsDwmc":"英图网络联盟锋尚店","tj":"2"},{"isNewRecord":true,"yycsDwmc":"红帆网络俱乐部","tj":"2"},{"isNewRecord":true,"yycsDwmc":"亿网情深网吧","tj":"2"},{"isNewRecord":true,"yycsDwmc":"世友网络俱乐部","tj":"255"},{"isNewRecord":true,"yycsDwmc":"金宝雨网咖","tj":"18"},{"isNewRecord":true,"yycsDwmc":"鸿媛网络中心(奇偶网咖）","tj":"1"},{"isNewRecord":true,"yycsDwmc":"飞跃时空网吧","tj":"1"},{"isNewRecord":true,"yycsDwmc":"忆光年网吧","tj":"20"},{"isNewRecord":true,"yycsDwmc":"遇见网咖","tj":"2"}]
     * State : 0
     * zhudian : []
     */

    private String Message;
    private String State;
    private List<ShangwangBean> shangwang;
    private List<ZhudianTongjiBean> zhudian;

    public static class ZhudianTongjiBean {
        private boolean isNewRecord;
        private String ldMc;
        private String tj;

        public ZhudianTongjiBean() {
        }

        public ZhudianTongjiBean(boolean isNewRecord, String ldMc, String tj) {

            this.isNewRecord = isNewRecord;
            this.ldMc = ldMc;
            this.tj = tj;
        }

        public boolean isNewRecord() {

            return isNewRecord;
        }

        public void setNewRecord(boolean newRecord) {
            isNewRecord = newRecord;
        }

        public String getLdMc() {
            return ldMc;
        }

        public void setLdMc(String ldMc) {
            this.ldMc = ldMc;
        }

        public String getTj() {
            return tj;
        }

        public void setTj(String tj) {
            this.tj = tj;
        }
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

    public List<ShangwangBean> getShangwang() {
        return shangwang;
    }

    public void setShangwang(List<ShangwangBean> shangwang) {
        this.shangwang = shangwang;
    }

    public List<ZhudianTongjiBean> getZhudian() {
        return zhudian;
    }

    public void setZhudian(List<ZhudianTongjiBean> zhudian) {
        this.zhudian = zhudian;
    }

    public static class ShangwangBean {
        /**
         * isNewRecord : true
         * yycsDwmc : 金时代网城
         * tj : 4
         */

        private boolean isNewRecord;
        private String yycsDwmc;
        private String tj;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getYycsDwmc() {
            return yycsDwmc;
        }

        public void setYycsDwmc(String yycsDwmc) {
            this.yycsDwmc = yycsDwmc;
        }

        public String getTj() {
            return tj;
        }

        public void setTj(String tj) {
            this.tj = tj;
        }
    }
}
