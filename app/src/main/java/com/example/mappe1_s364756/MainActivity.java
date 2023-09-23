package com.example.mappe1_s364756;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String antallSpm = "15";

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                antallSpm = data.getStringExtra("antallSpm");
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnStartGame = findViewById(R.id.buttonStartGame);
        Button btnAbout = findViewById(R.id.buttonAbout);
        Button btnPreferences = findViewById(R.id.buttonPreference);


        /*START SPILL*/
        btnStartGame.setOnClickListener(view -> {
            Intent startGameActivityIntent = new Intent(MainActivity.this, StartGame.class);
            startGameActivityIntent.putExtra("antallSpm", antallSpm);
            startActivity(startGameActivityIntent);
        });
        /*OM SPILLET*/
        btnAbout.setOnClickListener(view -> {
            Intent aboutActivityIntent = new Intent(MainActivity.this, About.class);

            startActivity(aboutActivityIntent);
        });
        /*INNSTILLINGER*/
        btnPreferences.setOnClickListener(view -> {
            Intent innstillingerActivityIntent = new Intent(MainActivity.this, Preferences.class);
            startActivityForResult(innstillingerActivityIntent, 1);
        });
    }
}