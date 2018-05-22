package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.activity.ProblemAlgorithmActivity;
import com.graduation.appletree.onlinejudge.activity.RankActivity;
import com.graduation.appletree.onlinejudge.adapter.RVHomeRankAdapter;
import com.graduation.appletree.onlinejudge.adapter.RVHomeSolutionAdapter;
import com.graduation.appletree.onlinejudge.bean.RVHomeRankData;
import com.graduation.appletree.onlinejudge.bean.RVHomeSolutionData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private final String TAG = this.getClass().getName();

    /**
     * 视图
     * */
    protected ConvenientBanner home_ad_vp;
    protected RelativeLayout home_algorithm;
    protected RelativeLayout home_osystem;
    protected RelativeLayout home_database;
    protected RelativeLayout home_shell;

    protected RecyclerView rv_home_rank;
    protected RecyclerView rv_home_solution;
    protected LinearLayout rank;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
        initAdViewPager();
        initRecoView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_algorithm:{
                readyGo(ProblemAlgorithmActivity.class);
                break;
            }
            case R.id.rank:{
                readyGo(RankActivity.class);
                break;
            }
            default:{
                Log.d(TAG, "Invalid Click");
                break;
            }
        }
    }

    /**
     * Instance Method
     * */

    private void initAdViewPager(){}

    private void initView(){
        home_algorithm = getRootView().findViewById(R.id.home_algorithm);
        home_algorithm.setOnClickListener(this);
        home_osystem = getRootView().findViewById(R.id.home_osystem);
        home_osystem.setOnClickListener(this);
        home_database = getRootView().findViewById(R.id.home_database);
        home_database.setOnClickListener(this);
        home_shell = getRootView().findViewById(R.id.home_shell);
        home_shell.setOnClickListener(this);
        rv_home_rank = getRootView().findViewById(R.id.rv_home_rank);
        rv_home_solution = getRootView().findViewById(R.id.rv_home_solution);
        rank = getRootView().findViewById(R.id.rank);
        rank.setOnClickListener(this);
    }

    private void initRecoView(){
        //Home Rank RecyclerView
        RVHomeRankAdapter mRVHomeRankAdapter = new RVHomeRankAdapter(getContext(), getHomeRankList());
        rv_home_rank.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_home_rank.setAdapter(mRVHomeRankAdapter);
        //Home Solution RecyclerView
        RVHomeSolutionAdapter mRVHomeSolutionAdapter = new RVHomeSolutionAdapter(getContext(),getHomeSolutionList());
        rv_home_solution.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_home_solution.setAdapter(mRVHomeSolutionAdapter);
    }

    private List<RVHomeRankData> getHomeRankList(){
        List<RVHomeRankData> mDataList = new ArrayList<>();
        RVHomeRankData test = new RVHomeRankData();
        test.setHome_rank_avatar(R.drawable.hugh);
        test.setHome_rank_name("No.1");
        test.setHome_rank_num(1);
        mDataList.add(test);
        RVHomeRankData test2 = new RVHomeRankData();
        test2.setHome_rank_avatar(R.drawable.hugh);
        test2.setHome_rank_name("No.2");
        test2.setHome_rank_num(2);
        mDataList.add(test2);
        RVHomeRankData test3 = new RVHomeRankData();
        test3.setHome_rank_avatar(R.drawable.hugh);
        test3.setHome_rank_name("No.3");
        test3.setHome_rank_num(3);
        mDataList.add(test3);
        return mDataList;
    }

    private List<RVHomeSolutionData> getHomeSolutionList(){
        List<RVHomeSolutionData> mDataList = new ArrayList<>();
        RVHomeSolutionData test = new RVHomeSolutionData();
        test.setHome_solution_avatar(R.drawable.hugh);
        test.setHome_solution_nickname("deerlog");
        test.setHome_solution_title("make test");
        test.setHome_solution_biref("test brief");
        mDataList.add(test);
        RVHomeSolutionData test1 = new RVHomeSolutionData();
        test1.setHome_solution_avatar(R.drawable.hugh);
        test1.setHome_solution_nickname("deerlog");
        test1.setHome_solution_title("make test");
        test1.setHome_solution_biref("test brief");
        mDataList.add(test1);
        RVHomeSolutionData test2 = new RVHomeSolutionData();
        test2.setHome_solution_avatar(R.drawable.hugh);
        test2.setHome_solution_nickname("deerlog");
        test2.setHome_solution_title("make test");
        test2.setHome_solution_biref("test brief");
        mDataList.add(test2);
        return mDataList;
    }
}
