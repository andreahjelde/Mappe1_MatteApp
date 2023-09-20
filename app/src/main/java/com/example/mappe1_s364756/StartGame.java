package com.example.mappe1_s364756;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class StartGame extends AppCompatActivity {
    TextView printOppgave, printArraySvar, feedback, inputNumber;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSvar;
    String tall;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);


        //Henting av string_array
        Resources res = getResources();
        String[] array_oppgaver = res.getStringArray(R.array.array_oppgaver);
        String[] array_oppgaver_svar = res.getStringArray(R.array.array_oppgaver_svar);
        String wrongAnswer = res.getString(R.string.wrongAnswer);
        String rightAnswer = res.getString(R.string.rightAnswer);

        //henting av textView
        printOppgave = (TextView) findViewById(R.id.array_oppgaver);
        printArraySvar = (TextView) findViewById(R.id.array_oppgaver_svar);
        inputNumber = (TextView) findViewById(R.id.inputNumber);
        feedback = (TextView) findViewById(R.id.feedback);


        //henting av innholdet til Button
        btn0 = (Button) findViewById(R.id.btn_tall0);
        btn1 = (Button) findViewById(R.id.btn_tall1);
        btn2 = (Button) findViewById(R.id.btn_tall2);
        btn3 = (Button) findViewById(R.id.btn_tall3);
        btn4 = (Button) findViewById(R.id.btn_tall4);
        btn5 = (Button) findViewById(R.id.btn_tall5);
        btn6 = (Button) findViewById(R.id.btn_tall6);
        btn7 = (Button) findViewById(R.id.btn_tall7);
        btn8 = (Button) findViewById(R.id.btn_tall8);
        btn9 = (Button) findViewById(R.id.btn_tall9);
        btnSvar = (Button) findViewById(R.id.btn_svar);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "0";
                inputNumber.setText(tall);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "1";
                inputNumber.setText(tall);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "2";
                inputNumber.setText(tall);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "3";
                inputNumber.setText(tall);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "4";
                inputNumber.setText(tall);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "5";
                inputNumber.setText(tall);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "6";
                inputNumber.setText(tall);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "7";
                inputNumber.setText(tall);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "8";
                inputNumber.setText(tall);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tall = inputNumber.getText().toString();
                tall = tall + "9";
                inputNumber.setText(tall);
            }
        });

        //Kode som printer ut første indeks til string_array inn i tekstfeltet
        printOppgave.setText(String.valueOf(array_oppgaver[0]));

        //Når svar-knappen trykkes blir det gjort en sjekk om svaret til brukeren samsvarer med svaret som ligger i listen
        //Om svaret er riktig får brukeren tilbakemelding om at det er riktig
        //Om svaret er feil, får brukeren tilbakemelding om at svaret er feil (og hva som er riktig svar)
        //Deretter settes inputf-feltet til null, og man får et nytt tilfledig spørsmål
        btnSvar.setOnClickListener(new View.OnClickListener() {
            Integer question = 0;
            @Override
            public void onClick(View view) {
                question = new Random().nextInt(array_oppgaver.length) ;

                    if(!inputNumber.getText().toString().equals(array_oppgaver_svar[question])){
                        Toast.makeText(getApplicationContext(),wrongAnswer + (array_oppgaver_svar[question]), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),rightAnswer, Toast.LENGTH_SHORT).show();
                    }




                    inputNumber.setText(null);

                    printOppgave.setText(String.valueOf(array_oppgaver[question]));



            }
        });
    };
}
