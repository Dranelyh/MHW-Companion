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

public class LieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lieu);

        Intent appelant = getIntent();
        String lieu = appelant.getStringExtra("lieu");

        WebView location = findViewById(R.id.loc);
        location.setWebViewClient(new WebViewClient());
        location.loadUrl("https://monsterhunterworld.wiki.fextralife.com/" + lieu);
    }
}