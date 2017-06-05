package com.example.fitness_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.fitness_application.model.AdapterExercise;
import com.example.fitness_application.model.Exercise;

import java.util.ArrayList;

/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityDiary extends AppCompatActivity {

    private ArrayList<Exercise> exercises;
    private ListView lvExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        lvExercise = (ListView) findViewById(R.id.lvExercise);
//        createExerciseList();
        fillList();
    }

    private void fillList() {
        AdapterExercise adapter = new AdapterExercise(exercises, this);
        lvExercise.setAdapter(adapter);
    }
}
