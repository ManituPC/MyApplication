package com.example.fitness_application;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitness_application.model.Exercise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Денис on 06.06.2017.
 */

public class ActivityNewExercise extends AppCompatActivity {

    EditText etExName, etRI, etRII, etRIII, etRIV, etRV, etWeightI, etWeightII, etWeightIII,
            etWeightIV, etWeightV;

    Button btnSaveNewEx;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise);

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

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void clickAddNewExercise(View view) {

        getLength(etExName,etRI,etRII,etRIII,etRIV,etRV,etWeightI,etWeightII,etWeightIII,
                etWeightIV,etWeightV);
    }

    @NonNull
    private String getStr(EditText editText){
        return editText.getText().toString();
    }

    private int getInt (EditText editText){
        int i = Integer.parseInt(editText.getText().toString());
        return i;
    }

    private void getLength(EditText etExName,EditText etRI,EditText etRII,EditText
            etRIII,EditText etRIV,EditText etRV,EditText etWeightI,EditText etWeightII,EditText
            etWeightIII,EditText etWeightIV,EditText etWeightV) {
        if (etExName.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etRI.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etRII.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etRIII.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etRIV.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etRV.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etWeightI.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etWeightII.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etWeightIII.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etWeightIV.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else if (etWeightV.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show();
        } else {
            Exercise exercise = new Exercise();
            exercise.setBirth(getDateTime());
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
    }
}


