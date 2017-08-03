package com.deem.studybuddy.services;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

import com.deem.studybuddy.activities.MainActivity;
import com.deem.studybuddy.database.DatabaseHandler;
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

    public DataService() {
    }

    public static DataService getInstance() {
        return ourInstance;
    }


    public ArrayList<Subject> getSubjects() {
        final MainActivity mainActivity = MainActivity.getMainActivity();
        DatabaseHandler db = new DatabaseHandler(mainActivity.getApplicationContext());
        ArrayList<Subject> list = db.retrieveSubjectsForAdapter();
        db.close();
        return list;
    }

    public ArrayList<Question> getQuestions(String subjectName) {
        final MainActivity mainActivity = MainActivity.getMainActivity();
        DatabaseHandler dbh = new DatabaseHandler(mainActivity);
        SQLiteDatabase db = dbh.getWritableDatabase();
        String retrieveQuery = String.format("SELECT * FROM CARDS WHERE subject = '%s'",subjectName);
        Cursor cursor = db.rawQuery(retrieveQuery,null);
        ArrayList<Question> questions = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question(cursor.getString(2),cursor.getString(3));
                questions.add(question);
            } while (cursor.moveToNext());
        }
        db.close();
        return questions;
    }

    public Question getRandomQuestion(ArrayList<Question> questions) {

        Random randomGenerator = new Random();
        Question question = new Question("","");
        if (questions == null) {
            return question;
        } else if (questions.size() < 1) {
            return question;
        } else {
            int index = randomGenerator.nextInt(questions.size());
            question = questions.get(index);
            questions.remove(index);
            ques = question.getQuestion();
        }
        if (ques == null) {
            return question;
        } else {
            return question;
        }
    }

}
