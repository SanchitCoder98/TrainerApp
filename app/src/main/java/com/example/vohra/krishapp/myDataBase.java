package com.example.vohra.krishapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by vohra on 11/13/2016.
 */

public class myDataBase extends SQLiteOpenHelper {
    public static String DATABASE="myDataBase";
    public static myDataBase db;
    String USERTABLE="Create table user(name TEXT)";
    String WORKTABLE="CREATE TABLE work(name TEXT, day TEXT, date TEXT, stime TEXT, etime TEXT, workout TEXT)";
    public static myDataBase getInstance(Context context)
    {
        if(db==null)
        {
            db=new myDataBase(context,DATABASE,null,1);
        }
        return db;
    }
    public myDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USERTABLE);
        db.execSQL(WORKTABLE);
    }
    public void insert(String n)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",n);
        db.insert("user",null,cv);
    }
    public ArrayList<String> getClients()
    {
        ArrayList<String> a=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user",null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        while(cursor.isAfterLast()==false)
        {
            a.add(cursor.getString(cursor.getColumnIndex("name")));
            cursor.moveToNext();
        }
        return a;
    }
    public boolean hasObject(String n) {
        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM USER WHERE NAME =?";
        Cursor cursor = db.rawQuery(selectString, new String[] {n});

        boolean hasObject = false;
        if(cursor.moveToFirst()){
            hasObject = true;
        }
        cursor.close();
        db.close();
        return hasObject;
    }
    public void insertWork(Workout workout)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",workout.name);
        cv.put("day",workout.day);
        cv.put("date",workout.date);
        cv.put("stime",workout.stime);
        cv.put("etime",workout.etime);
        cv.put("workout",workout.works);
        db.insert("work",null,cv);
    }

    public ArrayList<Workout> getWorkouts(String n)
    {
        ArrayList<Workout> workouts=new ArrayList<>();
        Workout workout;
        SQLiteDatabase db=this.getReadableDatabase();
        String select="SELECT * FROM WORK WHERE NAME=?";
        Cursor cursor=db.rawQuery(select,new String[] {n});
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        while(cursor.isAfterLast()==false)
        {
            workout=new Workout(n,cursor.getString(cursor.getColumnIndex("day")),cursor.getString(cursor.getColumnIndex("date")),cursor.getString(cursor.getColumnIndex("stime")),cursor.getString(cursor.getColumnIndex("etime")),cursor.getString(cursor.getColumnIndex("workout")));
            workouts.add(workout);
            cursor.moveToNext();
        }
        return  workouts;
    }
    public void deleteUser(String n)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        try
        {
            db.delete("user","name=?",new String[]{n});
            db.delete("work","name=?",new String[]{n});
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            db.close();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
