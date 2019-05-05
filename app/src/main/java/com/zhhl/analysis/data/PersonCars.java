package com.zhhl.analysis.data;

import java.util.List;

/**
 * Created by miao on 2018/10/29.
 */
public class PersonCars {
    /**
     * success : true
     * msg : 查询成功
     * obj : [{"id":"4","name":"冯金龙","idcard":"220183199606051012","car":"吉BLP559"},{"id":"5","name":"冯金龙","idcard":"220183199606051012","car":"吉BKV053"},{"id":"6","name":"冯金龙","idcard":"220183199606051012","car":"吉BT5780"}]
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
         * id : 4
         * name : 冯金龙
         * idcard : 220183199606051012
         * car : 吉BLP559
         */

        private String id;
        private String name;
        private String idcard;
        private String car;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getCar() {
            return car;
        }

        public void setCar(String car) {
            this.car = car;
        }
    }
}
