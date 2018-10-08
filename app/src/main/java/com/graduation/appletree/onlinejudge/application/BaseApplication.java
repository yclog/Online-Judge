package com.graduation.appletree.onlinejudge.application;

import android.app.Application;

/**
 * BaseApplication
 *
 * @author lucas
 * @date 2018/3/21
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
