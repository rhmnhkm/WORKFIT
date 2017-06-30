package com.example.workfit.WorkoutActivities_Abs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.workfit.workfitapps.R;

public class Easy_Abs_Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy__abs__result);

        Bundle bundle = getIntent().getExtras();
        long totalTime = bundle.getLong("total");
    }
}
