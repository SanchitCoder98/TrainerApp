package com.example.vohra.krishapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
        /*AlertDialog.Builder alert=new AlertDialog.Builder(viewWorkouts2.this);
        alert.setTitle("Email this Workout?");
        alert.setCancelable(false);
        alert.setMessage("Are you sure want to delete user?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });*/
    }
}
