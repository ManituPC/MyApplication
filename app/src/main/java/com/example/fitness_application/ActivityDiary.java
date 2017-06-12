package com.example.fitness_application;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fitness_application.adapter.AdapterExercise;
import com.example.fitness_application.model.Exercise;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

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
