package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfileSubmissionAdapter;
import com.graduation.appletree.onlinejudge.bean.RVProfileSubmissionData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Personal Submission
 *
 * @author lucas
 * @date 2018/3/21
 */
public class ProfileSubmissionActivity extends BaseActivity{

    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.rv_profile_submission)
    protected RecyclerView rv_profile_submission;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_profile_submission;
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
                ProfileSubmissionActivity.this.finish();
            }
        });
    }

    private void initRecoView(){
        RVProfileSubmissionAdapter mRVProfileSubmissionAdapter = new RVProfileSubmissionAdapter(getContext(),getDataList());
        rv_profile_submission.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_profile_submission.setAdapter(mRVProfileSubmissionAdapter);
    }

    private List<RVProfileSubmissionData> getDataList(){
        List<RVProfileSubmissionData> mDataList = new ArrayList<>();
        mDataList.add(new RVProfileSubmissionData("Two Sum", "Accepted", "10ms", "java"));
        mDataList.add(new RVProfileSubmissionData("Two Sum", "Runtime Error", "N/A", "java"));
        mDataList.add(new RVProfileSubmissionData("Two Sum", "Runtime Error", "N/A", "java"));
        mDataList.add(new RVProfileSubmissionData("Add Two Numbers", "Accepted", "24ms", "java"));
        mDataList.add(new RVProfileSubmissionData("Add Two Numbers", "Runtime Error", "N/A", "java"));
        mDataList.add(new RVProfileSubmissionData("Add Two Numbers", "Runtime Error", "N/A", "java"));
        return mDataList;
    }
}
