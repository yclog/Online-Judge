package com.graduation.appletree.onlinejudge.bean;

public class RVProfilePointData {

    private String rv_profile_point_date;
    private String rv_profile_point_add;
    private String rv_profile_point_title;
    private String rv_profile_point_content;

    public RVProfilePointData(String rv_profile_point_date, String rv_profile_point_add, String rv_profile_point_title, String rv_profile_point_content) {
        this.rv_profile_point_date = rv_profile_point_date;
        this.rv_profile_point_add = rv_profile_point_add;
        this.rv_profile_point_title = rv_profile_point_title;
        this.rv_profile_point_content = rv_profile_point_content;
    }

    public String getRv_profile_point_date() {
        return rv_profile_point_date;
    }

    public void setRv_profile_point_date(String rv_profile_point_date) {
        this.rv_profile_point_date = rv_profile_point_date;
    }

    public String getRv_profile_point_add() {
        return rv_profile_point_add;
    }

    public void setRv_profile_point_add(String rv_profile_point_add) {
        this.rv_profile_point_add = rv_profile_point_add;
    }

    public String getRv_profile_point_title() {
        return rv_profile_point_title;
    }

    public void setRv_profile_point_title(String rv_profile_point_title) {
        this.rv_profile_point_title = rv_profile_point_title;
    }

    public String getRv_profile_point_content() {
        return rv_profile_point_content;
    }

    public void setRv_profile_point_content(String rv_profile_point_content) {
        this.rv_profile_point_content = rv_profile_point_content;
    }
}
