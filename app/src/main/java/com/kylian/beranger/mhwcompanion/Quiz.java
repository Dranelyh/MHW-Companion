package com.kylian.beranger.mhwcompanion;

import java.util.Vector;
public class Quiz {


    private Vector<Integer> monstres;
    private Vector<Question> questionsPic;


    public Quiz(int monstre1, int monstre2, int monstre3, int monstre4, int monstre5) {

        this.monstres = new Vector<Integer>();

        this.monstres.add(monstre1);
        this.monstres.add(monstre2);
        this.monstres.add(monstre3);
        this.monstres.add(monstre4);
        this.monstres.add(monstre5);


        this.questionsPic = new Vector<Question>();
    }

    public Vector<Integer> getMonstres() {
        return monstres;
    }

    public int getSize() {
        return monstres.size();
    }
}
