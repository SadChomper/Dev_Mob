package com.example.mesure_glycemie.controller;

import com.example.mesure_glycemie.model.Patient;
public class Controller {
    public static Patient patient;
    public Controller(){
        super();
    }

    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        Patient patient1 = new Patient(20, 0.6f, true);
    }

    public String getReponse() {
        return patient.getReponse();
    }

    static Controller instance;
    public static final Controller getInstance(){
    if(Controller.instance == null)
    Controller.instance = new Controller();
    return Controller.instance;
    }
}