package com.example.workfit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.workfit.workfitapps.R;

/**
 * Created by Revina Adisty on 6/28/2017.
 */

public class WorkoutDetails_Arm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_workout_choose);
    }

    /*public void easyPlan() {
        Intent intent = new Intent(WorkoutDetails_Abs.this, Easy_Arm.class);
        startActivity(intent);
    }

    public void mediumPlan() {
        Intent intent = new Intent(WorkoutDetails_Abs.this, Medium_Arm.class);
        startActivity(intent);
    }

    public void hardPlan() {
        Intent intent = new Intent(WorkoutDetails_Abs.this, Hard_Arm.class);
        startActivity(intent);
    }*/
}
