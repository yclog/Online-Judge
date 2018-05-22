package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVChatTalkAdapter;
import com.graduation.appletree.onlinejudge.bean.RVChatTalkData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

public class ChatTalkFragment extends BaseFragment{

    private RecyclerView rv_chat_talk;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat_talk;
    }

    @Override
    protected void initViewAndEvent() {
        rv_chat_talk = getRootView().findViewById(R.id.rv_chat_talk);
        InitRecoView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    /**
     * Instance Method
     * */
    private void InitRecoView(){
        RVChatTalkAdapter mRVChatTalkAdapter = new RVChatTalkAdapter(getContext(),getDataList());
        rv_chat_talk.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_chat_talk.setAdapter(mRVChatTalkAdapter);
    }

    private List<RVChatTalkData> getDataList(){
        List<RVChatTalkData> mDataList = new ArrayList<>();
        mDataList.add(new RVChatTalkData(R.drawable.hugh, 1, "AppleTree", "Hello World", "12:23"));
        mDataList.add(new RVChatTalkData(R.drawable.hugh, 0, "AppleTree", "Hello World", "12:23"));
        mDataList.add(new RVChatTalkData(R.drawable.hugh, 2, "AppleTree", "Hello World", "12:23"));
        mDataList.add(new RVChatTalkData(R.drawable.hugh, 1, "AppleTree", "Hello World", "12:23"));
        return mDataList;
    }
}
