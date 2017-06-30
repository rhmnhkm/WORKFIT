package com.example.workfit.Activities;

import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.workfit.DatabaseHandlers.DatabaseHandler_PersonalData;
import com.example.workfit.workfitapps.R;

public class SplashScreen extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                DatabaseHandler_PersonalData personaldb = new DatabaseHandler_PersonalData(SplashScreen.this);

                try {
                    if(personaldb.getPersonalData().getName()!= null) {
                        Intent i = new Intent(SplashScreen.this, Home.class);
                        startActivity(i);
                    }
                } catch  (CursorIndexOutOfBoundsException e) {
                    Intent i = new Intent(SplashScreen.this, Register.class);
                    startActivity(i);
                }

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
