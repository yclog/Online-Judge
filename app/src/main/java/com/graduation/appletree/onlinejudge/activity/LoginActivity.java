package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import butterknife.BindView;

public class LoginActivity extends BaseActivity{

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected Context getContext() {
        return this;
    }

    /**
     * Instance Method
     * */

    private void initView(){}
}
