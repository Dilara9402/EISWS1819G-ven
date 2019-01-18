package com.example.dilarag.dontforgetapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrieren extends Activity {

    EditText etName;
    EditText etVorname;
    EditText etUsername;
    EditText etPasswort;
    EditText systemID;
    Button btnZurueck;
    Button btnRegistrieren;
    String myString = "Neue Person wurde hinzugefügt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);

        etName = (EditText) findViewById(R.id.etName);
        etVorname = (EditText) findViewById(R.id.etVorname);
        etUsername = (EditText) findViewById(R.id.etUsername);
        systemID = (EditText) findViewById(R.id.etSystem);
        etPasswort = (EditText) findViewById(R.id.etPasswort);

        btnZurueck = (Button) findViewById(R.id.btnZurueck);
        btnRegistrieren = (Button) findViewById(R.id.btnRegistrieren);


        //Button Zurück
        btnZurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrieren.this, Login.class);
                startActivity(intent);
            }
        });


        //Button Registrieren - Datenbank fehlt
        btnRegistrieren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrieren.this, Zugriffsliste.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG).show();

            }
        });
    }
}
