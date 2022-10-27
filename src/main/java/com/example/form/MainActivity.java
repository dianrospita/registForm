package com.example.form;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    //inisialisasi
    EditText edt_nama,edt_tempat,edt_lahir;
    Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Form");
        final EditText editnama = findViewById(R.id.edt_nama);
        final EditText edittempat = findViewById(R.id.edt_tempat);
        final EditText editlahir = findViewById(R.id.edt_lahir);

        edt_nama = findViewById(R.id.edt_nama);
        edt_tempat = findViewById(R.id.edt_tempat);
        edt_lahir = findViewById(R.id.edt_lahir);
        btn_1 = findViewById(R.id.btn_1);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        edt_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        edt_lahir.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String nama=edt_nama.getText().toString();
                String tempat=edt_tempat.getText().toString();
                String lahir=edt_lahir.getText().toString();

                boolean check= validateInfo(nama,tempat,lahir);
                if(check==true){
                    Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("NAMA",nama);
                    intent.putExtra("TEMPAT",tempat);
                    intent.putExtra("LAHIR",lahir);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Data tidak valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean validateInfo(String nama, String tempat, String lahir){
        if(nama.length()==0){
            edt_nama.requestFocus();
            edt_nama.setError("Nama harus diisi");
            return false;
        }
        else if (!nama.matches("[a-zA-Z]+")){
            edt_nama.requestFocus();
            edt_nama.setError("Nama hanya berisi huruf");
            return false;
        }
        else if (tempat.length()==0){
            edt_tempat.requestFocus();
            edt_tempat.setError("Tempat lahir harus diisi");
            return false;
        }
        else if (lahir.length()==0){
            edt_lahir.requestFocus();
            edt_lahir.setError("Tanggal lahir harus diisi");
            return false;
        }
        else{
            return true;
        }
    }
}