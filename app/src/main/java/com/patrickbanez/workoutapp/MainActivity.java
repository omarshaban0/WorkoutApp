package com.patrickbanez.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String[] tabNames = {"Home", "Workout", "Statistics", "Settings"};

    private static HomeFragment home;
    private static WorkoutFragment workout;
    private static StatisticsFragment statistics;
    private static SettingsFragment settings;

    static {
        home = new HomeFragment();
        workout = new WorkoutFragment();
        statistics = new StatisticsFragment();
        settings = new SettingsFragment();
    }

    // For now the app opens to the Home page because I didn't set a starting point.
    // In the future we can set it to the login activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiding the title bar. I'll add it again when I can figure out how to resize it using XML file -- It's huge default
        getSupportActionBar().hide();
    }

    public void swapFragment(View v) {
        if (v.getId() == R.id.homeButton) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activeView, home, null).commit();
            setTitle(tabNames[0]);
        }
        if (v.getId() == R.id.workoutButton) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activeView, workout, null).commit();
            setTitle(tabNames[1]);
        }
        if (v.getId() == R.id.statisticsButton) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activeView, statistics, null).commit();
            setTitle(tabNames[2]);
        }
        if (v.getId() == R.id.settingsButton) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activeView, settings, null).commit();
            setTitle(tabNames[3]);
        }
    }
}