package com.example.dilarag.dontforgetapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,  View.OnClickListener {

    private DrawerLayout drawer;

    private Button btn1;
    private EditText etName;
    private EditText etPasswort;
    private TextView tvRegistrieren;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Drawer
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //erste Warnung
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WarnungFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_warnung);
        }


        btn1 = (Button) findViewById(R.id.btn1);    //per ID wird das richtige Objekt gesucht und ausgewählt
        btn1.setOnClickListener(this);
        etName = (EditText) findViewById(R.id.etName);
        etPasswort =  (EditText) findViewById(R.id.etPasswort);

        //Link zum Registrieren
        tvRegistrieren = (TextView) findViewById(R.id.tvRegistrieren);
        tvRegistrieren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRegistrieren.setText("Noch nicht registriert? Dann jetzt registrieren!");
                Intent intent = new Intent(Login.this, Registrieren.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void validate (String userName, String userPasswort){
        if ((userName.equals( "Admin")) && (userPasswort.equals( "1234"))){
            Intent intent = new Intent(Login.this, Haushaltsgeraete.class);
            startActivity(intent);
        } else {
            counter--;

            if (counter == 0){
                System.out.println("ERROR");
            }
        }
    }


    @Override
    public void onClick(View v) {
        validate(etName.getText().toString(), etPasswort.getText().toString());
        Intent intent = new Intent(Login.this, Haushaltsgeraete.class );
        startActivity(intent);
        this.finish();
    }


    //Menü Auswahl
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_help:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpFragment()).commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                break;

            case R.id.nav_warnung:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WarnungFragment()).commit();
               break;

            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
