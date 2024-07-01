package com.kylian.beranger.mhwcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScorePicActivity extends AppCompatActivity {

    TextView textScore;

    int score;
    int scoreMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score_pic);

        Intent appelant = getIntent();

        score = appelant.getIntExtra("s", -1);
        scoreMax = appelant.getIntExtra("sMax", -1);

        textScore = findViewById(R.id.textViewScore);

        if (score == 0 || score == 1) {
            textScore.setText("Tu as " + score + " bonne réponse sur " + scoreMax + ".");
        }
        else {
            textScore.setText("Tu as " + score + " bonnes réponses sur " + scoreMax + ".");
        }
    }

    public void retour(View view) {
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
    }
}