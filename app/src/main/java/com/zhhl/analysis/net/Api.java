package com.zhhl.analysis.net;

public interface Api {

    String logReport = "/police/log/save";

    interface __BASED__ {
        //        String __BASED_Url = "http://yj.jlsgaj.cn:5380/";
        String __LoginD_Url = "http://192.168.20.230:8081/";
        String __BASED_Url = "http://192.168.20.228:7103/";
        String __BASED_Url2 = "http://192.168.20.228:7098/";
    }

    /**
     * 1、查询车辆信息（轨迹）
     */
    String carTrajectory = "/police/gjfx/findClxxByHPHM";
    String carTrajectory3 = "/police/gjfx/findClxxByHPHM1";
    /**
     * 2、查询人员信息（轨迹）
     */
    String personTrajectory = "/police/gjfx/findRyxxByGMSFHM";

    /**
     * 3、查询车辆信息（企业微信数据）
     */
    String carTrajectory2 = "/police/gjfx/findClxxByCarnumber";

    /**
     * 4、查询人员信息（企业微信数据）
     */
    String personTrajectory2 = "/police/gjfx/findRyxxByIdNumber";

    /**
     * 5、查询人员信息（企业微信数据）
     */
    String unLockTrajectory = "/police/gjfx/findKsxxByIdNumber";

    /**
     * 6、查询散装汽油（企业微信数据）
     */
    String szqyTrajectory = "/police/gjfx/findSzqyByIdNumber";
    /**
     * 7、查询无证入住（企业微信数据）
     */
    String noIdTrajectory = "/police/gjfx/findWzrzByIdNumber";
    /**
     * 8、查询人员车辆信息
     */
    String idHasCar = "/police/gjfx/findRyClInfoByIdCard";
}
