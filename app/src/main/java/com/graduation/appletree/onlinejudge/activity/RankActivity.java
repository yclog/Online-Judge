package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import butterknife.BindView;

/**
 * Rank
 *
 * @author lucas
 * @date 2018/3/21
 */
public class RankActivity extends BaseActivity{

    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_rank;
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
                RankActivity.this.finish();
            }
        });
    }
}
