package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVChatMessageAdapter;
import com.graduation.appletree.onlinejudge.bean.RVChatMessageData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Message In Chat View
 *
 * @author lucas
 * @date 2018/3/21
 */
public class ChatMessagesFragment extends BaseFragment{

    private static ChatMessagesFragment mInstance;

    private RecyclerView rv_chat_message;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat_messages;
    }

    @Override
    protected void initViewAndEvent() {
        rv_chat_message = getRootView().findViewById(R.id.rv_chat_messages);
        InitRecoView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    /**
     * Instance Method
     * */

    public static ChatMessagesFragment getInstance(){
        if (mInstance == null){
            mInstance = new ChatMessagesFragment();
        }
        return mInstance;
    }

    private void InitRecoView(){
        RVChatMessageAdapter mRVChatMessageAdapter = new RVChatMessageAdapter(getContext(), getDataList());
        rv_chat_message.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_chat_message.setAdapter(mRVChatMessageAdapter);
    }

    private List<RVChatMessageData> getDataList(){
        List<RVChatMessageData> mDataList = new ArrayList<>();
        mDataList.add(new RVChatMessageData(R.drawable.avatar_five, "Update Username","17.24"));
        mDataList.add(new RVChatMessageData(R.drawable.hugh, "李老师发布任务：完成前三题","17：00"));
        mDataList.add(new RVChatMessageData(R.drawable.hugh, "李老师发布任务：分析官方文档","8：24"));
        mDataList.add(new RVChatMessageData(R.drawable.hugh, "李老师发布任务：完成总结","17：36"));
        return mDataList;
    }
}
