package com.example.mesure_glycemie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Question1
    private TextView TVAge;
    private SeekBar sbAge;
    private RadioButton BtnOui;
    private RadioButton BtnNon;
    private EditText ETValMes;
    private Button BtnConsulter;

    //Question 2
    private void init()
    {
        TVAge = findViewById(R.id.TVAge);
        sbAge = findViewById(R.id.sbAge);
        BtnOui = findViewById(R.id.BtnOui);
        BtnNon = findViewById(R.id.BtnNon);
        ETValMes = findViewById(R.id.ETValMes);
        BtnConsulter = findViewById(R.id.BtnConsulter);
    }
    //Question 4 (Méthode Implicite)
    public void calculer(View view)
    {
        // Ajoutez votre code ici pour gérer l'événement de clic sur le bouton Consulter
        // Cette méthode sera déclenchée lorsque le bouton est cliqué
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //Question 3
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                Log.i("Information", "onProgressChanged "+progress);
                // affichage dans le Log de Android studio pour voir les changements détectés sur le SeekBar ..
                TVAge.setText("Votre âge : "+ progress);
                // Mise à jour du TextView par la valeur: progress à chaque changement.
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        /*Question 5 (Méthode Excplicite)
        BtnConsulter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Ajoutez votre code ici pour gérer l'événement de clic sur le bouton Consulter
                // Cette méthode sera déclenchée lorsque le bouton est cliqué
            }
        });
         */
    }
}