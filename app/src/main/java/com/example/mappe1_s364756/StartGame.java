package com.example.mappe1_s364756;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class StartGame extends AppCompatActivity {
    Random rng = new Random();
    int count = 0;
    int runde = 1;
    int antallSpm = 15;
    TextView printOppgave, printArraySvar, feedback, inputNumber, points;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSvar;
    String tall;
    Button[] knapper;
    String[] array_oppgaver ;
    String[] array_oppgaver_svar;
    String wrongAnswer;
    String rightAnswer;
    ArrayList<Integer> listeMedIndex = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);

        initialiserUiElementer();
        leggTilListenerPaaKnapper();
        leggTilListenerPaaSvarknapp();

        hentAntallSpm();
        genererSpm();

        startSpill();
    }

    public void initialiserUiElementer(){
        Resources res = getResources();
        //henting av textView
        printOppgave = (TextView) findViewById(R.id.array_oppgaver);
        printArraySvar = (TextView) findViewById(R.id.array_oppgaver_svar);
        inputNumber = (TextView) findViewById(R.id.inputNumber);
        feedback = (TextView) findViewById(R.id.feedback);
        points = (TextView) findViewById(R.id.points);
        array_oppgaver = res.getStringArray(R.array.array_oppgaver);
        array_oppgaver_svar = res.getStringArray(R.array.array_oppgaver_svar);
        wrongAnswer = res.getString(R.string.wrongAnswer);
        rightAnswer = res.getString(R.string.rightAnswer);

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

        knapper = new Button[]{btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
    }
    private void leggTilListenerPaaKnapper() {
        for (int i = 0; i< knapper.length; i++){
            int knappetekst = i;
            knapper[i].setOnClickListener(view -> {
                tall = inputNumber.getText().toString();
                tall += knappetekst;
                inputNumber.setText(tall);
            });
        }
    }
    private void leggTilListenerPaaSvarknapp() {
        btnSvar.setOnClickListener(view -> {
            boolean svarErRiktig = inputNumber.getText().toString().equals(array_oppgaver_svar[listeMedIndex.get(count)]);
            if(!svarErRiktig){
                //Om svaret er riktig får brukeren tilbakemelding om at det er riktig
                Toast.makeText(getApplicationContext(),wrongAnswer + (array_oppgaver_svar[listeMedIndex.get(count)]), Toast.LENGTH_SHORT).show();
            }
            else {
                //Om svaret er feil, får brukeren tilbakemelding om at svaret er feil (og hva som er riktig svar)
                Toast.makeText(getApplicationContext(),rightAnswer, Toast.LENGTH_SHORT).show();
            }
            boolean gameIsDone = runde == antallSpm;
            if(gameIsDone){
                setGamestateDone();
                return;
            }
            nextRound();

        });
    }
    private void hentAntallSpm() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                antallSpm = Integer.parseInt(extras.getString("antallSpm"));
            }catch (Exception ex) {
                Log.e("CAST_EXTRAS_START_G", ex.toString());
            }
        }
    }
    public int getRandomWithExclusion(int start, int end, ArrayList<Integer> exclude) {
        int random = start + rng.nextInt(end - start + 1 - exclude.size());
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
    private void genererSpm() {
        for(int i = 0; i < antallSpm; i++){
            listeMedIndex.add(getRandomWithExclusion(0, array_oppgaver.length-1, listeMedIndex));
        }
    }
    public void nextRound(){
        inputNumber.setText(null);
        count++;
        runde++;

        printOppgave.setText(String.valueOf(array_oppgaver[listeMedIndex.get(count)]));
        points.setText("Runde: " + runde);
    }
    public void startSpill(){
        printOppgave.setText(String.valueOf(array_oppgaver[listeMedIndex.get(count)]));
        points.setText("Runde: " + runde);
    }

    public void setGamestateDone(){
        inputNumber.setText("SPILLET ER FERDIG");
        printOppgave.setText(null);
        Toast.makeText(getApplicationContext(),"Spillet er ferdig", Toast.LENGTH_SHORT).show();
    }


}
