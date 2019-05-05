package com.zhhl.analysis.data;

import java.util.List;

/**
 * Created by miao on 2019/1/23.
 */
public class GxclData {

    /**
     * Message : 发现关系人车辆信息
     * State : 1
     * qscl : [{"isNewRecord":true,"jdchphm":"吉AGW213"},{"isNewRecord":true,"jdchphm":"吉ARC633"},{"isNewRecord":true,"jdchphm":"吉A114AB"}]
     */

    private String Message;
    private String State;
    private List<QsclBean> qscl;

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

    public List<QsclBean> getQscl() {
        return qscl;
    }

    public void setQscl(List<QsclBean> qscl) {
        this.qscl = qscl;
    }

    public static class QsclBean {
        /**
         * isNewRecord : true
         * jdchphm : 吉AGW213
         */

        private boolean isNewRecord;
        private String jdchphm;
        private String jdcsyrJdcsyrmc;

        public String getJdcsyrJdcsyrmc() {
            return jdcsyrJdcsyrmc;
        }

        public void setJdcsyrJdcsyrmc(String jdcsyrJdcsyrmc) {
            this.jdcsyrJdcsyrmc = jdcsyrJdcsyrmc;
        }

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
    }
}
