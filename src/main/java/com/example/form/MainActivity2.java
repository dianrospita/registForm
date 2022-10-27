package com.example.form;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

    public class MainActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("RESULT");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            Intent intent = getIntent();
            String nama = intent.getStringExtra("NAMA");
            String tempat = intent.getStringExtra("TEMPAT");
            String lahir = intent.getStringExtra("LAHIR");
            TextView nnama = findViewById(R.id.fnama1);
            TextView ntempat= findViewById(R.id.ftempat1);
            TextView nlahir = findViewById(R.id.flahir1);
            nnama.setText(nama);
            ntempat.setText(tempat);
            nlahir.setText(lahir);
        }
    }