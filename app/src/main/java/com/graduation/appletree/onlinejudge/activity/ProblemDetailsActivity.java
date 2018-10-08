package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.RichType;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Problem Details
 *
 * @author lucas
 * @date 2018/3/21
 */
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

    @BindView(R.id.problem_detail_code)
    protected TextView problem_detail_code;
    @BindView(R.id.problem_code_test)
    protected Button problem_code_test;
    @BindView(R.id.problem_code_submit)
    protected Button problem_code_submit;

    int tag ;
    String keyContent = "cout<<nums1+nums2;";

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

    @OnClick({R.id.problem_code_test,R.id.problem_code_submit})
    public void RunCode(){
        String code = problem_detail_code.getText().toString();
        if (code.isEmpty()){
            Toast.makeText(getApplicationContext(),"Error , Code is Empty",Toast.LENGTH_SHORT).show();
            return;
        }
        String head_one = "#include <iostream>";
        String head_two = "using namespace std";
        if (!code.contains(head_one)){
            Toast.makeText(getApplicationContext(),"Missing #include <iostream>",Toast.LENGTH_SHORT).show();
        }
        if (!code.contains(head_two)){
            Toast.makeText(getApplicationContext(),"using namespace std",Toast.LENGTH_SHORT).show();
        }
        if (isValid(code)){
            Toast.makeText(getApplicationContext(),"Missing { or }",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
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
        tag = bundle.getInt("id");
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

    ArrayList<Character> arrayList=new ArrayList<>();

    public boolean isValid(String s) {
        if (isRight(s.charAt(0)))
            return false;
        if (s.length()%2==1)
            return false;
        for (int i = 0; i < s.length(); i++) {
            arrayList.add(s.charAt(i));
            if (isRight(s.charAt(i))){
                if (isMatch(arrayList.get(arrayList.size()-2),arrayList.get(arrayList.size()-1)))
                    popTwo();
            }
        }
        if (arrayList.size()==0)
            return true;
        else
            return false;
    }

    public void push(char symbol){
        arrayList.add(symbol);
    }

    public void popTwo(){
        arrayList.remove(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
    }

    public boolean isMatch(char Left,char Right){
        if (Left=='{' && Right=='}')
            return true;
        if (Left=='(' && Right==')')
            return true;
        if (Left=='[' && Right==']')
            return true;
        return false;
    }

    public boolean isRight(char symbol){
        if (symbol=='}'||symbol==']'||symbol==')')
            return true;
        return false;
    }


}
