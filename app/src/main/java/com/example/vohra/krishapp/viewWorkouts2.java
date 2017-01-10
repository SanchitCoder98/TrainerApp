package com.example.vohra.krishapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
    AlertDialog.Builder alert;
    myDataBase dataBase;
    String email;
    String body;
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
        final ArrayList<Workout> workouts=db.getWorkouts(name);
        listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(new ListAdapter(this,workouts));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   body=workouts.get(position).date +"\n"+ workouts.get(position).stime+workouts.get(position).etime+"\n"+workouts.get(position).works;
                   alert.show();
            }
        });
        dataBase=myDataBase.getInstance(this);
        alert=new AlertDialog.Builder(viewWorkouts2.this);
        alert.setTitle("Email");
        alert.setCancelable(false);
        alert.setMessage("Are you sure you want to email this workout?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email=dataBase.getEmail(name);
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Gym Workout");
                emailIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(emailIntent);
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
}
