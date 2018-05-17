package com.graduation.appletree.onlinejudge.fragment;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.activity.ProblemAlgorithmActivity;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import butterknife.BindView;

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

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
        initAdViewPager();
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
    }
}
