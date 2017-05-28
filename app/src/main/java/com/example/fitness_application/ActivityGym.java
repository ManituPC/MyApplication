package com.example.fitness_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityGym extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);
    }

    public void clickStr(View view) {
        Intent i = new Intent(this, ActivityStr.class);
        startActivity(i);
    }

    public void clickWeight(View view) {
        Intent i = new Intent(this, ActivityWeight.class);
        startActivity(i);
    }

    public void clickBeach(View view) {
        Intent i = new Intent(this, ActivityBeach.class);
        startActivity(i);
    }
}
