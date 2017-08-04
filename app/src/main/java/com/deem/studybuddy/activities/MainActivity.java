package com.deem.studybuddy.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.deem.studybuddy.fragments.addCards.AddCardsFragment;
import com.deem.studybuddy.fragments.addDeck.AddDeckFragment;
import com.deem.studybuddy.fragments.mainMenu.MenuFragment;
import com.deem.studybuddy.fragments.seeAllCards.SeeAllFragment;
import com.deem.studybuddy.fragments.startCards.StartFragment;
import com.deem.studybuddy.R;
import com.deem.studybuddy.fragments.startCards.SubjectFragment;
import com.deem.studybuddy.model.Question;
import com.deem.studybuddy.model.Subject;

import java.util.ArrayList;


public class MainActivity extends Activity implements MenuFragment.onMenuFragmentInteractionListener,
        StartFragment.startFragmentInteractionListener,
        AddDeckFragment.OnSettingsFragmentInteractionListener,
        AddCardsFragment.OnAddCardsFragmentInteractionListener,
        SeeAllFragment.OnSeeAllFragmentInteractionListener,
        SubjectFragment.OnSubjectFragmentInteractionListener{


    private static MainActivity mainActivity;

    public static ArrayList<Question> currentSubjectDeck;
    public static String currentSubject;

    public String getCurrentSubject() {
        return currentSubject;
    }

    public void setCurrentSubject(String curSub) {
        currentSubject = curSub;
    }


    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    public void setCurrentSubjectDeck(ArrayList<Question> list) {
        currentSubjectDeck = list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.setMainActivity(this);
        FragmentManager fm = getFragmentManager();
        Fragment f = fm.findFragmentById(R.id.menuFragment);
        if (f == null) {
            f = new MenuFragment();
            fm.beginTransaction().add(R.id.menuFragment,f).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_scrolling, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void loadStartFragment() {
        StartFragment sf = new StartFragment();
        getFragmentManager().beginTransaction().replace(R.id.menuFragment,sf).addToBackStack(null).commit();
    }

    public void loadSettingsFragment() {
        AddDeckFragment sf = new AddDeckFragment();
        getFragmentManager().beginTransaction().replace(R.id.menuFragment,sf).addToBackStack(null).commit();
    }

    public void loadAddCardsFragment() {
        AddCardsFragment acf = new AddCardsFragment();
        getFragmentManager().beginTransaction().replace(R.id.menuFragment,acf).addToBackStack(null).commit();
    }

    public void loadSeeAllCardsFragment() {
        SeeAllFragment saf = new SeeAllFragment();
        getFragmentManager().beginTransaction().replace(R.id.menuFragment,saf).addToBackStack(null).commit();
    }

    public void loadSubjectCardsScreen(String selectedSubject) {
        getFragmentManager().beginTransaction().replace(R.id.menuFragment,new SubjectFragment().newInstance(selectedSubject)).addToBackStack(null).commit();
    }

    public void loadMoreCards(String subjectName) {
        FragmentManager fm = getMainActivity().getFragmentManager();
        fm.popBackStack();
        getFragmentManager().beginTransaction().replace(R.id.menuFragment,new SubjectFragment().newInstance(subjectName)).addToBackStack(null).commit();
    }
    @Override
    public void onMenuFragmentInteraction(Uri uri) {

    }

    @Override
    public void onStartFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSettingsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onAddCardsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSeeAllFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSubjectFragmentInteraction(Uri uri) {

    }

    public ArrayList<Question> getCurrentSubjectDeck(String string) {
        return currentSubjectDeck;
    }
}
