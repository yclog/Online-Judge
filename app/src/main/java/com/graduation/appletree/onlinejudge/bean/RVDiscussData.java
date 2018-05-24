package com.graduation.appletree.onlinejudge.bean;

public class RVDiscussData {

    private int discuss_avatar;
    private String discuss_nickname;
    private String discuss_title;
    private String discuss_biref;

    public RVDiscussData() {}

    public RVDiscussData(int discuss_avatar, String discuss_nickname, String discuss_title, String discuss_biref) {
        this.discuss_avatar = discuss_avatar;
        this.discuss_nickname = discuss_nickname;
        this.discuss_title = discuss_title;
        this.discuss_biref = discuss_biref;
    }

    public int getHome_solution_avatar() {
        return discuss_avatar;
    }

    public void setHome_solution_avatar(int home_solution_avatar) {
        this.discuss_avatar = home_solution_avatar;
    }

    public String getHome_solution_nickname() {
        return discuss_nickname;
    }

    public void setHome_solution_nickname(String home_solution_nickname) {
        this.discuss_nickname = home_solution_nickname;
    }

    public String getHome_solution_title() {
        return discuss_title;
    }

    public void setHome_solution_title(String home_solution_title) {
        this.discuss_title = home_solution_title;
    }

    public String getHome_solution_biref() {
        return discuss_biref;
    }

    public void setHome_solution_biref(String home_solution_biref) {
        this.discuss_biref = home_solution_biref;
    }
}
