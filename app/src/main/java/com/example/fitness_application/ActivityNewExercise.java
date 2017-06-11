package com.example.fitness_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitness_application.model.Exercise;

/**
 * Created by Денис on 06.06.2017.
 */

public class ActivityNewExercise extends AppCompatActivity {

    EditText etDate, etExName, etRI, etRII, etRIII, etRIV, etRV, etWeightI, etWeightII, etWeightIII,
            etWeightIV, etWeightV;

    Button btnSaveNewEx;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise);

        etDate = (EditText)findViewById(R.id.etDate);
        etExName = (EditText)findViewById(R.id.etExName);
        etRI = (EditText)findViewById(R.id.etRI);
        etRII = (EditText)findViewById(R.id.etRII);
        etRIII = (EditText)findViewById(R.id.etRIII);
        etRIV = (EditText)findViewById(R.id.etRIV);
        etRV = (EditText)findViewById(R.id.etRV);
        etWeightI = (EditText)findViewById(R.id.etWeightI);
        etWeightII = (EditText)findViewById(R.id.etWeightII);
        etWeightIII = (EditText)findViewById(R.id.etWeightIII);
        etWeightIV = (EditText)findViewById(R.id.etWeightIV);
        etWeightV = (EditText)findViewById(R.id.etWeightV);

        btnSaveNewEx = (Button)findViewById(R.id.btnSaveNewEx);
    }

    public void clickAddNewExercise(View view) {

        Exercise exercise = new Exercise();
        exercise.setBirth(getInt(etDate));
        exercise.setName(getStr(etExName));
        exercise.setReiteration1(getInt(etRI));
        exercise.setReiteration2(getInt(etRII));
        exercise.setReiteration3(getInt(etRIII));
        exercise.setReiteration4(getInt(etRIV));
        exercise.setReiteration5(getInt(etRV));
        exercise.setWeight1(getInt(etWeightI));
        exercise.setWeight2(getInt(etWeightII));
        exercise.setWeight3(getInt(etWeightIII));
        exercise.setWeight4(getInt(etWeightIV));
        exercise.setWeight5(getInt(etWeightV));
        exercise.save();

        Intent intent  = new Intent(ActivityNewExercise.this, ActivityDiary.class);
        startActivity(intent);
    }

    @NonNull
    private String getStr(EditText editText){
        return editText.getText().toString();
    }

    private int getInt (EditText editText){
        int i = Integer.parseInt(editText.getText().toString());
        return i;
    }
}
