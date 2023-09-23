package com.example.mappe1_s364756;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

public class Preferences extends AppCompatActivity {

    private void savedPreferanser(int count){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("valgt-preferanse", count);
        editor.apply();
    }

    private void startGame(int count){
        Intent startSpillIntent = new Intent(this, StartGame.class);
        startSpillIntent.putExtra("valgt preferanse", count);
        startActivity(startSpillIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        //------------------VELG ANTALL SPØRSMÅL---------------------------------

        //Kode som tillater brukeren å bestemme om det skal være 5, 10 eller 15 spørsmål i spillet
        Button btn_5questions = findViewById(R.id.btn_5questions);
        Button btn_10questions = findViewById(R.id.btn_10questions);
        Button btn_15questions = findViewById(R.id.btn_15questions);



        btn_5questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedPreferanser(5);
                startGame(5);

            }
        });

        btn_10questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedPreferanser(10);
                startGame(10);
            }
        });

        btn_15questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedPreferanser(15);
                startGame(15);
            }
        });



        //--------------------VELG SPRÅK---------------------------------------------------

        //Kode som tillater brukeren å bestemme om appen skal være på norsk eller tysk
        Button btn_norwegian = findViewById(R.id.btn_norwegian);
        Button btn_german = findViewById(R.id.btn_german);
        btn_norwegian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("no-NO");
                AppCompatDelegate.setApplicationLocales(appLocale);
            }
        });

        btn_german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("de-DE");
                AppCompatDelegate.setApplicationLocales(appLocale);
            }
        });

    };


}