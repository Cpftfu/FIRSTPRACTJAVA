package com.example.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private ImageView img;
    private Button Start;
    private Button Stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img=findViewById(R.id.img_blink);
        Start=findViewById(R.id.startBtn);
        Stop=findViewById(R.id.stopBtn);

        rotateIn(img);
        rotateIn(Start);
        rotateIn(Stop);

        Animation blinkAnimation= AnimationUtils.loadAnimation(this,R.anim.blink);//

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {img.startAnimation(blinkAnimation);}
        });


        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.clearAnimation();
            }

        });

    }
    private void rotateIn(View view) {
        view.setVisibility(View.VISIBLE);
        RotateAnimation rotate = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        view.startAnimation(rotate);
    }
}