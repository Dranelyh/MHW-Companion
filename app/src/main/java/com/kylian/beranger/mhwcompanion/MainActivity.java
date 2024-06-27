package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void bestiaireChemin(View view) {
        Intent intentBestiaire = new Intent(this, BestiaireActivity.class);
        startActivity(intentBestiaire);
    }

    public void carteChemin(View view) {
        Intent intentCarte = new Intent(this, CarteActivity.class);
        startActivity(intentCarte);
    }

    public void jeuChemin(View view) {
        Intent intentJeu = new Intent(this, JeuActivity.class);
        startActivity(intentJeu);
    }
}