package com.graduation.appletree.onlinejudge.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.eventbus.EventCode;

public class ChatTalkMenuFragment extends BaseFragment{

    private final String TAG = this.getClass().getName();

    private static final int TALK_PAGE_ONE = 0;
    private static final int TALK_PAGE_TWO = 1;
    private static final int TALK_PAGE_THREE = 2;

    protected View chat_menu_one_line;
    protected View chat_menu_two_line;
    protected View chat_menu_three_line;

    protected ImageView chat_menu_one_icon;
    protected ImageView chat_menu_two_icon;
    protected ImageView chat_menu_three_icon;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chat_vp_menu;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {
        switch (eventCenter.getEventCode()){
            case EventCode.CHAT_TALK_ONE_ACTIVE:{
                resetView(eventCenter);
                chat_menu_one_icon.setImageResource(R.mipmap.chat_vp_one_active);
                chat_menu_one_line.setBackgroundColor(getResources().getColor(R.color.chat_vp_active));
                break;
            }
            case EventCode.CHAT_TALK_TWO_ACTIVE:{
                resetView(eventCenter);
                chat_menu_two_icon.setImageResource(R.mipmap.chat_vp_two_active);
                chat_menu_two_line.setBackgroundColor(getResources().getColor(R.color.chat_vp_active));
                break;
            }
            case EventCode.CHAT_TALK_THREE_ACTIVE:{
                resetView(eventCenter);
                chat_menu_three_icon.setImageResource(R.mipmap.chat_vp_three_active);
                chat_menu_three_line.setBackgroundColor(getResources().getColor(R.color.chat_vp_active));
                break;
            }
            default:{
                Log.w(TAG, "Invalid EventCode");
                break;
            }
        }
    }

    /**
     * Instance Method
     * */
    private void initView(){
        chat_menu_one_line = getRootView().findViewById(R.id.chat_vp_one_line);
        chat_menu_two_line = getRootView().findViewById(R.id.chat_vp_two_line);
        chat_menu_three_line = getRootView().findViewById(R.id.chat_vp_three_line);

        chat_menu_one_icon = getRootView().findViewById(R.id.chat_vp_one_icon);
        chat_menu_two_icon = getRootView().findViewById(R.id.chat_vp_two_icon);
        chat_menu_three_icon = getRootView().findViewById(R.id.chat_vp_three_icon);
    }

    private void resetView(EventCenter eventCenter){
        switch ((int)eventCenter.getData()){
            case TALK_PAGE_ONE:{
                if (eventCenter.getEventCode() != EventCode.BOTTOM_MENU_ONE_ACTIVE){
                    chat_menu_one_icon.setImageResource(R.mipmap.chat_vp_one);
                    chat_menu_one_line.setBackgroundColor(getResources().getColor(R.color.chat_vp));
                }
                break;
            }
            case TALK_PAGE_TWO:{
                if (eventCenter.getEventCode() != EventCode.BOTTOM_MENU_TWO_ACTIVE){
                    chat_menu_two_icon.setImageResource(R.mipmap.chat_vp_two);
                    chat_menu_two_line.setBackgroundColor(getResources().getColor(R.color.chat_vp));
                }
                break;
            }
            case TALK_PAGE_THREE:{
                if (eventCenter.getEventCode() != EventCode.BOTTOM_MENU_THREE_ACTIVE){
                    chat_menu_three_icon.setImageResource(R.mipmap.chat_vp_three);
                    chat_menu_three_line.setBackgroundColor(getResources().getColor(R.color.chat_vp));
                }
                break;
            }
            default:{
                Log.d(TAG, "Invalid CurrentPage");
                break;
            }
        }
    }
}
