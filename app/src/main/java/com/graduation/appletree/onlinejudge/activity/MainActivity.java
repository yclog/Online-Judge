package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.FragmentPagerAdapter;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.eventbus.EventCode;
import com.graduation.appletree.onlinejudge.fragment.ChatFragment;
import com.graduation.appletree.onlinejudge.fragment.DiscussFragment;
import com.graduation.appletree.onlinejudge.fragment.HomeFragment;
import com.graduation.appletree.onlinejudge.fragment.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {

    private List<Fragment> mFragmentList;
    @BindView(R.id.home_viewpager)
    protected ViewPager homeVP;

    @BindView(R.id.bottom_menu_one)
    protected RelativeLayout bottom_menu_one;
    @BindView(R.id.bottom_menu_two)
    protected RelativeLayout bottom_menu_two;
    @BindView(R.id.bottom_menu_three)
    protected RelativeLayout bottom_menu_three;
    @BindView(R.id.bottom_menu_four)
    protected RelativeLayout bottom_menu_four;

    private static final int BOTTOM_PAGE_ONE = 0;
    private static final int BOTTOM_PAGE_TWO = 1;
    private static final int BOTTOM_PAGE_THREE = 2;
    private static final int BOTTOM_PAGE_FOUR = 3;

    private int mCurrentPage = 0;

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
        mFragmentList.add(new ProfileFragment());
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
                switch (position){
                    case BOTTOM_PAGE_ONE:{
                        EventBus.getDefault().post(new EventCenter<>(mCurrentPage, EventCode.BOTTOM_MENU_ONE_ACTIVE));
                        mCurrentPage = BOTTOM_PAGE_ONE;
                        break;
                    }
                    case BOTTOM_PAGE_TWO:{
                        EventBus.getDefault().post(new EventCenter<>(mCurrentPage, EventCode.BOTTOM_MENU_TWO_ACTIVE));
                        mCurrentPage = BOTTOM_PAGE_TWO;
                        break;
                    }
                    case BOTTOM_PAGE_THREE:{
                        EventBus.getDefault().post(new EventCenter<>(mCurrentPage, EventCode.BOTTOM_MENU_THREE_ACTIVE));
                        mCurrentPage = BOTTOM_PAGE_THREE;
                        break;
                    }
                    case BOTTOM_PAGE_FOUR:{
                        EventBus.getDefault().post(new EventCenter<>(mCurrentPage, EventCode.BOTTOM_MENU_FOUR_ACTIVE));
                        mCurrentPage = BOTTOM_PAGE_FOUR;
                        break;
                    }
                }
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

    /**
     * Send EventCode
     * */
    @OnClick({R.id.bottom_menu_one, R.id.bottom_menu_two, R.id.bottom_menu_three, R.id.bottom_menu_four})
    protected void sendEventCode(View view){
        switch (view.getId()){
            case R.id.bottom_menu_one:{
                homeVP.setCurrentItem(BOTTOM_PAGE_ONE);
                break;
            }
            case R.id.bottom_menu_two:{
                homeVP.setCurrentItem(BOTTOM_PAGE_TWO);
                break;
            }
            case R.id.bottom_menu_three:{
                homeVP.setCurrentItem(BOTTOM_PAGE_THREE);
                break;
            }
            case R.id.bottom_menu_four:{
                homeVP.setCurrentItem(BOTTOM_PAGE_FOUR);
                break;
            }
        }
    }
}
