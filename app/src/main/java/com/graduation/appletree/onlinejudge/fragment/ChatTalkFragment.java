package com.graduation.appletree.onlinejudge.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.activity.ChatRoomActivity;
import com.graduation.appletree.onlinejudge.adapter.RVChatTalkAdapter;
import com.graduation.appletree.onlinejudge.adapter.RVProblemAdapter;
import com.graduation.appletree.onlinejudge.bean.RVChatTalkData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

public class ChatTalkFragment extends BaseFragment{

    private static ChatTalkFragment mInstance;

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

    public static ChatTalkFragment getInstance(){
        if (mInstance == null){
            mInstance = new ChatTalkFragment();
        }
        return mInstance;
    }

    private void InitRecoView(){
        RVChatTalkAdapter mRVChatTalkAdapter = new RVChatTalkAdapter(getContext(),getDataList());
        mRVChatTalkAdapter.setOnItemClickListener(new RVChatTalkAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String talk_name) {
                Bundle bundle = new Bundle();
                bundle.putString("name",talk_name);
                readyGo(ChatRoomActivity.class, bundle);
            }
        });
        rv_chat_talk.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_chat_talk.setAdapter(mRVChatTalkAdapter);
    }

    private List<RVChatTalkData> getDataList(){
        List<RVChatTalkData> mDataList = new ArrayList<>();
        mDataList.add(new RVChatTalkData(0, R.drawable.avatar_two, 1, "Deerlog", "Let's work", "23:15"));
        mDataList.add(new RVChatTalkData(1, R.drawable.avatar_five, 0, "付健", "下午一起吃肉", "20:58"));
        mDataList.add(new RVChatTalkData(2, R.drawable.avatar_nine, 2, "金朝麟", "什么时候去旅游", "18:23"));
        mDataList.add(new RVChatTalkData(3, R.drawable.avatar_six, 1, "SpritCan", "病好了没", "10:15"));
        mDataList.add(new RVChatTalkData(4, R.drawable.avatar_four, 1, "张平", "明天拍毕业照", "12:29"));
        mDataList.add(new RVChatTalkData(4, R.drawable.avatar_eight, 1, "沙瑞金", "我的代码有bug", "yesterday"));
        return mDataList;
    }
}
