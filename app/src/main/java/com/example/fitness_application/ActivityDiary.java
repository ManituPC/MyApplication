package com.example.fitness_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fitness_application.adapter.AdapterExercise;
import com.example.fitness_application.objects.Exercise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityDiary extends AppCompatActivity {

    ListView lvExercise;
    ArrayList<Exercise> exerciseArrayList;
    ArrayAdapter<Exercise> exerciseArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        lvExercise = (ListView) findViewById(R.id.lvExercise);

        exerciseArrayList = new ArrayList<>();

        exerciseArrayAdapter = new ArrayAdapter<Exercise>(this, android.R.layout.simple_list_item_1,exerciseArrayList);

        lvExercise.setAdapter(exerciseArrayAdapter);

        createExerciseList();

        fillList();
    }

    public void onClickAddExercise(){
        Intent intent = new Intent();
        intent.setClass(ActivityDiary.this, ExerciseField.class);
        startActivityForResult(intent, Intent_Constans.INTENT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    private void fillList() {
        AdapterExercise adapterExercise = new AdapterExercise(exercises, this);
        lvExercise.setAdapter(adapterExercise);
    }

    private void createFriendsList() {
        Random r = new Random();
        Calendar c = Calendar.getInstance();
        c.roll(Calendar.YEAR, -25); // всем не более 25 лет
        long possibleBirthday = c.getTimeInMillis(); // переводим в timestamp
        exercises = new ArrayList<Exercise>();
        for (int i = 0; i < 10; i++) {
            Exercise ex1 = new Exercise();
            ex1.setBirth(r.nextLong() % possibleBirthday);
//            if (i % 2 == 0)
//                ex1.setEmail("mymail" + r.nextInt(1000) +
//                        "@mail.ru");
//            ex1.setTelephone("+7 923 42" + i + "3 221 3" + i);
//            ex1.setFavourite(i % 3 == 0);
            ex1.setName("Иван Петрович №" + i);
//            ex1.setAvatarExist(r.nextInt(10) % 2 == 0);
            exercises.add(ex1);
        }
    }

    private void createExerciseList(){
        exercises = new ArrayList<Exercise>();
        Exercise ex1 = new Exercise();
        ex1.getBirth();
        ex1.getName();
        ex1.getReiteration1();
        ex1.getReiteration2();
        ex1.getReiteration3();
        ex1.getReiteration4();
        ex1.getReiteration5();

        exercises.add(ex1);
    }
}
