package com.graduation.appletree.onlinejudge.eventbus;

/**
 * EventBus消息总线管道传输对象
 *
 * @author lucas
 * @date 2018/3/21
 */
public class EventCenter<T> {

    private T data;
    private int EventCode = -1;

    public EventCenter(T data, int eventCode) {
        this.data = data;
        this.EventCode = eventCode;
    }

    public EventCenter(int eventCode) {
        this.data = null;
        this.EventCode = eventCode;
    }

    public T getData() {
        return this.data;
    }

    public int getEventCode() {
        return this.EventCode;
    }
}
