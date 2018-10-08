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
 * StandardApplication
 *
 * @author lucas
 * @date 2018/3/21
 */

public class StandardApplication extends BaseApplication implements Application.ActivityLifecycleCallbacks{

    private static StandardApplication demoApplicationInstance;
    private Handler mHandler;

    public static StandardApplication getInstance(){
        if (demoApplicationInstance == null){
            synchronized (StandardApplication.class){
                if (demoApplicationInstance == null){
                    demoApplicationInstance = new StandardApplication();
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
