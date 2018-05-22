package com.graduation.appletree.onlinejudge.bean;

public class RVChatMessageData {

    private int chat_message_avatar;
    private String chat_message_name;
    private String chat_message_time;

    public RVChatMessageData(int chat_message_avatar, String chat_message_name, String chat_message_time) {
        this.chat_message_avatar = chat_message_avatar;
        this.chat_message_name = chat_message_name;
        this.chat_message_time = chat_message_time;
    }

    public int getChat_message_avatar() {
        return chat_message_avatar;
    }

    public void setChat_message_avatar(int chat_message_avatar) {
        this.chat_message_avatar = chat_message_avatar;
    }

    public String getChat_message_name() {
        return chat_message_name;
    }

    public void setChat_message_name(String chat_message_name) {
        this.chat_message_name = chat_message_name;
    }

    public String getChat_message_time() {
        return chat_message_time;
    }

    public void setChat_message_time(String chat_message_time) {
        this.chat_message_time = chat_message_time;
    }
}
