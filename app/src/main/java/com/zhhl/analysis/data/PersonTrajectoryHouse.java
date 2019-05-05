package com.zhhl.analysis.data;

import java.util.List;

/**
 * Created by miao on 2018/10/9.
 */
public class PersonTrajectoryHouse {
    /**
     * success : true
     * msg : 查询成功
     * obj : [{"cdbh":null,"rybh":"22028209230003910833","gmsfhm":"220282197203165314","xm":"冯秀河","csrq":"19720316","fwcs":"制材厂","lxdh":null,"hjxz":"启新街道春城一委一组","zzxz":"桦甸市启新街振兴路光明小区1号楼4单元303"}]
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
         * cdbh : null
         * rybh : 22028209230003910833
         * gmsfhm : 220282197203165314
         * xm : 冯秀河
         * csrq : 19720316
         * fwcs : 制材厂
         * lxdh : null
         * hjxz : 启新街道春城一委一组
         * zzxz : 桦甸市启新街振兴路光明小区1号楼4单元303
         */

        private String cdbh;
        private String rybh;
        private String gmsfhm;
        private String xm;
        private String csrq;
        private String fwcs;
        private String lxdh;
        private String hjxz;
        private String zzxz;

        public String getCdbh() {
            return cdbh;
        }

        public void setCdbh(String cdbh) {
            this.cdbh = cdbh;
        }

        public String getRybh() {
            return rybh;
        }

        public void setRybh(String rybh) {
            this.rybh = rybh;
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

        public String getCsrq() {
            return csrq;
        }

        public void setCsrq(String csrq) {
            this.csrq = csrq;
        }

        public String getFwcs() {
            return fwcs;
        }

        public void setFwcs(String fwcs) {
            this.fwcs = fwcs;
        }

        public String getLxdh() {
            return lxdh;
        }

        public void setLxdh(String lxdh) {
            this.lxdh = lxdh;
        }

        public String getHjxz() {
            return hjxz;
        }

        public void setHjxz(String hjxz) {
            this.hjxz = hjxz;
        }

        public String getZzxz() {
            return zzxz;
        }

        public void setZzxz(String zzxz) {
            this.zzxz = zzxz;
        }

    }
}
