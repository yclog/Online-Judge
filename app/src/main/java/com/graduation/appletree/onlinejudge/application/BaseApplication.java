package com.graduation.appletree.onlinejudge.application;

import android.app.Application;

/**
 * Created by luke on 2018/3/22.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
