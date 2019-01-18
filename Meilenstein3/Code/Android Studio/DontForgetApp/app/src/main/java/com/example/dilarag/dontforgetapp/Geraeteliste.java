package com.example.dilarag.dontforgetapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Geraeteliste extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<Gerät> geraeteListe;


    private static final String TAG = "Geraeteliste";

    private Button löschen;
    private Button abbrechen2;
    String myString = "Das Gerät wurde gelöscht!";
    //Geraeteliste geraeteList=new Geraeteliste();

    //Gerät licht=new Gerät("Licht",200);
    //Gerät herd=new Gerät("Herd",500);
    //Gerät fernseher=new Gerät("Fernseher",10000);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geraeteliste);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        geraeteListe = new ArrayList<>();


        for (int i = 0; i < geraeteListe.size() ; i++) {
            //Ausgabe Geräte
            Log.d(TAG, "Art des Geräts: " + geraeteListe.get(0).getArt() + " Verbrauch: " + geraeteListe.get(0).getVerbrauch());
        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        adapter = new MainAdapter(geraeteListe);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




        geraeteListe.add(new Gerät("Licht", 200));
        geraeteListe.add(new Gerät("Herd", 500));
        geraeteListe.add(new Gerät("Fernsehr", 10000));


        löschen = (Button) findViewById(R.id.btnLöschen);
        abbrechen2 = (Button) findViewById(R.id.btnAbbrechen2);
        //show = (ListView) findViewById(R.id.);



        //Button löschen - FUNKTION FEHLT
        löschen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Geraeteliste.this, Haushaltsgeraete.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG).show();
            }
        });


        abbrechen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Geraeteliste.this, Haushaltsgeraete.class);
                startActivity(intent);
            }
        });
    }

    public void addGeraet(Gerät g)
    {
        geraeteListe.add(g);
    }

    public ArrayList<Gerät> getList() {
        return geraeteListe;
    }

    public void getGeraete()
    {
        for(int i=0;i<geraeteListe.size();i++)
        {
            Log.d("Gerät", "onCreate: ART: " + geraeteListe.get(i).getArt() + "verbrauch: " +  geraeteListe.get(i).getVerbrauch());
            //System.out.println(geraeteListe.get(i).getArt());
            //list.append(geraeteListe.get(i).getArt());
        }
    }
}
