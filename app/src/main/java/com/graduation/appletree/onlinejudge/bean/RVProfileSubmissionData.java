package com.graduation.appletree.onlinejudge.bean;

public class RVProfileSubmissionData {

    private String submission_question;
    private String submission_status;
    private String submission_runtime;
    private String submission_language;

    public RVProfileSubmissionData(String submission_question, String submission_status,
                                   String submission_runtime, String submission_language) {
        this.submission_question = submission_question;
        this.submission_status = submission_status;
        this.submission_runtime = submission_runtime;
        this.submission_language = submission_language;
    }

    public String getSubmission_question() {
        return submission_question;
    }

    public void setSubmission_question(String submission_question) {
        this.submission_question = submission_question;
    }

    public String getSubmission_status() {
        return submission_status;
    }

    public void setSubmission_status(String submission_status) {
        this.submission_status = submission_status;
    }

    public String getSubmission_runtime() {
        return submission_runtime;
    }

    public void setSubmission_runtime(String submission_runtime) {
        this.submission_runtime = submission_runtime;
    }

    public String getSubmission_language() {
        return submission_language;
    }

    public void setSubmission_language(String submission_language) {
        this.submission_language = submission_language;
    }
}
