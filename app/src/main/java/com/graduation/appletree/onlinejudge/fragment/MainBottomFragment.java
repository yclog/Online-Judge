package com.graduation.appletree.onlinejudge.fragment;

import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.eventbus.EventCode;

import butterknife.BindInt;
import butterknife.BindView;

/**
 * MainBottom Menu
 *
 * @author lucas
 * @date 2018/3/21
 */
public class MainBottomFragment extends BaseFragment{

    private final String TAG = this.getClass().getName();

    private static final int BOTTOM_PAGE_ONE = 0;
    private static final int BOTTOM_PAGE_TWO = 1;
    private static final int BOTTOM_PAGE_THREE = 2;
    private static final int BOTTOM_PAGE_FOUR = 3;

    protected TextView bottom_menu_one_text;
    protected TextView bottom_menu_two_text;
    protected TextView bottom_menu_three_text;
    protected TextView bottom_menu_four_text;

    protected ImageView bottom_menu_one_icon;
    protected ImageView bottom_menu_two_icon;
    protected ImageView bottom_menu_three_icon;
    protected ImageView bottom_menu_four_icon;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_bottom_menu;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {
        switch (eventCenter.getEventCode()){
            case EventCode.BOTTOM_MENU_ONE_ACTIVE:{
                resetView(eventCenter);
                bottom_menu_one_icon.setImageResource(R.mipmap.bottom_home_active);
                bottom_menu_one_text.setTextColor(getResources().getColor(R.color.bottom_text_active));
                break;
            }
            case EventCode.BOTTOM_MENU_TWO_ACTIVE:{
                resetView(eventCenter);
                bottom_menu_two_icon.setImageResource(R.mipmap.bottom_discuss_active);
                bottom_menu_two_text.setTextColor(getResources().getColor(R.color.bottom_text_active));
                break;
            }
            case EventCode.BOTTOM_MENU_THREE_ACTIVE:{
                resetView(eventCenter);
                bottom_menu_three_icon.setImageResource(R.mipmap.bottom_chat_active);
                bottom_menu_three_text.setTextColor(getResources().getColor(R.color.bottom_text_active));
                break;
            }
            case EventCode.BOTTOM_MENU_FOUR_ACTIVE:{
                resetView(eventCenter);
                bottom_menu_four_icon.setImageResource(R.mipmap.bottom_profile_active);
                bottom_menu_four_text.setTextColor(getResources().getColor(R.color.bottom_text_active));
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
        bottom_menu_one_text = getRootView().findViewById(R.id.bottom_menu_one_text);
        bottom_menu_two_text = getRootView().findViewById(R.id.bottom_menu_two_text);
        bottom_menu_three_text = getRootView().findViewById(R.id.bottom_menu_three_text);
        bottom_menu_four_text = getRootView().findViewById(R.id.bottom_menu_four_text);

        bottom_menu_one_icon = getRootView().findViewById(R.id.bottom_menu_one_icon);
        bottom_menu_two_icon = getRootView().findViewById(R.id.bottom_menu_two_icon);
        bottom_menu_three_icon = getRootView().findViewById(R.id.bottom_menu_three_icon);
        bottom_menu_four_icon = getRootView().findViewById(R.id.bottom_menu_four_icon);
    }

    private void resetView(EventCenter eventCenter){
        switch ((int)eventCenter.getData()){
            case BOTTOM_PAGE_ONE:{
                if (eventCenter.getEventCode() != EventCode.BOTTOM_MENU_ONE_ACTIVE){
                    bottom_menu_one_icon.setImageResource(R.mipmap.bottom_home);
                    bottom_menu_one_text.setTextColor(getResources().getColor(R.color.bottom_text));
                }
                break;
            }
            case BOTTOM_PAGE_TWO:{
                if (eventCenter.getEventCode() != EventCode.BOTTOM_MENU_TWO_ACTIVE){
                    bottom_menu_two_icon.setImageResource(R.mipmap.bottom_discuss);
                    bottom_menu_two_text.setTextColor(getResources().getColor(R.color.bottom_text));
                }
                break;
            }
            case BOTTOM_PAGE_THREE:{
                if (eventCenter.getEventCode() != EventCode.BOTTOM_MENU_THREE_ACTIVE){
                    bottom_menu_three_icon.setImageResource(R.mipmap.bottom_chat);
                    bottom_menu_three_text.setTextColor(getResources().getColor(R.color.bottom_text));
                }
                break;
            }
            case BOTTOM_PAGE_FOUR:{
                if (eventCenter.getEventCode() != EventCode.BOTTOM_MENU_FOUR_ACTIVE){
                    bottom_menu_four_icon.setImageResource(R.mipmap.bottom_profile);
                    bottom_menu_four_text.setTextColor(getResources().getColor(R.color.bottom_text));
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
