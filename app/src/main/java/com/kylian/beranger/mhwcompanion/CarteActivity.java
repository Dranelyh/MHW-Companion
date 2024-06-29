package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CarteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carte);
    }
    public void asteraClick(View view) {
        Intent intentAstera = new Intent(this , AsteraActivity.class);
        startActivity(intentAstera);
    }

    public void foretClick(View view) {
        Intent intentForet = new Intent(this , ForetActivity.class);
        startActivity(intentForet);
    }

    public void desertClick(View view) {
        Intent intentDesert = new Intent(this , DesertActivity.class);
        startActivity(intentDesert);
    }

    public void corailClick(View view) {
        Intent intentCorail = new Intent(this , CorailActivity.class);
        startActivity(intentCorail);
    }

    public void valClick(View view) {
        Intent intentVal = new Intent(this , ValActivity.class);
        startActivity(intentVal);
    }

    public void elderClick(View view) {
        Intent intentElder = new Intent(this , ElderActivity.class);
        startActivity(intentElder);
    }
}