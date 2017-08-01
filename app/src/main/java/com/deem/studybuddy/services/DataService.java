package com.deem.studybuddy.services;

import android.widget.TextView;

import com.deem.studybuddy.model.Subject;
import com.deem.studybuddy.model.Question;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;


public class DataService {
    private static DataService ourInstance = new DataService();
    private ArrayList<Question> questionArrayList;
    private ArrayList<Subject> subjectArrayList;
    private String ques;

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService()  {

    }

    public ArrayList<Subject> getSubjects() {

        ArrayList<Subject> list = new ArrayList<>();

        list.add(new Subject("Chemistry","2","20"));
        list.add(new Subject("Math","3","10"));
        list.add(new Subject("GP","1","1"));

        return list;
    }

    public ArrayList<Question> getQuestions() {
        questionArrayList = new ArrayList<>();
        Subject chemistry = new Subject("Chemistry","10","20");
        Subject math = new Subject("Math","10","20");
        /*questionArrayList.add(new Question("What is the Le Chatelier's Principle?","Chemistry"));
        questionArrayList.add(new Question("What is 1 + 1?", "Math"));*/

        return questionArrayList;
    }

    public String getQuestion(String subject) {

        Random randomGenerator = new Random();
        if (questionArrayList.size() < 1) {

        } else {
            int index = randomGenerator.nextInt(questionArrayList.size());
            Question q = questionArrayList.get(index);
            /*while (true) {
                if (q.getStringSubject() == subject) {*/
            questionArrayList.remove(index);
            ques = q.getQuestion();
        }
        if (ques == null) {
            return "";
        } else {
            return ques;
        }
            /*} else {
                index = randomGenerator.nextInt(questionArrayList.size());
            }
        }*/
    }

}
