package com.example.workfit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.workfit.workfitapps.R;

import org.w3c.dom.Text;

/**
 * Created by Revina Adisty on 6/29/2017.
 */

public class Timer {

    private int time;
    private Activity activity;
    private Context context;

    public Timer(int time, Activity activity, Context context) {
        this.time = time * 1000;
        this.activity = activity;
        this.context = context;
    }

    public void runTimer() {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_overlay_timer);
        dialog.setCancelable(false);
        dialog.show();

        final TextView timer = (TextView)activity.findViewById(R.id.timer);
        new CountDownTimer(this.time, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(Long.toString(millisUntilFinished / 1000));
            }

            public void onFinish() {
                timer.setText("done!");
                dialog.dismiss();
            }
        }.start();
    }
}
