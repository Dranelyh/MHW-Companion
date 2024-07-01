package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class PicActivity extends AppCompatActivity {
    public int i = 0;

    Quiz quiz;


    ImageView iconeMonstre;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    Hashtable dicoMonstres = new Hashtable();

    Vector<Integer> listeMonstres = new Vector<Integer>();


    int score;
    int scoreMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pic);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        dicoMonstres.put(R.drawable.anjanath, "Anjanath");
        dicoMonstres.put(R.drawable.barroth, "Barroth");
        dicoMonstres.put(R.drawable.bazelgeuse, "Bazelgeuse");
        dicoMonstres.put(R.drawable.bazelgeuse_seething, "Bazelgeuse Vulcan");
        dicoMonstres.put(R.drawable.behemoth, "Behemoth");
        dicoMonstres.put(R.drawable.deviljho, "Deviljho");
        dicoMonstres.put(R.drawable.deviljho_savage, "Deviljho Carnage");
        dicoMonstres.put(R.drawable.diablos, "Diablos");
        dicoMonstres.put(R.drawable.diablos_black, "Diablos Noir");
        dicoMonstres.put(R.drawable.dodogama, "Dodogama");
        dicoMonstres.put(R.drawable.greatgirros, "Grand Girros");
        dicoMonstres.put(R.drawable.greatjagras, "Grand Jagras");
        dicoMonstres.put(R.drawable.jyuratodus, "Jyuratodus");
        dicoMonstres.put(R.drawable.kirin, "Kirin");
        dicoMonstres.put(R.drawable.kuluyaku, "Kulu-Ya-Ku");
        dicoMonstres.put(R.drawable.kulvetaroth, "Kulve Taroth");
        dicoMonstres.put(R.drawable.kushala, "Kushala Daora");
        dicoMonstres.put(R.drawable.lavasioth, "Lavasioth");
        dicoMonstres.put(R.drawable.legiana, "Legiana");
        dicoMonstres.put(R.drawable.lunastra, "Lunastra");
        dicoMonstres.put(R.drawable.nergigante, "Nergigante");
        dicoMonstres.put(R.drawable.odogaron, "Odogaron");
        dicoMonstres.put(R.drawable.paolumu, "Paolumu");
        dicoMonstres.put(R.drawable.pukeipukei, "Pukei-Pukei");
        dicoMonstres.put(R.drawable.radobaan, "Radobaan");
        dicoMonstres.put(R.drawable.rathalos, "Rathalos");
        dicoMonstres.put(R.drawable.rathalos_azure, "Rathalos Azur");
        dicoMonstres.put(R.drawable.rathian, "Rathian");
        dicoMonstres.put(R.drawable.rathian_pink, "Rathian Rose");
        dicoMonstres.put(R.drawable.teostra, "Teostra");
        dicoMonstres.put(R.drawable.tobikadachi, "Tobi-Kadachi");
        dicoMonstres.put(R.drawable.tzitziyaku, "Tzitzi-Ya-Ku");
        dicoMonstres.put(R.drawable.uragaan, "Uragaan");
        dicoMonstres.put(R.drawable.vaalhazak, "Vaal Hazak");
        dicoMonstres.put(R.drawable.vaalhazak_blackveil, "Vaal Hazak Fléau");
        dicoMonstres.put(R.drawable.xenojiiva, "Xeno'jiiva");
        dicoMonstres.put(R.drawable.zorahmag, "Zorah Magdaros");


        for (Object key : dicoMonstres.keySet()){
            listeMonstres.add((Integer)key);
        }

        Collections.shuffle(listeMonstres);
        quiz = new Quiz(listeMonstres.get(0), listeMonstres.get(1), listeMonstres.get(2), listeMonstres.get(3), listeMonstres.get(4));

        score = 0;
        scoreMax = quiz.getSize();

        initialisation();
    }

    public void initialisation() {

        if (i==quiz.getSize()) {

            Intent intentScore = new Intent(this, ScorePicActivity.class);

            intentScore.putExtra("s", score);
            intentScore.putExtra("sMax", scoreMax);

            startActivity(intentScore);

        }
        else {

            iconeMonstre = findViewById(R.id.imageViewMonstre);

            iconeMonstre.setImageResource(quiz.getMonstres().get(i));

            Vector<Integer> propositions = new Vector<>();
            propositions.add(quiz.getMonstres().get(i));
            Collections.shuffle(listeMonstres);
            for (int k=0; k<3; k++) {
                if (!(listeMonstres.get(k).equals(quiz.getMonstres().get(i)))) {
                    propositions.add(listeMonstres.get(k));
                }
                else {
                    propositions.add(listeMonstres.get(3));
                }
            }
            Collections.shuffle(propositions);

            button1.setText((String)dicoMonstres.get(propositions.get(0)));
            button2.setText((String)dicoMonstres.get(propositions.get(1)));
            button3.setText((String)dicoMonstres.get(propositions.get(2)));
            button4.setText((String)dicoMonstres.get(propositions.get(3)));

        }

    }
    public void aRepondu(View v) {

        if ( ((Button) v).getText().equals(dicoMonstres.get(quiz.getMonstres().get(i)))) {
            Toast.makeText(getApplicationContext(), "Bravo !", Toast.LENGTH_SHORT).show();
            score = score + 1;
        }

        else {
            Toast.makeText(getApplicationContext(), "Ce n'est pas le bon monstre...", Toast.LENGTH_SHORT).show();
        }

        i = i + 1;

        initialisation();
    }
}