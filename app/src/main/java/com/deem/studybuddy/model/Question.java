package com.deem.studybuddy.model;

/**
 * Created by wangdiam on 7/31/17.
 */

public class Question {
    private String question;
    private String answer;

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
