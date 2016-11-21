package com.example.vohra.krishapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vohra on 11/17/2016.
 */

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> name;

    GridAdapter(Context context, ArrayList<String> name) {
        this.context = context;
        this.name = name;
    }

    public int getCount() {
       return name.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_layout, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.names);
            textView.setText(name.get(position));
            Button delete= (Button) gridView.findViewById(R.id.delete);
            final AlertDialog.Builder alert=new AlertDialog.Builder(context);
            alert.setTitle("Delete User");
            alert.setCancelable(false);
            alert.setMessage("Are you sure want to delete user?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    delete(name.get(position));
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alert.show();
                }
            });
            Button show= (Button) gridView.findViewById(R.id.show);
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,viewWorkouts2.class);
                    intent.putExtra("name",name.get(position));
                    context.startActivity(intent);
                }
            });
        }
        else {
            gridView = (View) convertView;
        }

        return gridView;
    }
    public final void delete(String n)
    {
        myDataBase db=myDataBase.getInstance(context);
        db.deleteUser(n);
    }
}
