package com.example.vohra.krishapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"babas.ttf");
        TextView textView= (TextView) findViewById(R.id.welcome);
        textView.setTypeface(typeface);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);//Menu Resource, Menu
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.addclient:
                intent=new Intent(MainActivity.this,addClient.class);
                startActivity(intent);
                return true;
            case R.id.removeclient:
                intent=new Intent(MainActivity.this,addWorkout.class);
                startActivity(intent);
                return true;
            case R.id.view:
                intent=new Intent(MainActivity.this,viewWorkouts.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
