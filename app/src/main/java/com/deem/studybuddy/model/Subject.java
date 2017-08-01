package com.deem.studybuddy.model;

/**
 * Created by wangdiam on 7/31/17.
 */

public class Subject {
    private String subjectTitle;
    private String numberOfCardsStudied;
    private String totalNumberOfCards;

    public Subject(String subjectTitle, String numberOfCardsStudied, String totalNumberOfCards) {
        this.subjectTitle = subjectTitle;
        this.numberOfCardsStudied = numberOfCardsStudied;
        this.totalNumberOfCards = totalNumberOfCards;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public String getNumberOfCardsStudied() {
        return numberOfCardsStudied;
    }

    public String getTotalNumberOfCards() {
        return totalNumberOfCards;
    }

}
