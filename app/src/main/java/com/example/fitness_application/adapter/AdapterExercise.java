package com.example.fitness_application.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness_application.R;
import com.example.fitness_application.model.Exercise;
import com.orm.SugarRecord;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Денис on 31.05.2017.
 */

public class AdapterExercise extends BaseAdapter {


    private List<Exercise> exerciseList;

    private Context context;

    //Constructor
    public AdapterExercise(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return exerciseList.size();
    }

    @Override
    public Object getItem(int position) {
        return exerciseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.listitem_exercise_see, null);
            fillView(view, position);
            return view;
    }

    private void fillView(View v, int position) {
        final Exercise exercise = (Exercise) getItem(position);

        TextView tvDate = (TextView)v.findViewById(R.id.tvDate);
        TextView tvExNameC = (TextView)v.findViewById(R.id.tvExNameC);
        TextView tvRI = (TextView)v.findViewById(R.id.tvRI);
        TextView tvRII = (TextView)v.findViewById(R.id.tvRII);
        TextView tvRIII = (TextView)v.findViewById(R.id.tvRIII);
        TextView tvRIV = (TextView)v.findViewById(R.id.tvRIV);
        TextView tvRV = (TextView)v.findViewById(R.id.tvRV);
        TextView tvWeightI = (TextView)v.findViewById(R.id.tvWeightI);
        TextView tvWeightII = (TextView)v.findViewById(R.id.tvWeightII);
        TextView tvWeightIII = (TextView)v.findViewById(R.id.tvWeightIII);
        TextView tvWeightIV = (TextView)v.findViewById(R.id.tvWeightIV);
        TextView tvWeightV = (TextView)v.findViewById(R.id.tvWeightV);

        //Set text for View
        tvDate.setText(exercise.getBirth());
        tvExNameC.setText(exercise.getName());
        tvRI.setText(String.valueOf(exercise.getReiteration1()));
        tvRII.setText(String.valueOf(exercise.getReiteration2()));
        tvRIII.setText(String.valueOf(exercise.getReiteration3()));
        tvRIV.setText(String.valueOf(exercise.getReiteration4()));
        tvRV.setText(String.valueOf(exercise.getReiteration5()));
        tvWeightI.setText(String.valueOf(exercise.getWeight1()));
        tvWeightII.setText(String.valueOf(exercise.getWeight2()));
        tvWeightIII.setText(String.valueOf(exercise.getWeight3()));
        tvWeightIV.setText(String.valueOf(exercise.getWeight4()));
        tvWeightV.setText(String.valueOf(exercise.getWeight5()));

        //Save product id to tag
        v.setTag(exercise.getId());

        // Добавим возможность клика
        v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SugarRecord.delete(exercise);
                AdapterExercise.this.notifyDataSetChanged();
                Toast.makeText(AdapterExercise.this.context, "Запись удалена!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
