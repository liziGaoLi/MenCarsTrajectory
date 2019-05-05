package com.zhhl.analysis.net.proxy;


import com.zhhl.analysis.mvp.model.LogReportData;
import com.zhhl.analysis.net.Api;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ILogUpload {

    @POST(Api.logReport)
    @Headers("content-type:application/json")
    Observable<Object> upload(@Body LogReportData data);

}
