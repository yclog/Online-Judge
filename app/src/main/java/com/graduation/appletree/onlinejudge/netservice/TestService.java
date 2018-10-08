package com.graduation.appletree.onlinejudge.netservice;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Retrofit Service
 *
 * @author lucas
 * @date 2018/3/21
 */
public interface TestService {

    @GET("README.md")
    Observable<Response<ResponseBody>> loadRxRepo();

    @POST("/post")
    Observable<Response<ResponseBody>> postRxRepo(@Body RequestBody body);

    @POST("/post")
    Observable<Response<ResponseBody>> login(@Body RequestBody body);
}
