package com.graduation.appletree.onlinejudge.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.activity.ProfileConnectUsActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileMessageActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileSubmisisonActivity;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

public class ProfileFragment extends BaseFragment implements View.OnClickListener{

    private final String TAG = this.getClass().getName();

    protected ImageView profile_message;
    protected RelativeLayout profile_submission;
    protected RelativeLayout profile_connectus;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.profile_message:{
                readyGo(ProfileMessageActivity.class);
                break;
            }
            case R.id.profile_submission:{
                readyGo(ProfileSubmisisonActivity.class);
                break;
            }
            case R.id.profile_connectus:{
                readyGo(ProfileConnectUsActivity.class);
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
    private void initView(){
        profile_message = getRootView().findViewById(R.id.profile_message);
        profile_message.setOnClickListener(this);
        profile_submission = getRootView().findViewById(R.id.profile_submission);
        profile_submission.setOnClickListener(this);
        profile_connectus = getRootView().findViewById(R.id.profile_connectus);
        profile_connectus.setOnClickListener(this);
    }
}
