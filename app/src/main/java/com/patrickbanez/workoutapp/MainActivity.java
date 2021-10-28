package com.patrickbanez.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String[] tabNames = { "home" , "workout" , "tracking"};

    HomeFragment home;
    WorkoutFragment workout;
    TrackingFragment tracking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = new HomeFragment();
        workout = new WorkoutFragment();
        tracking = new TrackingFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.activeView, home, null).commit();
    }

    public void swapFragment(View v) {
        if (v.getId() == R.id.homeButton) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activeView, home, null).commit();
        }
        if (v.getId() == R.id.workoutButton) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activeView, workout, null).commit();
        }
        if (v.getId() == R.id.trackingButton) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activeView, tracking, null).commit();
        }
    }
}