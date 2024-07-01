package com.kylian.beranger.mhwcompanion;

import java.util.Vector;
import java.util.Hashtable;


public class Question {

    private Hashtable dicoMonstres;
    private int monstre;
    private int bonneReponse;
    private Vector<Integer> mauvaisesReponses;

    public Question(int monstre, Hashtable monstreHashtable) {

        dicoMonstres = monstreHashtable;

        this.monstre = monstre;

        this.bonneReponse = (Integer)dicoMonstres.get(monstre);

        mauvaisesReponses = new Vector<Integer>();
    }

    public int  getMonstre() {
        return monstre;
    }
    public int getBonneReponse() {
        return bonneReponse;
    }
    public Vector<Integer> getMauvaisesReponses() {
        return mauvaisesReponses;
    }
    public void setMonstre(Integer monstre) {
        this.monstre = monstre;
    }
    public void setBonneReponse(Integer bonneReponse) {
        this.bonneReponse = bonneReponse;
    }
}