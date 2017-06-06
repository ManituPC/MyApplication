package com.example.fitness_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.fitness_application.adapter.AdapterExercise;
import com.example.fitness_application.objects.Exercise;

import java.util.ArrayList;

/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityDiary extends AppCompatActivity {

    private ListView lvExercise;
    private AdapterExercise adapterExercise;
    private ArrayList<Exercise> exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        lvExercise = (ListView)findViewById(R.id.lvExercise);

        exerciseList = new ArrayList<Exercise>();

        //Add sample data for list
        exerciseList.add(new Exercise(1, 60617, "Жим лежа на скамье", 12, 12, 12, 10, 10, 40, 40, 40, 45, 45));
        exerciseList.add(new Exercise(2, 60617, "Приседания со штангой", 12, 12, 12, 11, 10, 60, 60, 60, 65, 65));

        //Init adapter
        adapterExercise = new AdapterExercise(exerciseList, this);
        lvExercise.setAdapter(adapterExercise);

//        lvExercise.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "Нажатие произошло!", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

    }

    public void onClickAddExercise(View view) {
        Intent i = new Intent(this, ActivityNewExercise.class);
        startActivity(i);
    }
}
