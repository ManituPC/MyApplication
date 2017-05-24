package com.example.fitness_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Денис on 01.03.2017.
 */
public class ActivityBeach extends AppCompatActivity {

    final String[] exercises = getResources().getStringArray(R.array.Упражнения2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);

        ListView listView = (ListView) findViewById(R.id.list_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exercises);
        listView.setAdapter(adapter);
    }
}
