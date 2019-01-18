package com.example.dilarag.dontforgetapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NeuesGeraet extends Activity {

    EditText artGerät;
    EditText Stromverbrauch;
    EditText Datum;
    Button abbrechen;
    Button speichern;
    String myString = "Ein neues Gerät wurde hinzugefügt!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neues_geraet);

        artGerät = (EditText) findViewById(R.id.etArtG);
        Stromverbrauch = (EditText) findViewById(R.id.etVerbrauch);
        Datum = (EditText) findViewById(R.id.etDatum);
        abbrechen = (Button) findViewById(R.id.btnLöschen);
        speichern = (Button) findViewById(R.id.btnSpeichern);

        //Button abbrechen
        abbrechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NeuesGeraet.this, Haushaltsgeraete.class);
                startActivity(intent);

            }
        });


        //Button speichern
        speichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NeuesGeraet.this, Geraeteliste.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG).show();
            }
        });

    }
}
