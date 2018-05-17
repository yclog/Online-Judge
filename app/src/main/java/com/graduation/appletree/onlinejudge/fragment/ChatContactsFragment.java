package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

public class ChatContactsFragment extends BaseFragment{

    private RecyclerView rvChatContacts;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat_contacts;
    }

    @Override
    protected void initViewAndEvent() {
        rvChatContacts = getRootView().findViewById(R.id.rv_chat_contacts);
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
