package com.graduation.appletree.onlinejudge.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.graduation.appletree.onlinejudge.activity.BaseAppManager;
import com.graduation.appletree.onlinejudge.application.crash.CustomCrashHandler;

/**
 * Created by wangchengyuan on 2018/3/21.
 */

public class DemoApplication extends BaseApplication implements Application.ActivityLifecycleCallbacks{

    private static DemoApplication demoApplicationInstance;
    private Handler mHandler;

    public static DemoApplication getInstance(){
        if (demoApplicationInstance == null){
            synchronized (DemoApplication.class){
                if (demoApplicationInstance == null){
                    demoApplicationInstance = new DemoApplication();
                }
            }
        }
        return demoApplicationInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(this);
        mHandler = new Handler(Looper.myLooper());

        CustomCrashHandler mCustomCrashHandler = CustomCrashHandler.getInstance();
        mCustomCrashHandler.setCustomCrashHandler(getApplicationContext());
    }

    public void exitApplication(){
        BaseAppManager.getInstance().appExit(this);
    }

    private Context getContext(){
        return this;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
