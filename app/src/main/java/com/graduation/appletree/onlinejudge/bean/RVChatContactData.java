package com.graduation.appletree.onlinejudge.bean;

public class RVChatContactData {

    private int contact_avatar;
    private String contact_name;

    public RVChatContactData(int contact_avatar, String contact_name) {
        this.contact_avatar = contact_avatar;
        this.contact_name = contact_name;
    }

    public int getContact_avatar() {
        return contact_avatar;
    }

    public void setContact_avatar(int contact_avatar) {
        this.contact_avatar = contact_avatar;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }
}
