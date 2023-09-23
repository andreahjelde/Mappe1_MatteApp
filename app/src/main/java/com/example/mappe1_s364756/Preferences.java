package com.example.mappe1_s364756;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

public class Preferences extends AppCompatActivity {
    private int antallSpm = 5;

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("antallSpm", antallSpm+"");
        setResult(RESULT_OK, intent);
        finish();
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        //------------------VELG ANTALL SPØRSMÅL---------------------------------

        //Kode som tillater brukeren å bestemme om det skal være 5, 10 eller 15 spørsmål i spillet
        Button btn_5questions = findViewById(R.id.btn_5questions);
        Button btn_10questions = findViewById(R.id.btn_10questions);
        Button btn_15questions = findViewById(R.id.btn_15questions);

        btn_5questions.setOnClickListener(view -> antallSpm= 5);

        btn_10questions.setOnClickListener(view -> antallSpm = 10);

        btn_15questions.setOnClickListener(view -> antallSpm = 15);



        //--------------------VELG SPRÅK---------------------------------------------------

        //Kode som tillater brukeren å bestemme om appen skal være på norsk eller tysk
        Button btn_norwegian = findViewById(R.id.btn_norwegian);
        Button btn_german = findViewById(R.id.btn_german);
        btn_norwegian.setOnClickListener(view -> {
            LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("no-NO");
            AppCompatDelegate.setApplicationLocales(appLocale);
        });

        btn_german.setOnClickListener(view -> {
            LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("de-DE");
            AppCompatDelegate.setApplicationLocales(appLocale);
        });

    };


}