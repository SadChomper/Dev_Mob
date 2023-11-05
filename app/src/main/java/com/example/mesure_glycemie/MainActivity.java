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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Question1
    private TextView TVAge;
    private SeekBar sbAge;
    private RadioButton BtnOui;
    private RadioButton BtnNon;
    private EditText ETValMes;
    private Button BtnConsulter;
    private TextView text;

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
                int age = sbAge.getProgress();
                System.out.println("age =" + age);
                String valmesureSTR = (ETValMes.getText().toString());
                System.out.println("val =" + valmesureSTR);
                if (age == 0 && valmesureSTR.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Age and valeur mesure invalide", Toast.LENGTH_SHORT).show();
                } else if (age == 0) {
                    Toast.makeText(getApplicationContext(), "age invalide", Toast.LENGTH_SHORT).show();
                } else if (valmesureSTR.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " valeur mesure invalide", Toast.LENGTH_SHORT).show();
                } else {
                    float valmesure = Float.parseFloat(valmesureSTR);
                    boolean isFasting = BtnOui.isChecked();
                    System.out.println("is the user fasting? = " + isFasting);
                    if (isFasting) {
                        if (age > 13) {
                            if (valmesure >= 5.0 && valmesure <= 7.2) {
                                System.out.println("Niveau de glycémie est normale");
                                text.setText("Niveau de glycémie est normale");
                            } else if (valmesure < 5.0) {

                                System.out.println("Niveau de glycémie est trop bas");
                                text.setText("Niveau de glycémie est trop bas");
                            } else if (valmesure > 7.2) {
                                System.out.println("Niveau de glycémie est trop élevée");
                                text.setText("Niveau de glycémie est trop élevée");
                            }
                        } else if (age >= 6 && age <= 12) {
                            if (valmesure >= 5.0 && valmesure <= 10.0) {
                                System.out.println("Niveau de glycémie est normale");
                                text.setText("Niveau de glycémie est normale");
                            } else {
                                System.out.println("Niveau de glycémie est trop bas");
                                text.setText("Niveau de glycémie est trop bas");
                            }
                        } else if (age < 6) {
                            if (valmesure >= 5.5 && valmesure <= 10.0) {
                                System.out.println("Niveau de glycémie est normale");
                                text.setText("Niveau de glycémie est normale");
                            } else {
                                System.out.println("Niveau de glycémie est trop bas");
                                text.setText("Niveau de glycémie est trop bas");
                            }
                        }
                    } else {
                        if (valmesure < 10.5) {
                            System.out.println("Niveau de glycémie est normale");
                            text.setText("Niveau de glycémie est normale");
                        } else {
                            System.out.println("Niveau de glycémie est trop élevée");
                            text.setText("Niveau de glycémie est trop élevée");
                        }
                    }
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
       /*Question 4 (Méthode Implicite)
        public void calculer(View view) {
        // Obtenez la valeur de la glycémie entrée par l'utilisateur
        EditText ETValMes = findViewById(R.id.ETValMes);
        double valeurGlycemie = Double.parseDouble(ETValMes.getText().toString());
        // Vérifiez si le patient à jeuner ou non
        boolean estJeun = true;
        // Vérifiez les intervalles en fonction de l'âge
        if (estJeun) {
            if (valeurGlycemie >= 5.0 && valeurGlycemie <= 7.2) {
                Toast.maketext(getApplicationContext(), "Niveau de glycémie est normal").show();
            } else if (valeurGlycemie < 5.0) {
                Toast.maketext(getApplicationContext(), "Niveau de glycémie est trop bas").show();
            } else {
                Toast.maketext(getApplicationContext(), "Niveau de glycémie est trop élevée").show();
            }
        }
        else {
            if (valeurGlycemie < 10.5) {
                Toast.maketext(getApplicationContext(), "Niveau de glycémie est normal").show();
            } else {
                Toast.maketext(getApplicationContext(), "Niveau de glycémie est trop élevée").show();
            }
        }
    }
    */