package com.example.fitness_application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTimer (View view) {
        Intent i = new Intent(this, ActivityTimer.class);
        startActivity(i);
    }

    public void onClickGym (View view) {
        Intent i = new Intent(this, ActivityGym.class);
        startActivity(i);
    }

    public void onClickDiary (View view) {
        Intent i = new Intent(this, ActivityDiary.class);
        startActivity(i);
    }

    public void onClickCalc (View view) {
        Intent i = new Intent(this, ActivityCalc.class);
        startActivity(i);
    }

    public void onClickStopwatch (View view) {
        Intent i = new Intent(this, ActivityStopwatch.class);
        startActivity(i);
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Вы действительно хотите покинуть программу?")
                .setCancelable(false).setPositiveButton("Да", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        }).setNegativeButton("Нет", null).show();
    }
}

