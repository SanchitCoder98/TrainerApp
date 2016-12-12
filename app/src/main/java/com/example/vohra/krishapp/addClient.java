package com.example.vohra.krishapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class addClient extends AppCompatActivity {
    EditText name;
    TextView nam;
    ImageButton add;
    TextView email;
    EditText emai;
    myDataBase dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"babas.ttf");
        nam= (TextView) findViewById(R.id.name);
        nam.setTypeface(typeface);
        name= (EditText) findViewById(R.id.getname);
        add= (ImageButton) findViewById(R.id.adduser);
        email= (TextView) findViewById(R.id.email);
        email.setTypeface(typeface);
        emai= (EditText) findViewById(R.id.getemail);
        dataBaseHelper=myDataBase.getInstance(this);
        final AlertDialog.Builder alert=new AlertDialog.Builder(addClient.this);
        alert.setTitle("Error");
        alert.setMessage("Client Already exists")
                .setCancelable(false);
        alert.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String e=emai.getText().toString();
                if(dataBaseHelper.hasObject(n))
                {
                    alert.show();
                }
                else {
                    dataBaseHelper.insert(n,e);
                    Intent intent = new Intent(addClient.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
