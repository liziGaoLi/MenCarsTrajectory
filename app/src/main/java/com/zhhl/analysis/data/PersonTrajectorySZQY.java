package com.zhhl.analysis.data;

import java.util.List;

/**
 * Created by miao on 2018/10/10.
 */
public class PersonTrajectorySZQY {
    /**
     * success : true
     * msg : 查询成功
     * obj : [{"name":"冯金龙","phone":"16643416141","address":"长春市朝阳区力旺广场","identityNum":"220183199906051010","gasolineUse":"给汽车加97号汽油","litre":"20","createDate":null,"userid":"17600194545","id":"52E1DEBD377C44C8B3E831F2A2593E08","longitude":null,"latitude":null},{"name":"冯金龙","phone":"16643416141","address":"长春市朝阳区力旺广场","identityNum":"220183199906051010","gasolineUse":"给汽车加97号汽油","litre":"20","createDate":null,"userid":"17600194545","id":"52E1DEBD377C44C8B3E831F2A2593E08","longitude":null,"latitude":null}]
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
         * name : 冯金龙
         * phone : 16643416141
         * address : 长春市朝阳区力旺广场
         * identityNum : 220183199906051010
         * gasolineUse : 给汽车加97号汽油
         * litre : 20
         * createDate : null
         * userid : 17600194545
         * id : 52E1DEBD377C44C8B3E831F2A2593E08
         * longitude : null
         * latitude : null
         */

        private String name;
        private String phone;
        private String address;
        private String identityNum;
        private String gasolineUse;
        private String litre;
        private String createDate;
        private String userid;
        private String id;
        private String longitude;
        private String latitude;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIdentityNum() {
            return identityNum;
        }

        public void setIdentityNum(String identityNum) {
            this.identityNum = identityNum;
        }

        public String getGasolineUse() {
            return gasolineUse;
        }

        public void setGasolineUse(String gasolineUse) {
            this.gasolineUse = gasolineUse;
        }

        public String getLitre() {
            return litre;
        }

        public void setLitre(String litre) {
            this.litre = litre;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

    }
}
