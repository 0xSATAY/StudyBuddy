package com.deem.studybuddy.services;

import com.deem.studybuddy.model.Subjects;

import java.util.ArrayList;

/**
 * Created by wangdiam on 7/31/17.
 */

public class DataService {
    private static DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService()  {

    }

    public ArrayList<Subjects> getSubjects() {

        ArrayList<Subjects> list = new ArrayList<>();

        list.add(new Subjects("Chemistry","2","20"));
        list.add(new Subjects("Math","3","10"));
        list.add(new Subjects("GP","1","1"));

        return list;
    }

}
