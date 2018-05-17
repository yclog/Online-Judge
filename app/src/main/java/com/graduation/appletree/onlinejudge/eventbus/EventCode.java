package com.graduation.appletree.onlinejudge.eventbus;

/**
 * Created by luke on 2018/3/21.
 * Description: EventBus消息总线管道
 */

public interface EventCode {

    /**
     * EventBus TestCode
     * */
    int TEST_CODE = 0;

    /**
     * Bottom Menu EventCode
     * */
    final static int BOTTOM_MENU_ONE_ACTIVE = 0;
    final static int BOTTOM_MENU_TWO_ACTIVE = 1;
    final static int BOTTOM_MENU_THREE_ACTIVE = 2;
    final static int BOTTOM_MENU_FOUR_ACTIVE = 3;
}
