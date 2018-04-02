package com.graduation.appletree.onlinejudge.utils;

import com.graduation.appletree.onlinejudge.netservice.SearchService;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wangchengyuan on 2018/3/21.
 * Network Utls
 * RxJava + Retrofit
 */

public class NetRequestUtil {

    private static NetRequestUtil NetRequestUtilInstance;
    private SearchService searchService;
    private Retrofit mRetrofit;
    private String baseUrl = "http://www.roundsapp.com/";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    //SingleTon
    public static NetRequestUtil getInstance() {
        if (NetRequestUtilInstance == null) {
            synchronized (NetRequestUtil.class) {
                if (NetRequestUtilInstance == null) {
                    NetRequestUtilInstance = new NetRequestUtil();
                }
            }
        }
        return NetRequestUtilInstance;
    }

    /**
     *  Get Method for test
     *  @param reqUrl must start without "/" and end with "/"
     *  @param subscriber
     * */
    public void getTestMethod(String reqUrl,Subscriber<Response<ResponseBody>> subscriber){
        initRetrofit(baseUrl + reqUrl);
        searchService.loadRxRepo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     *  Post Method for test
     *  @param reqUrl must start without "/" and end with "/"
     *  @param subscriber
     * */
    public void postTestMethod(String reqUrl,String json,Subscriber<Response<ResponseBody>> subscriber){
        initRetrofit(baseUrl + reqUrl);
        RequestBody body = RequestBody.create(JSON, json);
        searchService.postRxRepo(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     *  init Retrofit
     *  @param url
     * */
    private void initRetrofit(String url){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        searchService = mRetrofit.create(SearchService.class);
    }
}
