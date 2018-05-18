package com.graduation.appletree.onlinejudge.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.activity.ProfileMessageActivity;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

public class ProfileFragment extends BaseFragment implements View.OnClickListener{

    private final String TAG = this.getClass().getName();

    protected ImageView profile_message;

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
            default:{
                Log.d(TAG, "Invalid Click");
            }
        }
    }

    /**
     * Instance Method
     * */
    private void initView(){
        profile_message = getRootView().findViewById(R.id.profile_message);
        profile_message.setOnClickListener(this);
    }
}
