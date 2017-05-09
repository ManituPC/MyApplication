package com.example.fitness_application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickTimer (View view) {
        Intent i = new Intent(this, ActivityTimer.class);
        startActivity(i);
    }
    public void ClickGym (View view) {
        Intent i = new Intent(this, ActivityGym.class);
        startActivity(i);
    }
    public void ClickDiary (View view) {
        Intent i = new Intent(this, ActivityDiary.class);
        startActivity(i);
    }
    public void ClickCalc (View view) {
        Intent i = new Intent(this, ActivityCalc.class);
        startActivity(i);
    }


//    Диалог выхода да/нет?

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        openQuitDialog();
//    }
//
//    private void openQuitDialog() {
//        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
//                MainActivity.this);
//        quitDialog.setTitle("Выход: Вы уверены?");
//
//        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
////                 TODO Auto-generated method stub
//                finish();
//            }
//        });
//
//        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
////                 TODO Auto-generated method stub
//            }
//        });
//
//        quitDialog.show();
//    }
}

