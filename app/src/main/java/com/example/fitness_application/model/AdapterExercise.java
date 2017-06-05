package com.example.fitness_application.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness_application.R;

import java.util.ArrayList;

/**
 * Created by Денис on 31.05.2017.
 */

public class AdapterExercise extends BaseAdapter {

    private ArrayList<Exercise> exercise;
    private Context c;

    public AdapterExercise(ArrayList<Exercise> exercises, Context c) {
        this.exercise = exercises;
        this.c = c;
    }

    @Override
    public int getCount() {
        return exercise.size();
    }

    @Override
    public Exercise getItem(int position) {
        return exercise.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(c).inflate(R.layout.listitem_exercise, null);

        fillView(convertView, position);
        return convertView;
    }

    private void fillView(View v, int position) {
        final Exercise ex1 = getItem(position);

        // name
        TextView tvExName = (TextView) v.findViewById(R.id.tvExName);
        tvExName.setText(ex1.getName());

        // reiteretion
        EditText etRI = (EditText) v.findViewById(R.id.etRI);
        if (etRI.getText().length() == 0) {
            etRI.setError("Заполните пустое поле");
        } else {
//            saveReiteration();
        }

        EditText etRII = (EditText) v.findViewById(R.id.etRII);
        if (etRII.getText().length() == 0) {
            etRII.setError("Заполните пустое поле");
        } else {
//            saveReiteration();
        }

        EditText etRIII = (EditText) v.findViewById(R.id.etRIII);
        if (etRIII.getText().length() == 0) {
            etRIII.setError("Заполните пустое поле");
        } else {
//            saveReiteration();
        }

        EditText etRIV = (EditText) v.findViewById(R.id.etRIV);
        if (etRIV.getText().length() == 0) {
            etRIV.setError("Заполните пустое поле");
        } else {
//            saveReiteration();
        }

        EditText etRV = (EditText) v.findViewById(R.id.etRV);
        if (etRV.getText().length() == 0) {
            etRV.setError("Заполните пустое поле");
        } else {
//            saveReiteration();
        }

        v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AdapterExercise.this.c,
                        ex1.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    void saveReiteration(EditText i) {

    }

}
