package com.example.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private ImageView animationTV;
    private Button startButton;
    private Button stopButton;
    private AnimationDrawable frameAnimation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        animationTV = findViewById(R.id.animImageView);
        startButton = findViewById(R.id.startBtn);
        stopButton = findViewById(R.id.stopBtn);

        frameAnimation = (AnimationDrawable) animationTV.getDrawable();

        showViewsWithAnimation(animationTV);
        showViewsWithAnimation(startButton);
        showViewsWithAnimation(stopButton);

        startButton.setOnClickListener(v -> {
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });

        stopButton.setOnClickListener(v -> {
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();
            }

        });


    }
    private void showViewsWithAnimation(View view) {
        view.setVisibility(View.VISIBLE);
        AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
        fadeIn.setDuration(2000);
        view.startAnimation(fadeIn);
    }

}