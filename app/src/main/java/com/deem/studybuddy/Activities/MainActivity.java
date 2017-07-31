package com.deem.studybuddy.Activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deem.studybuddy.Fragments.AddCardsFragment;
import com.deem.studybuddy.Fragments.MenuFragment;
import com.deem.studybuddy.Fragments.SeeAllFragment;
import com.deem.studybuddy.Fragments.SettingsFragment;
import com.deem.studybuddy.Fragments.StartFragment;
import com.deem.studybuddy.R;

public class MainActivity extends Activity implements MenuFragment.onMenuFragmentInteractionListener,
        StartFragment.startFragmentInteractionListener,
        SettingsFragment.OnSettingsFragmentInteractionListener,
        AddCardsFragment.OnAddCardsFragmentInteractionListener,
        SeeAllFragment.OnSeeAllFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        Fragment f = fm.findFragmentById(R.id.menuFragment);
        if (f == null) {
            f = new MenuFragment();
            fm.beginTransaction().add(R.id.menuFragment,f).commit();

        }

       /*
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                Fragment f = fm.findFragmentById(R.id.startFragment);
                StartFragment sf = new StartFragment();
                getFragmentManager().beginTransaction().replace(R.id.startFragment,sf).addToBackStack(null).commit();
            }
        };
        start.setOnClickListener(listener);*/
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
}
