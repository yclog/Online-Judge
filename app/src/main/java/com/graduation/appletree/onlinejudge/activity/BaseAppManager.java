package com.graduation.appletree.onlinejudge.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.Service;
import android.content.Context;

import java.util.ArrayList;

/**
 * A class to manager activities and fragments
 *
 * @author lucas
 * @date 2018/3/21
 */
public class BaseAppManager {

    private ArrayList<Activity> mActivityStack = new ArrayList<Activity>();
    private ArrayList<Fragment> mFragmentStack = new ArrayList<Fragment>();
    private ArrayList<Service> mServiceStack = new ArrayList<Service>();
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

    public void addFragment(Fragment fragment){
        mFragmentStack.add(fragment);
    }

    public void addService(Service service){
        mServiceStack.add(service);
    }

    private int getActivitySize(){
        return mActivityStack.size();
    }

    private int getFragmentSize(){
        return mFragmentStack.size();
    }

    private int getServiceSize(){
        return mServiceStack.size();
    }

    public void removeActivity(Activity activity){
        if (mActivityStack.contains(activity)) {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    public void removeFragment(Fragment fragment){
        if (mFragmentStack.contains(fragment))
            mFragmentStack.remove(fragment);
    }

    public void removeService(Service service){
        if (mServiceStack.contains(service)){
            mServiceStack.remove(service);
            service.stopSelf();
        }
    }

    private void clear(){
        //clear activity
        for (int i = mActivityStack.size()-1; i == 0 ; i--) {
            Activity activity = mActivityStack.get(i);
            removeActivity(activity);
        }

        //clear fragment
        for (int i = mFragmentStack.size()-1; i == 0 ; i--) {
            Fragment fragment = mFragmentStack.get(i);
            removeFragment(fragment);
        }

        //clear service
        for (int i = mServiceStack.size()-1; i == 0 ; i--) {
            Service service = mServiceStack.get(i);
            removeService(service);
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
