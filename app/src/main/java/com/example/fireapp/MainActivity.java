package com.example.fireapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import static com.example.fireapp.R.id.fragment;

public class MainActivity extends AppCompatActivity {
    private Button b;
//    private static int SPLASH_TIME_OUT =3000;
//  View fragment = findViewById(R.id.fragment);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b= findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Splash.class);
                startActivity(intent);
            }
        });
//        fragment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,Home.class);
//                startActivity(intent);
//            }

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this,Home.class);
//                startActivity(intent);
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                finish();
//            }
//        },SPLASH_TIME_OUT);
//        });
    }
}
