package com.deem.studybuddy.model;

/**
 * Created by wangdiam on 7/31/17.
 */

public class Question {
    private String question;
    private String subject;

    public Question(String question, String subject) {
        this.question = question;
        this.subject = subject;
    }

    public String getStringSubject() {
        return subject;
    }

    public String getQuestion() {
        return question;
    }
}
