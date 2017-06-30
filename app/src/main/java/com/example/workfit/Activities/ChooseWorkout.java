package com.example.workfit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.workfit.workfitapps.R;

public class ChooseWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseworkout);
    }

    public void armWorkout() {
        Intent intent = new Intent(ChooseWorkout.this, WorkoutDetails_Arm.class);
        startActivity(intent);
    }

    public void absWorkout() {
        Intent intent = new Intent(ChooseWorkout.this, WorkoutDetails_Abs.class);
        startActivity(intent);
    }

    public void legWorkout() {
        Intent intent = new Intent(ChooseWorkout.this, WorkoutDetails_Leg.class);
        startActivity(intent);
    }
}
