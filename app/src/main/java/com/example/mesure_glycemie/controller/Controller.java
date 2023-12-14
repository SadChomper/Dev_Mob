package com.example.mesure_glycemie.controller;

import com.example.mesure_glycemie.model.Patient;
public final class Controller {
    public static Patient afra;

    public Controller() { super(); }

    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        Patient afra = new Patient(20, 0.6f, true);
    }

    public String getReponse() {
        return afra.getReponse();
    }

    //Cette objet joue le rôle du singleton de la classe
    static Controller instance = null;
    //“getInstance()” est responsable à la création d'une seule instance de la classe Controller
    public static final Controller getInstance(){
    if(Controller.instance == null)
    Controller.instance = new Controller();
    return Controller.instance;
    }
}