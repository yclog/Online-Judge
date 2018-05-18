package com.graduation.appletree.onlinejudge.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public abstract class BaseFragment extends Fragment{

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getContentViewLayoutID(), container, false);
        initViewAndEvent();
        EventBus.getDefault().register(this);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Instance Method
     * */

    // Jump to Another Class without params
    protected void readyGo(Class<?> targetClass){
        Intent intent = new Intent(getContext(), targetClass);
        startActivity(intent);
    }

    // Jump to Another Class with params
    protected void readyGo(Class<?> targetClass, Bundle bundle){
        Intent intent = new Intent(getContext(), targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    // Jump to Another Class with params
    protected void readyGo(Class<?> targetClass, String key, String value){
        Intent intent = new Intent(getContext(), targetClass);
        intent.putExtra(key, value);
        startActivity(intent);
    }

    // Jump to Another Class with requestCode
    protected void readyGoForResult(Class<?> targetClass, int requestCode){
        Intent intent = new Intent(getContext(), targetClass);
        startActivityForResult(intent, requestCode);
    }

    protected View getRootView(){
        return rootView;
    }

    /**
     * Abstract Method
     * */

    // Get ContentViewLayoutId
    protected abstract int getContentViewLayoutID();

    // Init Listener and Event
    protected abstract void initViewAndEvent();

    //Handle EventBus's event
    protected abstract void onEventComing(EventCenter eventCenter);

    /**
     * EventBus
     * */
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEventCenter(EventCenter eventCenter){
        if (eventCenter != null){
            onEventComing(eventCenter);
        }
    }
}
