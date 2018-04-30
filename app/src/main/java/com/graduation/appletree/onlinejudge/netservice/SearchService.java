package com.graduation.appletree.onlinejudge.netservice;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/***
 * 与RetroFit绑定接口
 */
public interface SearchService {

    @GET("README.md")
    Observable<Response<ResponseBody>> loadRxRepo();

    @POST("/post")
    Observable<Response<ResponseBody>> postRxRepo(@Body RequestBody body);

}
