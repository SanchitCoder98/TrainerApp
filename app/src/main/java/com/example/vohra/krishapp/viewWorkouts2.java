package com.example.vohra.krishapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class viewWorkouts2 extends AppCompatActivity {
    myDataBase db;
    ListView listView;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workouts2);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            name=extras.getString("name");
        }
        db=myDataBase.getInstance(this);
        ArrayList<Workout> workouts=db.getWorkouts(name);
        listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(new ListAdapter(this,workouts));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
