package com.example.workfit.WorkoutActivities_Abs;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.workfit.DataFiles.DetailedProgress_DynamicData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.Timer;
import com.example.workfit.workfitapps.R;

public class Easy_Abs3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_workout_easy_3);

        Bundle bundle = getIntent().getExtras();
        final long baseTime = bundle.getLong("chrono");

        final Chronometer chronometer = (Chronometer)findViewById(R.id.chronometer4);
        chronometer.setBase(baseTime);
        chronometer.start();

        final Timer timer = new Timer(10,this,Easy_Abs3.this);

        Button next = (Button)findViewById(R.id.nextButton3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Easy_Abs3.this, Easy_Abs4.class);
                timer.runTimer();

                DatabaseHandler db = new DatabaseHandler(Easy_Abs3.this); //Deklarasi database handler 'online'
                DetailedProgress_DynamicData dbOffline; //Deklarasi container database 'offline'
                dbOffline = db.getDatabase(0); //ngambil database dari 'online' masukin dalem containter 'offline'
                dbOffline.addV2(); //container 'offline' ditambahin isinya
                db.updateDatabase(dbOffline); //container dikirim lagi ke database 'online'

                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();

                long totalTimeSpent = baseTime + elapsedMillis;
                intent.putExtra("total", totalTimeSpent);

                intent.putExtra("chrono", elapsedMillis);
                startActivity(intent);
            }
        });
    }
}
