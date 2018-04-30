package com.graduation.appletree.onlinejudge.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;

import java.util.ArrayList;

public class BaseAppManager {

    private ArrayList<Activity> mActivityStack =new ArrayList<Activity>();
    private ArrayList<Service> mServiceStack =new ArrayList<Service>();
    private static BaseAppManager mInstance;

    public static BaseAppManager getInstance(){
        if (mInstance == null){
            synchronized (BaseAppManager.class){
                if (mInstance == null){
                    mInstance = new BaseAppManager();
                }
            }
        }
        return mInstance;
    }

    public void addActivty(Activity activity){
        mActivityStack.add(activity);
    }

    public void addService(Service service){
        mServiceStack.add(service);
    }

    private int getActivitySize(){
        return mActivityStack.size();
    }

    private int getServiceSize(){
        return mServiceStack.size();
    }

    public void removeActivity(Activity activity){
        if (mActivityStack.contains(activity))
            mActivityStack.remove(activity);
    }

    public void removeService(Service service){
        if (mServiceStack.contains(service))
            mServiceStack.remove(service);
    }

    private void clear(){
        //clear activity
        for (int i = mActivityStack.size()-1; i == 0 ; i++) {
            Activity activity = mActivityStack.get(i);
            removeActivity(activity);
            activity.finish();
        }

        //clear service
        for (int i = mServiceStack.size()-1; i == 0 ; i++) {
            Service service = mServiceStack.get(i);
            removeService(service);
            service.stopSelf();
        }
    }

    public void appExit(Context context){
        try {
            clear();
            if (context != null) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
                if (activityManager != null) {
                    activityManager.killBackgroundProcesses(context.getPackageName());
                }
                System.exit(0);
            }
        } catch (Exception e){
            System.exit(0);
            e.printStackTrace();
        }
    }
}
