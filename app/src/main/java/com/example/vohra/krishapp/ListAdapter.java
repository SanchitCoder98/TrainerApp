package com.example.vohra.krishapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vohra on 11/18/2016.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Workout> workouts;
    ListAdapter(Context context, ArrayList<Workout> workouts)
    {
        this.context=context;
        this.workouts=workouts;
    }
    @Override
    public int getCount() {
        return workouts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.list_layout, null);

            // set value into textview
            TextView name= (TextView) gridView.findViewById(R.id.client_name);
            name.setText(workouts.get(position).name);
            TextView day= (TextView) gridView.findViewById(R.id.workout_day);
            day.setText(workouts.get(position).day);
            TextView date=(TextView) gridView.findViewById(R.id.workout_date);
            date.setText(workouts.get(position).date);
            TextView stime=(TextView) gridView.findViewById(R.id.stime);
            stime.setText(workouts.get(position).stime);
            TextView etime=(TextView) gridView.findViewById(R.id.etime);
            etime.setText(workouts.get(position).etime);
            TextView works=(TextView)gridView.findViewById(R.id.works);
            works.setText(workouts.get(position).works);


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
    }

