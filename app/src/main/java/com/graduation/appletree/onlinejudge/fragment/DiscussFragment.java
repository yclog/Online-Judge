package com.graduation.appletree.onlinejudge.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVDiscussAdapter;
import com.graduation.appletree.onlinejudge.bean.RVDiscussData;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import java.util.ArrayList;
import java.util.List;

public class DiscussFragment extends BaseFragment{

    protected RecyclerView rv_discuss;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_discuss;
    }

    @Override
    protected void initViewAndEvent() {
        InitView();
        InitRecoView();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    /**
     * Instance Method
     * */
    private void InitView(){
        rv_discuss = getRootView().findViewById(R.id.rv_discuss);
    }

    private void InitRecoView(){
        RVDiscussAdapter mRVDiscussAdapter = new RVDiscussAdapter(getContext(),getDataList());
        rv_discuss.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_discuss.setAdapter(mRVDiscussAdapter);
    }

    private List<RVDiscussData> getDataList(){
        List<RVDiscussData> mDataList = new ArrayList<>();
        RVDiscussData test = new RVDiscussData();
        test.setHome_solution_avatar(R.drawable.avatar_nine);
        test.setHome_solution_nickname("金朝麟");
        test.setHome_solution_title("Solution to problem one");
        test.setHome_solution_biref("The brute force approach is simple. Loop through each element xx and find if there is another value that equals to target - xtarget−x.");
        mDataList.add(test);
        RVDiscussData test1 = new RVDiscussData();
        test1.setHome_solution_avatar(R.drawable.avatar_two);
        test1.setHome_solution_nickname("deerlog");
        test1.setHome_solution_title("use python to solve problem one");
        test1.setHome_solution_biref("python, how to analyze its time complexity");
        mDataList.add(test1);
        RVDiscussData test2 = new RVDiscussData();
        test2.setHome_solution_avatar(R.drawable.avatar_five);
        test2.setHome_solution_nickname("付健");
        test2.setHome_solution_title("如何高效分析时间复杂度");
        test2.setHome_solution_biref("关键概念\n" +
                "　　要分析算法的复杂度,通常需要分析循环的运行.\n" +
                "一,假如,某个循环体的复杂度是O(1),那么这个循环的时间复杂度就是O(n).\n" +
                "　　for(int i = 0; i < n; i++){\n" +
                "　　　　//一些列复杂度为O(1)的步骤....\n" +
                "　　}\n" +
                "通常,如果某个循环结构以线性方式运行n次,并且循环体的时间复杂度都是O(1),那么该循环的复杂度就是O(n).\n" +
                "即使,该循环跳过某些常数部分,只要跳过的部分是线性的,那么该循环体的时间复杂度仍就是O(n).");
        mDataList.add(test2);
        RVDiscussData test4 = new RVDiscussData();
        test4.setHome_solution_avatar(R.drawable.avatar_two);
        test4.setHome_solution_nickname("SpritCan");
        test4.setHome_solution_title("快速排序");
        test4.setHome_solution_biref("快速排序由C. A. R. Hoare在1962年提出。它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序");
        mDataList.add(test4);
        return mDataList;
    }
}
