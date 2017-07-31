package com.deem.studybuddy.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;

import com.deem.studybuddy.fragments.addCards.AddCardsFragment;
import com.deem.studybuddy.fragments.mainMenu.MenuFragment;
import com.deem.studybuddy.fragments.seeAllCards.SeeAllFragment;
import com.deem.studybuddy.fragments.settings.SettingsFragment;
import com.deem.studybuddy.fragments.startCards.StartFragment;
import com.deem.studybuddy.R;
import com.deem.studybuddy.fragments.startCards.SubjectFragment;
import com.deem.studybuddy.model.Subjects;

public class MainActivity extends Activity implements MenuFragment.onMenuFragmentInteractionListener,
        StartFragment.startFragmentInteractionListener,
        SettingsFragment.OnSettingsFragmentInteractionListener,
        AddCardsFragment.OnAddCardsFragmentInteractionListener,
        SeeAllFragment.OnSeeAllFragmentInteractionListener,
        SubjectFragment.OnSubjectFragmentInteractionListener{


    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
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

    public void loadStartFragment() {
        StartFragment sf = new StartFragment();
        getFragmentManager().beginTransaction().replace(R.id.menuFragment,sf).addToBackStack(null).commit();
    }

    public void loadSettingsFragment() {
        SettingsFragment sf = new SettingsFragment();
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

    public void loadSubjectCardsScreen(Subjects selectedSubject) {
        getFragmentManager().beginTransaction().replace(R.id.startFragment,new SubjectFragment().newInstance(selectedSubject.getSubjectTitle())).addToBackStack(null).commit();
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
}
