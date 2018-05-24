package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.RichType;

import butterknife.BindView;

public class ProblemDetailsActivity extends BaseActivity{

    private final String TAG = this.getClass().getName();

    @BindView(R.id.problem_detail_title)
    protected TextView problem_detail_title;
    @BindView(R.id.problem_detail_description)
    protected TextView problem_detail_description;
    @BindView(R.id.problem_detail_example)
    protected TextView problem_detail_example;
    @BindView(R.id.problem_detail_solution_title)
    protected RelativeLayout problem_detail_solution_title;
    @BindView(R.id.problem_detail_solution)
    protected RelativeLayout problem_detail_solution;
    @BindView(R.id.problem_detail_solution_mk)
    protected TextView problem_detail_solution_mk;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_problem_details;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void initViewAndEvent() {
        loadContent();
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
        if (getIntent().getBooleanExtra("isSolution",true)){
            problem_detail_solution_title.setVisibility(View.GONE);
            problem_detail_solution.setVisibility(View.GONE);
            return;
        }
        problem_detail_solution_title.setVisibility(View.VISIBLE);
        problem_detail_solution.setVisibility(View.VISIBLE);
        final String test = "class Solution {\n" +
                "    public int[] twoSum(int[] nums, int target) {\n" +
                "        int complement=0;\n" +
                "        HashMap<Integer,Integer> map=new HashMap<>();\n" +
                "        for(int i=0;i<nums.length;i++){\n" +
                "            map.put(nums[i],i);\n" +
                "        }\n" +
                "        for (int i = 0; i < nums.length; i++) {\n" +
                "            complement = target - nums[i];\n" +
                "            if (map.containsKey(complement) && map.get(complement) != i) {\n" +
                "                return new int[] { i, map.get(complement) };\n" +
                "            }\n" +
                "        }\n" +
                "        throw new IllegalArgumentException(\"No two sum solution\");\n" +
                "    }\n" +
                "}";
        Log.d(TAG, "onStart: "+test);
        RichText.from(test).type(RichType.markdown).into(problem_detail_solution_mk);
    }

    private void loadContent(){
        Bundle bundle = getIntent().getExtras();
        switch (bundle.getInt("id")){
            case -1:{
                problem_detail_title.setText(R.string.problem_title_sample_zero);
                problem_detail_description.setText(R.string.problem_content_sample_zero);
                problem_detail_example.setText(R.string.problem_example_sample_zero);
                break;
            }
            case 0:{
                problem_detail_title.setText(R.string.problem_title_sample_one);
                problem_detail_description.setText(R.string.problem_content_sample_one);
                problem_detail_example.setText(R.string.problem_example_sample_one);
                break;
            }
            case 1:{
                problem_detail_title.setText(R.string.problem_title_sample_two);
                problem_detail_description.setText(R.string.problem_content_sample_two);
                problem_detail_example.setText(R.string.problem_example_sample_two);
                break;
            }
            case 2:{
                problem_detail_title.setText(R.string.problem_title_sample_three);
                problem_detail_description.setText(R.string.problem_content_sample_three);
                problem_detail_example.setText(R.string.problem_example_sample_three);
                break;
            }
            case 3:{
                problem_detail_title.setText(R.string.problem_title_sample_four);
                problem_detail_description.setText(R.string.problem_content_sample_four);
                problem_detail_example.setText(R.string.problem_example_sample_four);
                break;
            }
        }
    }
}
