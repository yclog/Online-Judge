package com.graduation.appletree.onlinejudge.bean;

public class RVProfileSessionData {

    private int rv_profile_session_num;
    private String rv_profile_session_mission;
    private String rv_profile_session_publisher;
    private String rv_profile_session_starttime;
    private String rv_profile_session_endtime;

    public RVProfileSessionData(int rv_profile_session_num, String rv_profile_session_mission,
                                String rv_profile_session_publisher,
                                String rv_profile_session_starttime,
                                String rv_profile_session_endtime) {
        this.rv_profile_session_num = rv_profile_session_num;
        this.rv_profile_session_mission = rv_profile_session_mission;
        this.rv_profile_session_publisher = rv_profile_session_publisher;
        this.rv_profile_session_starttime = rv_profile_session_starttime;
        this.rv_profile_session_endtime = rv_profile_session_endtime;
    }

    public int getRv_profile_session_num() {
        return rv_profile_session_num;
    }

    public void setRv_profile_session_num(int rv_profile_session_num) {
        this.rv_profile_session_num = rv_profile_session_num;
    }

    public String getRv_profile_session_mission() {
        return rv_profile_session_mission;
    }

    public void setRv_profile_session_mission(String rv_profile_session_mission) {
        this.rv_profile_session_mission = rv_profile_session_mission;
    }

    public String getRv_profile_session_publisher() {
        return rv_profile_session_publisher;
    }

    public void setRv_profile_session_publisher(String rv_profile_session_publisher) {
        this.rv_profile_session_publisher = rv_profile_session_publisher;
    }

    public String getRv_profile_session_starttime() {
        return rv_profile_session_starttime;
    }

    public void setRv_profile_session_starttime(String rv_profile_session_starttime) {
        this.rv_profile_session_starttime = rv_profile_session_starttime;
    }

    public String getRv_profile_session_endtime() {
        return rv_profile_session_endtime;
    }

    public void setRv_profile_session_endtime(String rv_profile_session_endtime) {
        this.rv_profile_session_endtime = rv_profile_session_endtime;
    }
}
