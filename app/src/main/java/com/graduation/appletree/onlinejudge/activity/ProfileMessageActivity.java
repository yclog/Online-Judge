package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfileMessageAdapter;
import com.graduation.appletree.onlinejudge.bean.RVProfileMessageData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProfileMessageActivity extends BaseActivity{
    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.rv_profile_message)
    protected RecyclerView rv_profile_message;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_profile_message;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
        initRecoView();
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

    private void initView(){
        titlebar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileMessageActivity.this.finish();
            }
        });
    }

    private void initRecoView(){
        RVProfileMessageAdapter mRVProfileMessageAdapter = new RVProfileMessageAdapter(getContext(),getDataList());
        rv_profile_message.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_profile_message.setAdapter(mRVProfileMessageAdapter);
    }

    private List<RVProfileMessageData> getDataList(){
        List<RVProfileMessageData> mDataList = new ArrayList<>();
        mDataList.add(new RVProfileMessageData(R.drawable.avatar_system, "Oreo", "23:32"));
        mDataList.add(new RVProfileMessageData(R.drawable.avatar_system, "Oreo", "12:55"));
        mDataList.add(new RVProfileMessageData(R.drawable.avatar_system, "Oreo", "11:22"));
        return mDataList;
    }
}
