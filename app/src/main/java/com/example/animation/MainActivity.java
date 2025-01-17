package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View buttonFrameAnimation = findViewById(R.id.button2);
        View buttonTweenAnimation = findViewById(R.id.button3);

        slideIn(buttonFrameAnimation);
        slideIn(buttonTweenAnimation);
    }

    public void ToFrameAnimation(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

    public void ToTweenAnimation(View v) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);

    }

    private void slideIn(View view) {
        view.setVisibility(View.VISIBLE);
        TranslateAnimation slide = new TranslateAnimation(

                Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);

        slide.setDuration(500);
        view.startAnimation(slide);
    }
}