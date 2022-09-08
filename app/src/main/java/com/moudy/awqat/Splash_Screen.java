package com.moudy.awqat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Screen extends AppCompatActivity {
    ImageView splash_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Animation FADE_IN = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        initViews();
        splash_logo.startAnimation(FADE_IN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, Steps.class);
                startActivity(intent);
                finish();


            }
        },3000);

    }

    private void initViews() {
        splash_logo=  findViewById(R.id.splashlogo);
    }
}