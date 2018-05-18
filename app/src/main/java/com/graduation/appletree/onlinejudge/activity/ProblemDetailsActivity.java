package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.graduation.appletree.onlinejudge.utils.NetRequestUtil;
import com.zzhoujay.markdown.MarkDown;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.RichType;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscriber;

public class ProblemDetailsActivity extends BaseActivity{

    private final String TAG = this.getClass().getName();

    @BindView(R.id.problem_detail_title)
    protected TextView problem_detail_title;
    @BindView(R.id.problem_detail_description)
    protected TextView problem_detail_description;
    @BindView(R.id.problem_detail_example)
    protected TextView problem_detail_example;
    @BindView(R.id.problem_detail_solution)
    protected TextView problem_detail_solution;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.problem_details;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void initViewAndEvent() {
        initMarkdown();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected Context getContext() {
        return null;
    }

    /**
     * Instance Method
     * */


    private void initMarkdown(){
        final String test = getIntent().getStringExtra("test");
        Log.d(TAG, "onStart: "+test);
        RichText.from(test).type(RichType.markdown).into(problem_detail_solution);
    }
}
