package com.example.workfit.WorkoutActivities_Abs;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.workfit.DataFiles.DetailedProgress_DynamicData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.Timer;
import com.example.workfit.workfitapps.R;

/**
 * Created by Revina Adisty on 6/28/2017.
 */

public class Easy_Abs1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_workout_easy_1);

        final Chronometer chronometer = (Chronometer)findViewById(R.id.chronometer2);
        chronometer.start();

        final Timer timer = new Timer(8,this,Easy_Abs1.this);


        Button next = (Button)findViewById(R.id.nextButton1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Easy_Abs1.this, Easy_Abs2.class);
                timer.runTimer();

                DatabaseHandler db = new DatabaseHandler(Easy_Abs1.this); //Deklarasi database handler 'online'
                DetailedProgress_DynamicData dbOffline; //Deklarasi container database 'offline'
                dbOffline = db.getDatabase(0); //ngambil database dari 'online' masukin dalem containter 'offline'
                dbOffline.addV0(); //container 'offline' ditambahin isinya
                db.updateDatabase(dbOffline); //container dikirim lagi ke database 'online'

                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();

                intent.putExtra("chrono", elapsedMillis);
                startActivity(intent);
            }
        });
    }
}
