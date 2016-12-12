package com.example.vohra.krishapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;


public class addWorkout extends AppCompatActivity {
    Spinner clients;
    ImageButton date;
    ImageButton time;
    ImageButton endtime;
    myDataBase dataBaseHelper;
    String name;
    String getDate;
    String getStartTime;
    String getEndTime;
    myDataBase dataBase;
    ImageButton adduser;
    CheckBox upperbody;
    CheckBox lowerbody;
    CheckBox abdominal;
    CheckBox sides;
    CheckBox hips;
    CheckBox bicep;
    CheckBox chest;
    CheckBox back;
    CheckBox tricep;
    CheckBox shoulders;
    CheckBox legs;
    CheckBox cardio;
    CheckBox kick;
    String dwk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);
        clients= (Spinner) findViewById(R.id.name);
        dataBaseHelper=myDataBase.getInstance(this);

        // GET SPINNER
        final ArrayList<String> arrayList=dataBaseHelper.getClients();
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        clients.setAdapter(arrayAdapter);
        clients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=arrayList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // GET DATE AND TIME
        DateFormat df = new SimpleDateFormat("EEE,yyyy.MM.dd,HH:mm");
        String da = df.format(Calendar.getInstance().getTime());
        StringTokenizer st=new StringTokenizer(da,",");
        dwk=st.nextToken();
        dwk=dwk.trim();
        String d=st.nextToken();
        String ti=st.nextToken();
        st=new StringTokenizer(d,".");
        int year=Integer.parseInt(st.nextToken());
        int mon=Integer.parseInt(st.nextToken());
        int day=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(ti,":");
        int hour=Integer.parseInt(st.nextToken());
        int min=Integer.parseInt(st.nextToken());
        date= (ImageButton) findViewById(R.id.date);
        time= (ImageButton) findViewById(R.id.time);
        endtime= (ImageButton) findViewById(R.id.endtime);
        final DatePickerDialog datePickerDialog=new DatePickerDialog(addWorkout.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 getDate=Integer.toString(year)+"/"+Integer.toString(month)+"/"+Integer.toString(dayOfMonth);
            }
        },year,mon-1,day);
        final TimePickerDialog timePickerDialog=new TimePickerDialog(addWorkout.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                   getStartTime=Integer.toString(hourOfDay)+":"+Integer.toString(minute);
            }
        },hour,min,false);
        final TimePickerDialog timePickerDialog2=new TimePickerDialog(addWorkout.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                   getEndTime=Integer.toString(hourOfDay)+":"+Integer.toString(minute);
            }
        },hour,min,false);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
        endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog2.show();
            }
        });

        upperbody= (CheckBox) findViewById(R.id.upperbody);
        lowerbody= (CheckBox) findViewById(R.id.lowerbody);
        abdominal= (CheckBox) findViewById(R.id.abdominal);
        sides= (CheckBox) findViewById(R.id.sides);
        chest= (CheckBox) findViewById(R.id.chest);
        back= (CheckBox) findViewById(R.id.back);
        shoulders= (CheckBox) findViewById(R.id.shoulders);
        legs= (CheckBox) findViewById(R.id.legs);
        bicep= (CheckBox) findViewById(R.id.bicep);
        tricep= (CheckBox) findViewById(R.id.tricep);
        kick= (CheckBox) findViewById(R.id.kick);
        cardio= (CheckBox) findViewById(R.id.cardio);
        hips= (CheckBox) findViewById(R.id.hips);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"babas.ttf");
        upperbody.setTypeface(typeface);
        lowerbody.setTypeface(typeface);
        abdominal.setTypeface(typeface);
        sides.setTypeface(typeface);
        chest.setTypeface(typeface);
        back.setTypeface(typeface);
        shoulders.setTypeface(typeface);
        legs.setTypeface(typeface);
        bicep.setTypeface(typeface);
        tricep.setTypeface(typeface);
        kick.setTypeface(typeface);
        cardio.setTypeface(typeface);
        hips.setTypeface(typeface);



        adduser= (ImageButton) findViewById(R.id.add);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String works="";
                if(upperbody.isChecked())
                    works+=upperbody.getText().toString()+" ";
                if(lowerbody.isChecked())
                    works+=lowerbody.getText().toString()+" ";
                if(abdominal.isChecked())
                    works+=abdominal.getText().toString()+" ";
                if(sides.isChecked())
                    works+=sides.getText().toString()+" ";
                if(bicep.isChecked())
                    works+=bicep.getText().toString()+" ";
                if(tricep.isChecked())
                    works+=tricep.getText().toString()+" ";
                if(back.isChecked())
                    works+=back.getText().toString()+" ";
                if(chest.isChecked())
                    works+=chest.getText().toString()+" ";
                if(shoulders.isChecked())
                    works+=shoulders.getText().toString()+" ";
                if(legs.isChecked())
                    works+=legs.getText().toString()+" ";
                if(cardio.isChecked())
                    works+=cardio.getText().toString()+" ";
                if(kick.isChecked())
                    works+=kick.getText().toString()+" ";
                if(hips.isChecked())
                    works+=hips.getText().toString()+" ";
                Workout workout=new Workout(name,dwk,getDate,getStartTime,getEndTime,works);
                dataBase=myDataBase.getInstance(addWorkout.this);
                dataBase.insertWork(workout);
                Intent intent=new Intent(addWorkout.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
