package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfileSessionAdapter;
import com.graduation.appletree.onlinejudge.bean.RVProfileSessionData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Personal Session
 *
 * @author lucas
 * @date 2018/3/21
 */
public class ProfileSessionActivity extends BaseActivity{
    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.rv_profile_session)
    protected RecyclerView rv_profile_session;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_profile_session;
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
                ProfileSessionActivity.this.finish();
            }
        });
    }

    private void initRecoView(){
        RVProfileSessionAdapter mRVProfileSessionAdapter = new RVProfileSessionAdapter(getContext(),getDataList());
        rv_profile_session.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_profile_session.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        rv_profile_session.setAdapter(mRVProfileSessionAdapter);
    }

    private List<RVProfileSessionData> getDataList(){
        List<RVProfileSessionData> mDataList = new ArrayList<>();
        mDataList.add(new RVProfileSessionData(1,"完成前三题",
                "李老师","2018/5/19","2018/5/25"));
        mDataList.add(new RVProfileSessionData(2,"分析官方solution",
                "李老师","2018/5/25","2018/5/26"));
        mDataList.add(new RVProfileSessionData(3,"完成总结",
                "李老师","2018/5/26","2018/5/27"));
        return mDataList;
    }
}
