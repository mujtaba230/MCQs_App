package com.example.mcqapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Find the ImageView
        ImageView centerImage = findViewById(R.id.centerImage);

        // Load fade-out animation
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        centerImage.startAnimation(fadeOut);

        // Move to the next activity after animation ends (2 sec delay)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); // Same duration as fade-out animation
    }
}