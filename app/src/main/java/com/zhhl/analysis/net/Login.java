package com.zhhl.analysis.net;


import com.zhhl.analysis.data.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by miao on 2018/9/27.
 */
public interface Login {
    @FormUrlEncoded
    @POST("/uas/sso/singlesignoncontrol/checkbill.do")
//    @POST("/test")
    Observable<LoginBean> login(@Field("strBill") String token);

}
