package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

public class ChatRoomActivity extends BaseActivity{

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_chat_room;
    }

    @Override
    protected void initViewAndEvent() {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected Context getContext() {
        return null;
    }
}
