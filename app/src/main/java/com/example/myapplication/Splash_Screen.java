package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Splash_Screen extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(Splash_Screen.this , Menuler.class));

                }
            }
        }, 3000);


    }


    public void SıgnupButton(View view) {
        startActivity( new Intent(this , SignupScren.class ));
    }

    public void LogInButton(View view) {
        startActivity( new Intent(this , LoginScreen.class ));

    }
}