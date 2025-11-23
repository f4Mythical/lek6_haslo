package com.example.zadanie;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    public EditText TekstEmail;
    public EditText TekstHaslo;
    public EditText TekstSprawdz;

    public Button ButtonZatwierdz;
    public Button ButtonWygenerujHaslo;
    public Button ButtonSprawdzMoc;


    public TextView TekstDuzeLitery;
    public TextView TekstMaleLitery;
    public TextView TekstSpecjalne;
    public TextView TekstCyfry;
    public TextView TekstDlugosc;
    public TextView TekstZmien;
    public TextView Email;
    public TextView TextPow;

    public String duze = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public String male = "qwertyuiopasdfghjklzxcvbnm";
    public String specjalne = "!@#$%^&*(){}|[]<>,./?-=_+`";
    public String liczby = "1234567890";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TekstEmail = findViewById(R.id.editTextEmail);
        TekstHaslo = findViewById(R.id.editTextPassword);
        TekstSprawdz = findViewById(R.id.editTextRepeatPassword);
        ButtonZatwierdz = findViewById(R.id.buttonRegister);
        ButtonWygenerujHaslo = findViewById(R.id.buttonRandom);
        ButtonSprawdzMoc = findViewById(R.id.buttonPower);

        TekstDuzeLitery = findViewById(R.id.UpperCase);
        TekstMaleLitery = findViewById(R.id.LowerCase);
        TekstSpecjalne = findViewById(R.id.Special);
        TekstCyfry = findViewById(R.id.Number);
        TekstDlugosc = findViewById(R.id.Lenght);
        TekstZmien = findViewById(R.id.textViewCheck);
        Email = findViewById(R.id.textEmail);
        TextPow = findViewById(R.id.textPow);

        ButtonZatwierdz.setOnClickListener(new MainZatwierdz(this));
        ButtonSprawdzMoc.setOnClickListener(new MainSprawdzMoc(this));
        ButtonWygenerujHaslo.setOnClickListener(new GenerowanieHasla(this));
    }
}
