package com.example.td3_ahmed_guizani;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH8SCREEN8TIMEOUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //rediriger vers la liste des pokemon apres 5 secondes

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // passer a la fragment de list des pokemon
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH8SCREEN8TIMEOUT);

    }
}
