package com.example.mcqapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView userName, userScore;
    private Button shareButton;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        userName = findViewById(R.id.userName);
        userScore = findViewById(R.id.userScore);
        shareButton = findViewById(R.id.shareButton);
        backButton = findViewById(R.id.backButton);

        // Get user name and score from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("USER_NAME");
        int score = intent.getIntExtra("FINAL_SCORE", 0);
        int totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 10);

        // Set User Data
        userName.setText(name);
        userScore.setText(score + "/" + totalQuestions);

        // Share Button Click Listener
        shareButton.setOnClickListener(v -> {
            String shareText = name + " scored " + score + "/" + totalQuestions + " on the Quiz!";
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        });

        // Back Button Click Listener
        backButton.setOnClickListener(v -> {
            finish(); // Closes the Result Screen
        });
    }
}