package com.example.fitness_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.fitness_application.adapter.AdapterExercise;
import com.example.fitness_application.model.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityDiary extends AppCompatActivity {

    private ListView lvExercise;
    private AdapterExercise adapterExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        lvExercise = (ListView)findViewById(R.id.lvExercise);

        List<Exercise> allExercise = Exercise.listAll(Exercise.class);

        //Init adapter
        adapterExercise = new AdapterExercise(allExercise, this);
        lvExercise.setAdapter(adapterExercise);
    }

    public void onClickAddExercise(View view) {
        Intent i = new Intent(this, ActivityNewExercise.class);
        startActivity(i);
    }
}
