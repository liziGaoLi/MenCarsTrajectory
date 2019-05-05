package com.zhhl.analysis.net;

import com.zhhl.analysis.data.CarInformation;
import com.zhhl.analysis.data.ChangQuDiData;
import com.zhhl.analysis.data.GxclData;
import com.zhhl.analysis.data.GxrData2;
import com.zhhl.analysis.data.SelfTrajectoryData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by miao on 2018/11/26.
 */
public interface IModel {

    @POST("/jeesite/shangfang/guiji")
    @FormUrlEncoded
    Observable<SelfTrajectoryData> selfTrajectory(@Field("sfzh") String sfzh, @Field("dateform") String dateform, @Field("dateto") String to, @Field("type") String type);

    @POST("/jeesite/shangfang/guiji")
    @FormUrlEncoded
    Observable<ChangQuDiData> frequented(@Field("sfzh") String sfzh, @Field("dateform") String dateform, @Field("dateto") String to, @Field("type") String type);

    @POST("/jeesite/zaitao/cheliang")
    @FormUrlEncoded
    Observable<GxclData> trajectoryGxcl(@Field("sfzh") String idNumber);

    @POST("/jeesite/zaitao/zhixixin")
    @FormUrlEncoded
    Observable<GxrData2> trajectoryGxr(@Field("sfzh") String idNumber, @Field("dateform") String dateform, @Field("dateto") String dateto);

    @POST("/jeesite/jinghao/clxx")
    @FormUrlEncoded
    Observable<CarInformation> carInformation(@Field("cph") String cph);

    @POST("/jeesite/jinghao/yanzheng")
    @FormUrlEncoded
    Observable<Boolean> checkPermission(@Field("jinghao") String jinghao, @Field("dizhi") String dizhi);
}
