package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfilePointAdapter;
import com.graduation.appletree.onlinejudge.bean.RVProfilePointData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Personal Point
 *
 * @author lucas
 * @date 2018/3/21
 */
public class ProfilePointActivity extends BaseActivity{
    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.rv_profile_point)
    protected RecyclerView rv_profile_point;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_profile_point;
    }

    @Override
    protected void initViewAndEvent() {
        InitView();
        InitRecoView();
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

    private void InitView(){
        titlebar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfilePointActivity.this.finish();
            }
        });
    }

    private void InitRecoView(){
        RVProfilePointAdapter mRVProfilePointAdapter = new RVProfilePointAdapter(getContext(), getDataList());
        rv_profile_point.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_profile_point.setAdapter(mRVProfilePointAdapter);
    }

    private List<RVProfilePointData> getDataList(){
        List<RVProfilePointData> mDataList = new ArrayList<>();
        mDataList.add(new RVProfilePointData("Saturday, May 19, 2018, 3:44 PM","+1",
                "Mission","Completed a daily check-in mission"));
        mDataList.add(new RVProfilePointData("Saturday, May 19, 2018, 3:44 PM","+1",
                "Mission","Completed a daily check-in mission"));
        mDataList.add(new RVProfilePointData("Saturday, May 19, 2018, 3:44 PM","+1",
                "Mission","Completed a daily check-in mission"));
        return mDataList;
    }
}
