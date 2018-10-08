package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * build a super base fragmentActivity class
 *
 * @author lucas
 * @date 2018/3/21
 */

public abstract class BaseActivity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check NetWork Status
        checkNetworkStatus();
        // setContentView
        setContentViewLayoutId();
        // Init Listener and Event
        initViewAndEvent();
        // add activity to BaseAppManager.mActivityStack
        BaseAppManager.getInstance().addActivty(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void finish() {
        super.finish();
        BaseAppManager.getInstance().removeActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    /***** Instance Method *****/

    /**
     * Check NetWork Status
     * */
    private void checkNetworkStatus(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo !=null ? true:false){
            Log.d("NetworkState", "Current Network is Connected ");
        } else {
            Log.d("NetworkState", "Current Network is unConnected ");
        }
    }

    /**
     * setContentView
     * */
    private void setContentViewLayoutId(){
        if (getContentViewLayoutID() != 0){
            setContentView(getContentViewLayoutID());
        } else {
            throw new IllegalArgumentException("Please make sure your LayoutId is valid");
        }
    }

    /**
     * Jump to Another Class without params
     *
     * @param targetClass
     * */
    protected void readyGo(Class<?> targetClass){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }

    /**
     * Jump to Another Class with params
     *
     * @param targetClass
     * @param bundle
     * */
    protected void readyGo(Class<?> targetClass,Bundle bundle){
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Jump to Another Class with requestCode
     *
     * @param targetClass
     * @param requestCode
     * */
    protected void readyGoForResult(Class<?> targetClass,int requestCode){
        Intent intent = new Intent(this, targetClass);
        startActivityForResult(intent, requestCode);
    }


    /***** Abstract Method *****/

    /**
     * Get ContentViewLayoutId
     *
     * @return LayoutID
     * */
    protected abstract int getContentViewLayoutID();

    /**
     * Init Listener and Event
     * */
    protected abstract void initViewAndEvent();

    /**
     * Handle EventBus's event
     *
     * @param eventCenter
     * */
    protected abstract void onEventComing(EventCenter eventCenter);

    /**
     * Get Context
     *
     * @return Context
     */
    protected abstract Context getContext();

    /**
     * EventBus
     *
     * @param eventCenter
     * */
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEventCenter(EventCenter eventCenter){
        if (eventCenter != null){
            onEventComing(eventCenter);
        }
    }
}
