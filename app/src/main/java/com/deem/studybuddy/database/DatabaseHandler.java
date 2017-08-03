package com.deem.studybuddy.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.deem.studybuddy.model.Subject;

import java.util.ArrayList;

/**
 * Created by wangdiam on 8/2/17.
 */
//TODO complete DatabaseHandler
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "StudyBuddy";

    private static final String TABLE_NAME = "cards";
    private static final String KEY_ID = "id";
    private static final String KEY_SUBJECT = "subject";
    private static final String KEY_FRONT = "front";
    private static final String KEY_BACK = "back";

    private static final String TABLE_SUBJECT = "subjects";
    private static final String KEY_ID_SUBJECT = "subjectid";
    private static final String KEY_SUBJECT_NAME = "subjectname";
    private static final String NUMBER_OF_CARDS_STUDIED = "cardsstudied";
    private static final String TOTAL_NUMBER_OF_CARDS = "totalcards";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_SUBJECT + " TEXT, " + KEY_FRONT + " TEXT, " + KEY_BACK + " TEXT);";
        String CREATE_SUBJECTS = "CREATE TABLE " + TABLE_SUBJECT + "(" + KEY_ID_SUBJECT + " INTEGER PRIMARY KEY , " + KEY_SUBJECT_NAME + " TEXT, " + NUMBER_OF_CARDS_STUDIED + " INTEGER, " + TOTAL_NUMBER_OF_CARDS + " INTEGER);";
        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_SUBJECTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void addCard(String subject, String front, String back) {
        SQLiteDatabase db = this.getWritableDatabase();
        String currentTotalCards = String.format("SELECT COUNT(*) FROM cards where subject = '%s'",subject);
        Cursor cursor = db.rawQuery(currentTotalCards,null);
        cursor.moveToFirst();
        int numberOfCards = cursor.getInt(0);
        String increaseTotalCards = String.format("UPDATE subjects SET totalcards = '%s' WHERE subjectname = '%s'", Integer.toString(numberOfCards+1),subject);
        db.execSQL(increaseTotalCards);

        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_FRONT,front);
        contentValues.put(KEY_SUBJECT,subject);
        contentValues.put(KEY_BACK,back);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public ArrayList<Subject> retrieveSubjectsForAdapter() {
        ArrayList<Subject> subjects = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String retrieveQuery = String.format("SELECT * FROM subjects");
        Cursor cursor = db.rawQuery(retrieveQuery,null);
        if (cursor.moveToFirst()) {
            do {
                Subject subject = new Subject(cursor.getString(1),Integer.toString(cursor.getInt(2)),Integer.toString(cursor.getInt(3)));
                subjects.add(subject);
            } while (cursor.moveToNext());
        }
        db.close();
        return subjects;
    }

    public ArrayList<String> retrieveSubjects() {
        ArrayList<String> subjects = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = String.format("SELECT * FROM " + "%s",TABLE_SUBJECT);
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()) {
            do {
                Subject subject = new Subject(cursor.getString(1),NUMBER_OF_CARDS_STUDIED,TOTAL_NUMBER_OF_CARDS);
                subjects.add(subject.getSubjectTitle());
            } while (cursor.moveToNext());
        }
        db.close();
        return subjects;
    }

        public boolean addDeck(String deckname) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = String.format("SELECT * FROM " + TABLE_SUBJECT + " WHERE subjectname = " + "'%s'",deckname);
        String addQueryIfNothing = String.format("INSERT INTO subjects('subjectname','cardsstudied','totalcards') VALUES ('%s','%d','%d');",deckname,0,0);
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()) {
            return false;
        } else {
            db.execSQL(addQueryIfNothing);
        }
        db.close();
        return true;
    }
}
