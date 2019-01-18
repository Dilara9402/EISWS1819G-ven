package com.example.dilarag.dontforgetapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Zugriffsliste extends Activity {

    Button zurück;
    Button löschenZugriff;
    private RecyclerView recyclerView;
    private TableRow tabelle;
    String myString = " wurde gelöscht!";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zugriffsliste);


        TableRow tabelle = new TableRow(this);
        tabelle.setClickable(true);

        tabelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setBackgroundColor(Color.GRAY);
                System.out.println("Row clicked: " + v.getId());

                TableRow tableRow = (TableRow)v.getParent();
                TextView sample = (TextView)tableRow.getChildAt(2);
                String result = sample.getText().toString();
            }
        });




        //Buttons
        zurück = (Button) findViewById(R.id.btnZurueck2);
        löschenZugriff = (Button) findViewById(R.id.löschenZugriff);



        zurück.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zugriffsliste.this, Haushaltsgeraete.class);
                startActivity(intent);
            }
        });

        löschenZugriff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zugriffsliste.this, Registrieren.class);
                startActivity(intent);
                //Toast.makeText(NameonbuttonclickActivity.this, hello, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG).show();
                System.out.println(v.getId());
            }
        });



    }





}
