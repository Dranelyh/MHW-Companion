package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MonstreActivity extends AppCompatActivity {
//"https://monsterhunterworld.wiki.fextralife.com/"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_monstre);

        Intent appelant = getIntent();
        String monstre = appelant.getStringExtra("monstre");

        WebView wiki = findViewById(R.id.wiki);
        wiki.setWebViewClient(new WebViewClient());
        wiki.loadUrl("https://monsterhunterworld.wiki.fextralife.com/" + monstre);
    }
}