package com.graduation.appletree.onlinejudge.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.FragmentPagerAdapter;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.eventbus.EventCode;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class ChatFragment extends BaseFragment implements View.OnClickListener{

    private List<Fragment> mFragmentList;
    protected ViewPager chatVP;

    private final String TAG = this.getClass().getName();

    private static final int TALK_PAGE_ONE = 0;
    private static final int TALK_PAGE_TWO = 1;
    private static final int TALK_PAGE_THREE = 2;

    private int mCurrentPage = 0;

    protected RelativeLayout chat_vp_one;
    protected RelativeLayout chat_vp_two;
    protected RelativeLayout chat_vp_three;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat;
    }

    @Override
    protected void initViewAndEvent() {
        //Init ViewPager Menu
        initVPMenu();
        //Init Chat ViewPager
        initChatVP();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    public void onClick(View view) {
        sendEventCode(view);
    }

    /**
     * Instance Method
     * */
    private void initChatVP(){
        /**
         * 初始化viewpager控件
         * */
        mFragmentList = new ArrayList<>();
        chatVP = getRootView().findViewById(R.id.chat_vp);
        /**
         * 为fragmentViewpagerList添加fragment
         * */
        mFragmentList.add(new ChatTalkFragment());
        mFragmentList.add(new ChatContactsFragment());
        mFragmentList.add(new ChatMessagesFragment());
        /**
         * 添加Viewpager滑动监听事件
         * */

        chatVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //Viewpager重写方法
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //翻页时事件
            }

            @Override
            public void onPageSelected(int position) {
                //该方法为当前选定页面事件
                switch (position){
                    case TALK_PAGE_ONE:{
                        EventBus.getDefault().post(new EventCenter<>(mCurrentPage, EventCode.CHAT_TALK_ONE_ACTIVE));
                        mCurrentPage = TALK_PAGE_ONE;
                        break;
                    }
                    case TALK_PAGE_TWO:{
                        EventBus.getDefault().post(new EventCenter<>(mCurrentPage, EventCode.CHAT_TALK_TWO_ACTIVE));
                        mCurrentPage = TALK_PAGE_TWO;
                        break;
                    }
                    case TALK_PAGE_THREE:{
                        EventBus.getDefault().post(new EventCenter<>(mCurrentPage, EventCode.CHAT_TALK_THREE_ACTIVE));
                        mCurrentPage = TALK_PAGE_THREE;
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
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager(), mFragmentList);
        chatVP.setAdapter(adapter);
    }

    private void initVPMenu(){
        chat_vp_one = getRootView().findViewById(R.id.chat_vp_one);
        chat_vp_one.setOnClickListener(this);
        chat_vp_two = getRootView().findViewById(R.id.chat_vp_two);
        chat_vp_two.setOnClickListener(this);
        chat_vp_three = getRootView().findViewById(R.id.chat_vp_three);
        chat_vp_three.setOnClickListener(this);
    }

    protected void sendEventCode(View view){
        switch (view.getId()){
            case R.id.chat_vp_one:{
                chatVP.setCurrentItem(TALK_PAGE_ONE);
                Log.d(TAG, "sendEventCode: 1");
                break;
            }
            case R.id.chat_vp_two:{
                chatVP.setCurrentItem(TALK_PAGE_TWO);
                Log.d(TAG, "sendEventCode: 2");
                break;
            }
            case R.id.chat_vp_three:{
                chatVP.setCurrentItem(TALK_PAGE_THREE);
                Log.d(TAG, "sendEventCode: 3");
                break;
            }
        }
    }
}
