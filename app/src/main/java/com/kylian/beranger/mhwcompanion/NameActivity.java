package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class NameActivity extends AppCompatActivity {

    public int i = 0;

    Quiz quiz;


    TextView textViewMonstre;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    Hashtable dicoMonstres = new Hashtable();

    Vector<Integer> listeMonstres = new Vector<Integer>();


    int score;
    int scoreMax;

    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_name);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

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

            Intent intentScore = new Intent(this, ScoreNameActivity.class);

            intentScore.putExtra("s", score);
            intentScore.putExtra("sMax", scoreMax);

            startActivity(intentScore);

        }
        else {

            textViewMonstre = findViewById(R.id.textViewMonstre);

            textViewMonstre.setText((String)dicoMonstres.get(quiz.getMonstres().get(i)));

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

            for (int k=0; k<4; k++) {
                if (propositions.get(k).equals(quiz.getMonstres().get(i))) {
                    a=k;
                }

            }

            imageView1.setImageResource(propositions.get(0));
            imageView2.setImageResource(propositions.get(1));
            imageView3.setImageResource(propositions.get(2));
            imageView4.setImageResource(propositions.get(3));

        }

    }
    public void aRepondu(View v) {

        if (v.getTag().equals("" + a)) {
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