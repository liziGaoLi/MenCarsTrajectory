package com.zhhl.analysis.data;

import java.util.List;

public class CarInformation {

    /**
     * cheliang : [{"isNewRecord":true,"jdchphm":"B74561","zwppmc":"解放牌","jdccllxdm":"重型半挂牵引车","jdccsysdm":"红 ","jdcsyrJtglywdxsfzmhm":"220223196805300072","jdcsyrJdcsyrmc":"郑学臣","gajtglfzjgslmc":"吉B","jdcsyrLxdh":"65224258"}]
     * Message : 成功
     * State : 0
     */

    private String Message;
    private String State;
    private List<CheliangBean> cheliang;

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

    public List<CheliangBean> getCheliang() {
        return cheliang;
    }

    public void setCheliang(List<CheliangBean> cheliang) {
        this.cheliang = cheliang;
    }

    public static class CheliangBean {
        /**
         * isNewRecord : true
         * jdchphm : B74561
         * zwppmc : 解放牌
         * jdccllxdm : 重型半挂牵引车
         * jdccsysdm : 红
         * jdcsyrJtglywdxsfzmhm : 220223196805300072
         * jdcsyrJdcsyrmc : 郑学臣
         * gajtglfzjgslmc : 吉B
         * jdcsyrLxdh : 65224258
         */

        private boolean isNewRecord;
        private String jdchphm;
        private String zwppmc;
        private String jdccllxdm;
        private String jdccsysdm;
        private String jdcsyrJtglywdxsfzmhm;
        private String jdcsyrJdcsyrmc;
        private String gajtglfzjgslmc;
        private String jdcsyrLxdh;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

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

        public String getJdccllxdm() {
            return jdccllxdm;
        }

        public void setJdccllxdm(String jdccllxdm) {
            this.jdccllxdm = jdccllxdm;
        }

        public String getJdccsysdm() {
            return jdccsysdm;
        }

        public void setJdccsysdm(String jdccsysdm) {
            this.jdccsysdm = jdccsysdm;
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

        public String getJdcsyrLxdh() {
            return jdcsyrLxdh;
        }

        public void setJdcsyrLxdh(String jdcsyrLxdh) {
            this.jdcsyrLxdh = jdcsyrLxdh;
        }
    }
}
