package com.zhhl.analysis.data;

import java.util.List;

/**
 * Created by miao on 2018/10/10.
 */
public class PersonTrajectoryNoId {
    /**
     * success : true
     * msg : 查询成功
     * obj : [{"id":"037424BBC7EE418EA48BA8474FFC79E2","image":"","identityNum":"220183199606051012","result":"","createDate":"2018-07-30 08:34:40","name":"冯金龙","userid":"","phone":"1","address":"吉林省长春市朝阳区南湖街道前进大街力旺广场","longitude":"","latitude":""},{"id":"0F0D055136884C5CB0DCDB4AFE1D569A","image":null,"identityNum":"220183199606051012","result":null,"createDate":"2018-07-27 10:03:39","name":"冯金龙","userid":null,"phone":"1","address":"吉林省长春市朝阳区南湖街道前进大街力旺广场","longitude":null,"latitude":null},{"id":"15847AFE37D44924BE4997E6AD0D45C9","image":null,"identityNum":"220183199606051012","result":null,"createDate":"2018-07-27 10:35:17","name":"冯金龙","userid":null,"phone":"1","address":"吉林省长春市朝阳区南湖街道前进大街力旺广场","longitude":null,"latitude":null},{"id":"8ECF780BE60144749EA337932ACECC0B","image":null,"identityNum":"220183199606051012","result":null,"createDate":"2018-07-30 08:38:14","name":"冯金龙","userid":null,"phone":"1","address":"吉林省长春市朝阳区南湖街道前进大街力旺广场","longitude":null,"latitude":null}]
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
         * id : 037424BBC7EE418EA48BA8474FFC79E2
         * image :
         * identityNum : 220183199606051012
         * result :
         * createDate : 2018-07-30 08:34:40
         * name : 冯金龙
         * userid :
         * phone : 1
         * address : 吉林省长春市朝阳区南湖街道前进大街力旺广场
         * longitude :
         * latitude :
         */

        private String id;
        private String image;
        private String identityNum;
        private String result;
        private String createDate;
        private String name;
        private String userid;
        private String phone;
        private String address;
        private String longitude;
        private String latitude;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getIdentityNum() {
            return identityNum;
        }

        public void setIdentityNum(String identityNum) {
            this.identityNum = identityNum;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
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
