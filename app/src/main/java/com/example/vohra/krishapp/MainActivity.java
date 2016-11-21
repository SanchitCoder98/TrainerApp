package com.example.vohra.krishapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button add;
    Button list;
    Button client;
    ImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Typeface comic_font=Typeface.createFromAsset(getAssets(),"comics.ttf");
        //welcome= (TextView) findViewById(R.id.welcome);
        //welcome.setTypeface(comic_font);
        add= (Button)findViewById(R.id.add_workout);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,addWorkout.class);
                startActivity(intent);
            }
        });
        client= (Button)findViewById(R.id.add_client);
        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,addClient.class);
                startActivity(intent);
            }
        });
        list= (Button)findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,viewWorkouts.class);
                startActivity(intent);
            }
        });

        final ArrayList<Integer> pics = new ArrayList<>();
        pics.add(R.drawable.arnold);
        pics.add(R.drawable.arnoldd);
        pics.add(R.drawable.img3);
        picture = (ImageView) findViewById(R.id.picture);
        //picture.setImageResource(pics.get(0));
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i=0;
            public void run() {
                picture.setImageResource(pics.get(i));
                i++;
                if(i>pics.size()-1)
                {
                    i=0;
                }
                handler.postDelayed(this, 5000);  //for interval...
            }
        };
        handler.postDelayed(runnable, 2000); //for initial delay..
    }
}
