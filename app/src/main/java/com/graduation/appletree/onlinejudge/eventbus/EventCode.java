package com.graduation.appletree.onlinejudge.eventbus;

/**
 * EventBus消息总线管道
 *
 * @author lucas
 * @date 2018/3/21
 */
public interface EventCode {

    /**
     * EventBus TestCode
     * */
    int TEST_CODE = 0;

    /**
     * Bottom Menu EventCode
     * */
    int BOTTOM_MENU_ONE_ACTIVE = 0;
    int BOTTOM_MENU_TWO_ACTIVE = 1;
    int BOTTOM_MENU_THREE_ACTIVE = 2;
    int BOTTOM_MENU_FOUR_ACTIVE = 3;

    /**
     * Chat Talk EventCode
     * */
    int CHAT_TALK_ONE_ACTIVE = 4;
    int CHAT_TALK_TWO_ACTIVE = 5;
    int CHAT_TALK_THREE_ACTIVE = 6;
}
