package com.example.dilarag.dontforgetapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Gerät extends Activity
{
    private String art;
    private double verbrauch;
    private Date datum=new Date();

    public Gerät(String art, double verbrauch) {
        this.art = art;
        this.verbrauch = verbrauch;
    }

    public Gerät() {}

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

    public String print(){
        return art + " : " + verbrauch + " kWH " + datum;
    }
}
