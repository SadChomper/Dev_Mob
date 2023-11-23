package com.example.mesure_glycemie.vue;

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
import android.widget.Toast;

import com.example.mesure_glycemie.R;
import com.example.mesure_glycemie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    //Question1
    private TextView TVAge;
    private SeekBar sbAge;
    private RadioButton BtnOui;
    private RadioButton BtnNon;
    private EditText ETValMes;
    private Button BtnConsulter;
    private TextView text;
    private Controller controller = Controller.getInstance();

    //Question 2
    private void init() {
        TVAge = findViewById(R.id.TVAge);
        sbAge = findViewById(R.id.sbAge);
        BtnOui = findViewById(R.id.BtnOui);
        BtnNon = findViewById(R.id.BtnNon);
        ETValMes = findViewById(R.id.ETValMes);
        BtnConsulter = findViewById(R.id.BtnConsulter);
        text = findViewById(R.id.text);
        //Question 3
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                // affichage dans le Log de Android studio pour voir les changements détectés sur le SeekBar ..
                TVAge.setText("Votre âge : " + progress);
                // Mise à jour du TextView par la valeur: progress à chaque changement.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        BtnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Information", "button cliqué");
                int age;
                float valeurMesuree;
                boolean verifAge = false, verifValeur = false;
                if(sbAge.getProgress()!=0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre age: ",
                            Toast.LENGTH_SHORT).show();
                if(!ETValMes.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée: ",
                            Toast.LENGTH_LONG).show();
                if(verifAge && verifValeur)
                {
                    age = sbAge.getProgress();
                    valeurMesuree = Float.valueOf(ETValMes.getText().toString());
                    //Flèche "User action" Vue --> Controller
                    controller.createPatient(age, valeurMesuree, BtnOui.isChecked());
                    //Flèche "Update" Controller --> vue
                    text.setText(controller.getReponse());
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}