package com.example.fitness_application;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Денис on 03.06.2017.
 */

public class ActivityStopwatch extends AppCompatActivity {

    int seconds;
    boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        runTime();

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
    }

    public void onStartClick(View view) {
        running = true;
    }

    public void onStopClick(View view) {
        running = false;
    }

    public void onResetChronom(View view) {
        running = false;
        seconds = 0;
    }

    private void runTime(){
        final TextView tvStopwatch = (TextView) findViewById(R.id.tvStopwatch);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 360000;
                int minutes = (seconds % 360000) / 6000;
                int secs = (seconds % 6000) / 100;
                int msecs = seconds % 100;

                String time = String.format("%01d:%02d:%02d:%02d", hours, minutes, secs, msecs);
                tvStopwatch.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1);
            }
        });
    }
}
