package com.graduation.appletree.onlinejudge.bean;

public class RVProfileMessageData {

    private int profile_message_avatar;
    private String profile_message_name;
    private String profile_message_time;

    public RVProfileMessageData(int profile_message_avatar, String profile_message_name, String profile_message_time) {
        this.profile_message_avatar = profile_message_avatar;
        this.profile_message_name = profile_message_name;
        this.profile_message_time = profile_message_time;
    }

    public int getProfile_message_avatar() {
        return profile_message_avatar;
    }

    public void setProfile_message_avatar(int profile_message_avatar) {
        this.profile_message_avatar = profile_message_avatar;
    }

    public String getProfile_message_name() {
        return profile_message_name;
    }

    public void setProfile_message_name(String profile_message_name) {
        this.profile_message_name = profile_message_name;
    }

    public String getProfile_message_time() {
        return profile_message_time;
    }

    public void setProfile_message_time(String profile_message_time) {
        this.profile_message_time = profile_message_time;
    }
}
