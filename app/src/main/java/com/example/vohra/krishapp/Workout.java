package com.example.vohra.krishapp;

/**
 * Created by vohra on 11/16/2016.
 */

public class Workout {
    String day;
    String date;
    String stime;
    String etime;
    String name;
    String works;
    Workout(String name, String day, String date, String stime, String etime, String works)
    {
        this.name=name;
        this.day=day;
        this.date=date;
        this.stime=stime;
        this.etime=etime;
        this.works=works;
    }
}
