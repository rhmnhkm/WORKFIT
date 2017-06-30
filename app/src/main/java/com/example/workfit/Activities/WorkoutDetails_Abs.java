package com.example.workfit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.workfit.WorkoutActivities_Abs.Easy_Abs1;
import com.example.workfit.workfitapps.R;

/**
 * Created by Revina Adisty on 6/28/2017.
 */

public class WorkoutDetails_Abs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_workout_choose);
    }

    public void easyPlan() {
        Intent intent = new Intent(WorkoutDetails_Abs.this, Easy_Abs1.class);
        startActivity(intent);
    }

    public void mediumPlan() {
        /*Intent intent = new Intent(WorkoutDetails_Abs.this, Medium_Abs1.class);
        startActivity(intent);*/
    }

    public void hardPlan() {
        /*Intent intent = new Intent(WorkoutDetails_Abs.this, Hard_Abs1.class);
        startActivity(intent);*/
    }
}
