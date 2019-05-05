package com.zhhl.analysis.di.module;

import com.zhhl.analysis.BuildConfig;
import com.zhhl.analysis.net.Api;
import com.zhhl.analysis.net.IModel;
import com.zhhl.analysis.net.ITrajectoryAnalysis;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by miao on 2018/6/21.
 */

@Module
public class NetworkModule {

    private static Retrofit retrofitCreator(OkHttpClient client, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        return builder
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();
    }

    @Singleton
    @Provides
    ITrajectoryAnalysis provideICountInterface(OkHttpClient client) {
        return retrofitCreator(client, Api.__BASED__.__BASED_Url).create(ITrajectoryAnalysis.class);
    }

    @Singleton
    @Provides
    IModel provideLoginInterface(OkHttpClient client) {
        return retrofitCreator(client, Api.__BASED__.__BASED_Url2).create(IModel.class);
    }
}
