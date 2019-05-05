package com.zhhl.analysis.data;

import java.util.List;

/**
 * Created by miao on 2018/10/10.
 */
public class PersonTrajectoryUnLock {
    /**
     * success : true
     * msg : 查询成功
     * obj : [{"id":"BC14CC6617494E5C9F4DA98A539E3EA6","address":"长春市前进大街繁荣路宇光小区","detailAddress":"12栋7013","unlockingPerson":"冯金龙","unlockingPersonNum":null,"byUnlockingPerson":"王俊杰","byUnlockingPersonNum":"220183199701011010","createDate":null,"userid":"17600194545","deptName":null,"longitude":null,"latitude":null},{"id":"BC14CC6617494E5C9F4DA98A539E3EA6","address":"长春市前进大街繁荣路宇光小区","detailAddress":"12栋7013","unlockingPerson":"冯金龙","unlockingPersonNum":null,"byUnlockingPerson":"王俊杰","byUnlockingPersonNum":"220183199701011010","createDate":null,"userid":"17600194545","deptName":null,"longitude":null,"latitude":null}]
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
         * id : BC14CC6617494E5C9F4DA98A539E3EA6
         * address : 长春市前进大街繁荣路宇光小区
         * detailAddress : 12栋7013
         * unlockingPerson : 冯金龙
         * unlockingPersonNum : null
         * byUnlockingPerson : 王俊杰
         * byUnlockingPersonNum : 220183199701011010
         * createDate : null
         * userid : 17600194545
         * deptName : null
         * longitude : null
         * latitude : null
         */

        private String id;
        private String address;
        private String detailAddress;
        private String unlockingPerson;
        private String unlockingPersonNum;
        private String byUnlockingPerson;
        private String byUnlockingPersonNum;
        private String createDate;
        private String userid;
        private String deptName;
        private String longitude;
        private String latitude;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDetailAddress() {
            return detailAddress;
        }

        public void setDetailAddress(String detailAddress) {
            this.detailAddress = detailAddress;
        }

        public String getUnlockingPerson() {
            return unlockingPerson;
        }

        public void setUnlockingPerson(String unlockingPerson) {
            this.unlockingPerson = unlockingPerson;
        }

        public String getUnlockingPersonNum() {
            return unlockingPersonNum;
        }

        public void setUnlockingPersonNum(String unlockingPersonNum) {
            this.unlockingPersonNum = unlockingPersonNum;
        }

        public String getByUnlockingPerson() {
            return byUnlockingPerson;
        }

        public void setByUnlockingPerson(String byUnlockingPerson) {
            this.byUnlockingPerson = byUnlockingPerson;
        }

        public String getByUnlockingPersonNum() {
            return byUnlockingPersonNum;
        }

        public void setByUnlockingPersonNum(String byUnlockingPersonNum) {
            this.byUnlockingPersonNum = byUnlockingPersonNum;
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

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

    }
}
