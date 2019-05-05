package com.zhhl.analysis.data;

import java.util.List;

/**
 * Created by miao on 2018/10/9.
 */
public class CarTrajectoryBayonet {
    /**
     * success : true
     * msg : 查询成功
     * obj : [{"cdbh":"02","cllx":null,"hphm":"吉B59V25","dwjd":"126.54874400","dwmc":"光华路-昆明街","jgsj":"2018-08-31 00:02:10","dwwd":"43.84738487","clxxbh":"22020400000000001000000120180831000006"}]
     * attributes : null
     */

    private boolean success;
    private String msg;
    private Object attributes;
    private List<ObjBean> obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * cdbh : 02
         * cllx : null
         * hphm : 吉B59V25
         * dwjd : 126.54874400
         * dwmc : 光华路-昆明街
         * jgsj : 2018-08-31 00:02:10
         * dwwd : 43.84738487
         * clxxbh : 22020400000000001000000120180831000006
         */

        private String cdbh;
        private String cllx;
        private String hphm;
        private String dwjd;
        private String dwmc;
        private String jgsj;
        private String dwwd;
        private String clxxbh;

        public String getCdbh() {
            return cdbh;
        }

        public void setCdbh(String cdbh) {
            this.cdbh = cdbh;
        }

        public String getCllx() {
            return cllx;
        }

        public void setCllx(String cllx) {
            this.cllx = cllx;
        }

        public String getHphm() {
            return hphm;
        }

        public void setHphm(String hphm) {
            this.hphm = hphm;
        }

        public String getDwjd() {
            return dwjd;
        }

        public void setDwjd(String dwjd) {
            this.dwjd = dwjd;
        }

        public String getDwmc() {
            return dwmc;
        }

        public void setDwmc(String dwmc) {
            this.dwmc = dwmc;
        }

        public String getJgsj() {
            return jgsj;
        }

        public void setJgsj(String jgsj) {
            this.jgsj = jgsj;
        }

        public String getDwwd() {
            return dwwd;
        }

        public void setDwwd(String dwwd) {
            this.dwwd = dwwd;
        }

        public String getClxxbh() {
            return clxxbh;
        }

        public void setClxxbh(String clxxbh) {
            this.clxxbh = clxxbh;
        }

    }
}
