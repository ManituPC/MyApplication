package com.example.fitness_application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness_application.R;
import com.example.fitness_application.objects.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 31.05.2017.
 */

public class AdapterExercise extends BaseAdapter {

    private ArrayList<Exercise> exerciseList;

    private Context context;

    //Constructor
    public AdapterExercise(ArrayList<Exercise> exerciseList, Context conetxt) {
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
            view = LayoutInflater.from(context).inflate(R.layout.listitem_exercise_see, parent, false);
            fillView(view, position);
            return view;
    }

    private void fillView(View v, int position) {
        final Exercise ex = (Exercise) getItem(position);

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
        tvDate.setText(ex.getBirth());
        tvExNameC.setText(ex.getName());
        tvRI.setText(ex.getReiteration1());
        tvRII.setText(ex.getReiteration2());
        tvRIII.setText(ex.getReiteration3());
        tvRIV.setText(ex.getReiteration4());
        tvRV.setText(ex.getReiteration5());
        tvWeightI.setText(ex.getWeight1());
        tvWeightII.setText(ex.getWeight2());
        tvWeightIII.setText(ex.getWeight3());
        tvWeightIV.setText(ex.getWeight4());
        tvWeightV.setText(ex.getWeight5());

        //Save product id to tag
        v.setTag(ex.getId());

        // Добавим возможность клика
        v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AdapterExercise.this.context, ex.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
