package com.example.dilarag.dontforgetapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class Haushaltsgeraete extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Haushaltsgeraete> geraeteListe=new ArrayList<>();
    Button btnBearbeiten;
    Button btnZurueck1;
    EditText üHG;
    EditText üZustand;
    TextView liste;
    Switch s1, s2, s3, s4;

    private String art;
    private double verbrauch;
    private Date datum=new Date();

    public Haushaltsgeraete(String art, double verbrauch) {
        this.art = art;
        this.verbrauch = verbrauch;
    }

    public void add(Haushaltsgeraete g) {
        geraeteListe.add(g);
    }

    public Haushaltsgeraete() {}

    public String getArt() {
        return art;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public void setVerbrauch(double verbrauch) {
        this.verbrauch = verbrauch;
    }

    public Date getDatum() {
        return datum;
    }

    public void print(){
        System.out.println(art + " : " + verbrauch + " kWH " + datum);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haushaltsgeraete);





        btnBearbeiten = (Button) findViewById(R.id.btnLöschen);
        liste = (TextView) findViewById(R.id.viewList);


        /*s1 = (Switch) findViewById(R.id.switch1);
        s2 = (Switch) findViewById(R.id.switch2);
        s3 = (Switch) findViewById(R.id.switch3);
        s4 = (Switch) findViewById(R.id.switch4);
*/

        btnBearbeiten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        for(int i=0;i<geraeteListe.size();i++)
        {
            System.out.println(geraeteListe.get(i).getArt());
            liste.append(geraeteListe.get(i).getArt());
        }
    }

    public void openDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(Haushaltsgeraete.this);
        dialog.setCancelable(false);
        dialog.setTitle("Wählen Sie eine Aktion aus:");
        dialog.setMessage("");

        //Button Gerät hinzufügen
        dialog.setPositiveButton("Neues Gerät hinzufügen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //Action for "Delete"
                Intent intent = new Intent(Haushaltsgeraete.this, Zugriffsliste.class);
                startActivity(intent);

            }

            //Button Gerät löschen -- FUNKTIONIERT NICHT
        })      .setNegativeButton("Gerät löschen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Action for "Gerät löschen"
                Intent intent = new Intent(Haushaltsgeraete.this, Geraeteliste.class);
                startActivity(intent);

            }
        });
        final AlertDialog alert = dialog.create();
        alert.show();
    }




    @Override
    public void onClick(View v) {

    }



}


