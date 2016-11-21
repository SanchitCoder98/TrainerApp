package com.example.vohra.krishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
public class viewWorkouts extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workouts);
        myDataBase db=myDataBase.getInstance(viewWorkouts.this);
        final ArrayList<String> name=db.getClients();
        GridAdapter adapter=new GridAdapter(this,name);
        listView= (ListView) findViewById(R.id.grid);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(viewWorkouts.this,viewWorkouts2.class);
                intent.putExtra("name",name.get(position));
                startActivity(intent);
            }
        });
    }
}
