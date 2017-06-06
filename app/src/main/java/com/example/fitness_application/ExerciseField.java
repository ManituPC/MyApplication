package com.example.fitness_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness_application.objects.Exercise;

/**
 * Created by Денис on 06.06.2017.
 */

public class ExerciseField extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listitem_exercise);
    }
}
