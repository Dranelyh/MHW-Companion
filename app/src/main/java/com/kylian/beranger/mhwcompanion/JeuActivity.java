package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JeuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jeu);
    }

    public void lancerJeuPic(View view) {

        Intent intentPic = new Intent(this, PicActivity.class);

        startActivity(intentPic);
    }

    public void lancerJeuName(View view) {

        Intent intentName = new Intent(this, NameActivity.class);

        startActivity(intentName);
    }
}