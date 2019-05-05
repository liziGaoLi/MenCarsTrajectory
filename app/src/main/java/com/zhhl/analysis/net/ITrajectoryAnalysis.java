package com.zhhl.analysis.net;

import com.zhhl.analysis.data.CarTrajectoryBayonet;
import com.zhhl.analysis.data.PersonTrajectoryNoId;
import com.zhhl.analysis.data.PersonTrajectorySZQY;
import com.zhhl.analysis.data.PersonTrajectoryUnLock;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ITrajectoryAnalysis {
    /**
     * 查询车辆信息（轨迹）
     *
     * @param hphm 车牌号码
     */
    @FormUrlEncoded
    @POST(Api.carTrajectory3)
    Observable<CarTrajectoryBayonet> carTrajectory(@Field("hphm") String hphm, @Field("formToDate") String formToDate, @Field("formEndDate") String formEndDate);


    @FormUrlEncoded
    @POST(Api.carTrajectory)
    Observable<CarTrajectoryBayonet> carTrajectory(@Field("hphm") String hphm, @Field("jh") String jh);

    /**
     * 5、查询开锁信息（企业微信数据）
     */
    @FormUrlEncoded
    @POST(Api.unLockTrajectory)
    Observable<PersonTrajectoryUnLock> unLockTrajectory(@Field("idNumber") String idNumber, @Field("formToDate") String formToDate, @Field("formEndDate") String formEndDate);

    /**
     * 6、查询散装汽油（企业微信数据）
     */
    @FormUrlEncoded
    @POST(Api.szqyTrajectory)
    Observable<PersonTrajectorySZQY> szqyTrajectory(@Field("idNumber") String idNumber, @Field("formToDate") String formToDate, @Field("formEndDate") String formEndDate);

    /**
     * 7、查询无证入住（企业微信数据）
     */
    @POST(Api.noIdTrajectory)
    @FormUrlEncoded
    Observable<PersonTrajectoryNoId> noIdTrajectory(@Field("idNumber") String idNumber, @Field("formToDate") String formToDate, @Field("formEndDate") String formEndDate);
}