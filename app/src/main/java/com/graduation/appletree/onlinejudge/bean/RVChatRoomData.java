package com.graduation.appletree.onlinejudge.bean;

public class RVChatRoomData {

    /**
     * side == 0 : Accept
     * side == 1 : Send
     * */
    private int side;
    private String text;

    public RVChatRoomData(int side, String text) {
        this.side = side;
        this.text = text;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
