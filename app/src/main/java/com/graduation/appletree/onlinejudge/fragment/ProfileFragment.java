package com.graduation.appletree.onlinejudge.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.activity.ProfileAboutUsActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileConnectUsActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileMessageActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileMyListActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileNoteBookActivity;
import com.graduation.appletree.onlinejudge.activity.ProfilePointActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileProgressActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileSessionActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileSettingActivity;
import com.graduation.appletree.onlinejudge.activity.ProfileSubmisisonActivity;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

public class ProfileFragment extends BaseFragment implements View.OnClickListener{

    private final String TAG = this.getClass().getName();

    /**
     * Profile 视图View
     * */
    protected ImageView profile_message;
    protected RelativeLayout profile_aboutus;
    protected RelativeLayout profile_connectus;
    protected RelativeLayout profile_mylist;
    protected RelativeLayout profile_notebook;
    protected RelativeLayout profile_point;
    protected RelativeLayout profile_progress;
    protected RelativeLayout profile_session;
    protected RelativeLayout profile_setting;
    protected RelativeLayout profile_submission;

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
            case R.id.profile_aboutus:{
                readyGo(ProfileAboutUsActivity.class);
                break;
            }
            case R.id.profile_connectus:{
                readyGo(ProfileConnectUsActivity.class);
                break;
            }
            case R.id.profile_mylist:{
                readyGo(ProfileMyListActivity.class);
                break;
            }
            case R.id.profile_notebook:{
                readyGo(ProfileNoteBookActivity.class);
                break;
            }
            case R.id.profile_point:{
                readyGo(ProfilePointActivity.class);
                break;
            }
            case R.id.profile_progress:{
                readyGo(ProfileProgressActivity.class);
                break;
            }
            case R.id.profile_session:{
                readyGo(ProfileSessionActivity.class);
                break;
            }
            case R.id.profile_setting:{
                readyGo(ProfileSettingActivity.class);
                break;
            }
            case R.id.profile_submission:{
                readyGo(ProfileSubmisisonActivity.class);
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
        profile_aboutus = getRootView().findViewById(R.id.profile_aboutus);
        profile_aboutus.setOnClickListener(this);
        profile_connectus = getRootView().findViewById(R.id.profile_connectus);
        profile_connectus.setOnClickListener(this);
        profile_mylist = getRootView().findViewById(R.id.profile_mylist);
        profile_mylist.setOnClickListener(this);
        profile_notebook = getRootView().findViewById(R.id.profile_notebook);
        profile_notebook.setOnClickListener(this);
        profile_point = getRootView().findViewById(R.id.profile_point);
        profile_point.setOnClickListener(this);
        profile_progress = getRootView().findViewById(R.id.profile_progress);
        profile_progress.setOnClickListener(this);
        profile_session = getRootView().findViewById(R.id.profile_session);
        profile_session.setOnClickListener(this);
        profile_setting = getRootView().findViewById(R.id.profile_setting);
        profile_setting.setOnClickListener(this);
        profile_submission = getRootView().findViewById(R.id.profile_submission);
        profile_submission.setOnClickListener(this);
    }
}
