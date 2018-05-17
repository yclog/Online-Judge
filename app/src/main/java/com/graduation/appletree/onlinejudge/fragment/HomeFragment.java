package com.graduation.appletree.onlinejudge.fragment;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment{

    @BindView(R.id.home_ad_vp)
    public ConvenientBanner home_ad_vp;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewAndEvent() {
        initAdViewPager();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    /**
     * Instance Method
     * */
    private void initAdViewPager(){}
}
