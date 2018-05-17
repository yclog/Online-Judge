package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

public class ChatMessagesFragment extends BaseFragment{

    private RecyclerView rvChatMessages;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat_messages;
    }

    @Override
    protected void initViewAndEvent() {
        rvChatMessages = getRootView().findViewById(R.id.rv_chat_messages);
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
