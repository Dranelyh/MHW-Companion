package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BestiaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bestiaire);
    }

    public void lien(View view) {
        String monster = view.getTag().toString();

        Intent intentMonstre = new Intent(this, MonstreActivity.class);
        intentMonstre.putExtra("monstre", monster);
        startActivity(intentMonstre);
    }
}