package com.graduation.appletree.onlinejudge.bean;

public class RVChatTalkData {

    private int chat_talk_id;
    private int chat_talk_avatar;
    private int chat_talk_status;
    private String chat_talk_name;
    private String chat_talk_brief;
    private String chat_talk_date;

    /**
     * Online : 0
     * Busy : 1
     * OffLine : 2
     * */
    public RVChatTalkData(int chat_talk_id, int chat_talk_avatar, int chat_talk_status, String chat_talk_name, String chat_talk_brief, String chat_talk_date) {
        this.chat_talk_id = chat_talk_id;
        this.chat_talk_avatar = chat_talk_avatar;
        this.chat_talk_status = chat_talk_status;
        this.chat_talk_name = chat_talk_name;
        this.chat_talk_brief = chat_talk_brief;
        this.chat_talk_date = chat_talk_date;
    }

    public int getChat_talk_id() {
        return chat_talk_id;
    }

    public void setChat_talk_id(int chat_talk_id) {
        this.chat_talk_id = chat_talk_id;
    }

    public int getChat_talk_avatar() {
        return chat_talk_avatar;
    }

    public void setChat_talk_avatar(int chat_talk_avatar) {
        this.chat_talk_avatar = chat_talk_avatar;
    }

    public int getChat_talk_status() {
        return chat_talk_status;
    }

    public void setChat_talk_status(int chat_talk_status) {
        this.chat_talk_status = chat_talk_status;
    }

    public String getChat_talk_name() {
        return chat_talk_name;
    }

    public void setChat_talk_name(String chat_talk_name) {
        this.chat_talk_name = chat_talk_name;
    }

    public String getChat_talk_brief() {
        return chat_talk_brief;
    }

    public void setChat_talk_brief(String chat_talk_brief) {
        this.chat_talk_brief = chat_talk_brief;
    }

    public String getChat_talk_date() {
        return chat_talk_date;
    }

    public void setChat_talk_date(String chat_talk_date) {
        this.chat_talk_date = chat_talk_date;
    }
}
