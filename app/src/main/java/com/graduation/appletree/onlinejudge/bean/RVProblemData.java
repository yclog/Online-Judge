package com.graduation.appletree.onlinejudge.bean;

public class RVProblemData {

    private int problem_id;
    private int problem_status;
    private int problem_num;
    private String problem_title;
    private String problem_rate;
    private int problem_difficulty;

    public RVProblemData(int problem_id, int problem_status, int problem_num, String problem_title, String problem_rate, int problem_difficulty) {
        this.problem_id = problem_id;
        this.problem_status = problem_status;
        this.problem_num = problem_num;
        this.problem_title = problem_title;
        this.problem_rate = problem_rate;
        this.problem_difficulty = problem_difficulty;
    }

    /**
     * Common : 0
     * Accept : 1
     * Attempted : 2
     * */
    public int getProblem_status() {
        return problem_status;
    }

    public void setProblem_status(int problem_status) {
        this.problem_status = problem_status;
    }

    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    public int getProblem_num() {
        return problem_num;
    }

    public void setProblem_num(int problem_num) {
        this.problem_num = problem_num;
    }

    public String getProblem_title() {
        return problem_title;
    }

    public void setProblem_title(String problem_title) {
        this.problem_title = problem_title;
    }

    public String getProblem_rate() {
        return problem_rate;
    }

    public void setProblem_rate(String problem_rate) {
        this.problem_rate = problem_rate;
    }

    /**
     * Easy : 0
     * Medium : 1
     * Hard : 2
     * */
    public int getProblem_diffculty() {
        return problem_difficulty;
    }

    public void setProblem_diffculty(int problem_diffculty) {
        this.problem_difficulty = problem_diffculty;
    }
}
