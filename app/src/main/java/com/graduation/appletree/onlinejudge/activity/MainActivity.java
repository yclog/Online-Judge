package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.FragmentPagerAdapter;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.fragment.ChatFragment;
import com.graduation.appletree.onlinejudge.fragment.DiscussFragment;
import com.graduation.appletree.onlinejudge.fragment.HomeFragment;
import com.graduation.appletree.onlinejudge.fragment.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private List<Fragment> mFragmentList;
    @BindView(R.id.home_viewpager)
    protected ViewPager homeVP;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewAndEvent() {
        initNavigationViewPager();
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
    private void initNavigationViewPager(){
        /**
         * 初始化viewpager控件
         * */
        mFragmentList = new ArrayList<>();
        /**
         * 为fragmentViewpagerList添加fragment
         * */
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new DiscussFragment());
        mFragmentList.add(new ChatFragment());
        mFragmentList.add(new PersonalFragment());
        /**
         * 添加Viewpager滑动监听事件
         * */
        homeVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //Viewpager重写方法
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //翻页时事件
            }

            @Override
            public void onPageSelected(int position) {
                //该方法为当前选定页面事件
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //该方法为翻页状态变化事件
            }
        });
        /**
         * viewpager设置adapter
         * */
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        homeVP.setAdapter(adapter);
    }
}
