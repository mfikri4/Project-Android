package com.example.go_ruqyah.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.go_ruqyah.R;

public class Splashscreen extends AppCompatActivity {

    private int waktu_loading=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent landingpage=new Intent(Splashscreen.this, Signin.class);
                startActivity(landingpage);
                finish();
            }
        },waktu_loading);
    }
}