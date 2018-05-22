package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProblemAdapter;
import com.graduation.appletree.onlinejudge.bean.RVProblemData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProblemAlgorithmActivity extends BaseActivity{

    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.rv_problem_algorithm)
    protected RecyclerView rv_problem_algorithm;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_problem_algorithm;
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
                ProblemAlgorithmActivity.this.finish();
            }
        });
    }

    private void initRecoView(){
        RVProblemAdapter mRVProblemAdapter = new RVProblemAdapter(getContext(),getDataList());
        rv_problem_algorithm.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_problem_algorithm.setAdapter(mRVProblemAdapter);
    }

    private List<RVProblemData> getDataList(){
        List<RVProblemData> mDataList = new ArrayList<>();
        mDataList.add(new RVProblemData(0, 1, "Test1", "32%", 2));
        mDataList.add(new RVProblemData(1, 2, "Test2", "33%", 0));
        mDataList.add(new RVProblemData(2, 3, "Test3", "52%", 0));
        mDataList.add(new RVProblemData(0, 4, "Test4", "46%", 2));
        return mDataList;
    }
}
