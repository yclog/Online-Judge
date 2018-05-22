package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVDiscussAdapter;
import com.graduation.appletree.onlinejudge.bean.RVDiscussData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

public class DiscussFragment extends BaseFragment{

    protected RecyclerView rv_discuss;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_discuss;
    }

    @Override
    protected void initViewAndEvent() {
        InitView();
        InitRecoView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    /**
     * Instance Method
     * */
    private void InitView(){
        rv_discuss = getRootView().findViewById(R.id.rv_discuss);
    }

    private void InitRecoView(){
        RVDiscussAdapter mRVDiscussAdapter = new RVDiscussAdapter(getContext(),getDataList());
        rv_discuss.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_discuss.setAdapter(mRVDiscussAdapter);
    }

    private List<RVDiscussData> getDataList(){
        List<RVDiscussData> mDataList = new ArrayList<>();
        mDataList.add(new RVDiscussData(R.drawable.hugh, "deerlog", "Test", "Test Brief"));
        mDataList.add(new RVDiscussData(R.drawable.hugh, "deerlog", "Test", "Test Brief"));
        mDataList.add(new RVDiscussData(R.drawable.hugh, "deerlog", "Test", "Test Brief"));
        mDataList.add(new RVDiscussData(R.drawable.hugh, "deerlog", "Test", "Test Brief"));
        return mDataList;
    }
}
