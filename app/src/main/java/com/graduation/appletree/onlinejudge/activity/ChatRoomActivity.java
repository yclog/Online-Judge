package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import butterknife.BindView;

public class ChatRoomActivity extends BaseActivity{
    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.chat_room_name)
    protected TextView chat_room_name;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_chat_room;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
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

    private void initView(){
        titlebar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatRoomActivity.this.finish();
            }
        });
        chat_room_name.setText(getIntent().getExtras().getString("name"));
    }
}
