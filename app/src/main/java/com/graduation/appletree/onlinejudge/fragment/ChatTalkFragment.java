package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

public class ChatTalkFragment extends BaseFragment{

    private RecyclerView rvChatTalk;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat_talk;
    }

    @Override
    protected void initViewAndEvent() {
        rvChatTalk = getRootView().findViewById(R.id.rv_chat_talk);
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
