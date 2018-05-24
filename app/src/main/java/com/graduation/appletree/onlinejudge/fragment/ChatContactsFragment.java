package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVChatContactAdapter;
import com.graduation.appletree.onlinejudge.bean.RVChatContactData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

public class ChatContactsFragment extends BaseFragment{

    private static ChatContactsFragment mInstance;

    private RecyclerView rv_chat_contact;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat_contacts;
    }

    @Override
    protected void initViewAndEvent() {
        rv_chat_contact = getRootView().findViewById(R.id.rv_chat_contacts);
        InitRecoView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    /**
     * Instance Method
     * */
    public static ChatContactsFragment getInstance(){
        if (mInstance == null){
            mInstance = new ChatContactsFragment();
        }
        return mInstance;
    }

    private void InitRecoView(){
        RVChatContactAdapter mRVChatContactAdapter = new RVChatContactAdapter(getContext(),getDataList());
        rv_chat_contact.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_chat_contact.setAdapter(mRVChatContactAdapter);
    }

    private List<RVChatContactData> getDataList(){
        List<RVChatContactData> mDataList = new ArrayList<>();
        mDataList.add(new RVChatContactData(R.drawable.avatar_two,"Deerlog"));
        mDataList.add(new RVChatContactData(R.drawable.avatar_six,"SpritCan"));
        mDataList.add(new RVChatContactData(R.drawable.avatar_nine,"金朝麟"));
        mDataList.add(new RVChatContactData(R.drawable.avatar_five,"付健"));
        mDataList.add(new RVChatContactData(R.drawable.avatar_eight,"沙瑞金"));
        mDataList.add(new RVChatContactData(R.drawable.avatar_four,"张平"));
        return mDataList;
    }
}
