package com.example.zadanie;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText TekstEmail;
    private EditText TekstHaslo;
    private EditText TekstSprawdz;
    private Button ButttonZatwierdz;

    private Button ButtonWygenerujHaslo;
    private Button ButtonSprawdzMoc;
    private TextView TekstDuzeLitery;
    private TextView TekstMaleLitery;
    private TextView TekstSpecjalne;
    private TextView TekstCyfry;
    private TextView TekstDlugosc;
    private TextView TekstZmien;
    private TextView Email;
    private TextView TextPow;
    String haslo;
    String email;
    String hasloPow;
    private String duze = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private String male = "qwertyuiopasdfghjklzxcvbnm";
    private String specjalne = "!@#$%^&*(){}|[]<>,./?-=_+`";
    private String liczby = "1234567890";

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

        TekstEmail = findViewById(R.id.editTextEmail);
        TekstHaslo = findViewById(R.id.editTextPassword);
        TekstSprawdz = findViewById(R.id.editTextRepeatPassword);
        ButttonZatwierdz = findViewById(R.id.buttonRegister);
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
        ButttonZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                haslo = TekstHaslo.getText().toString();
                hasloPow = TekstSprawdz.getText().toString();
                email = TekstEmail.getText().toString();
                if (email.contains("@")) {
                    Email.setText("Dobry email");

                }
                if(haslo.contains(hasloPow)) {
                TextPow.setText("Dziala");
                } else {
                    TextPow.setText("Nie dziala");
                }

                int poprawne = 0;
                for (int i = 0; i < haslo.length(); i++) {
                    if (duze.contains(""+haslo.charAt(i))) {
                        poprawne++;
                        break;
                    }

                }
                for (int i = 0; i < haslo.length(); i++) {
                    if (male.contains(""+haslo.charAt(i))) {
                        poprawne++;
                        break;
                    }
                }
                for (int i = 0; i < haslo.length(); i++) {
                    if (liczby.contains(""+haslo.charAt(i))) {
                        poprawne++;
                        break;
                    }
                }
                for (int i = 0; i < haslo.length(); i++) {
                    if (specjalne.contains(""+haslo.charAt(i))) {
                        poprawne++;
                        break;
                    }
                }
                if (haslo.length() >= 8) {
                    poprawne++;
                }
                if (poprawne == 5) {
                    TekstZmien.setText("Poprawne");
                } else {
                    TekstZmien.setText("Niepoprawne");
                }

            }
        });

        ButtonSprawdzMoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            haslo = TekstHaslo.getText().toString();

            boolean czyDuzaLitera = false;
                for (int i = 0; i < haslo.length(); i++) {
                if (duze.contains("" + haslo.charAt(i))) {
                    czyDuzaLitera = true;
                    break;
                }
            }
                if (czyDuzaLitera) {
                TekstDuzeLitery.setTextColor(Color.GREEN);
            } else {
                TekstDuzeLitery.setTextColor(Color.RED);
            }

            boolean czyMalaLitera = false;
                for (int i = 0; i < haslo.length(); i++) {
                if (male.contains("" + haslo.charAt(i))) {
                    czyMalaLitera = true;
                    break;
                }
            }
                if (czyMalaLitera) {
                TekstMaleLitery.setTextColor(Color.GREEN);
            } else {
                TekstMaleLitery.setTextColor(Color.RED);
            }

            boolean czyCyfra = false;
                for (int i = 0; i < haslo.length(); i++) {
                if (liczby.contains("" + haslo.charAt(i))) {
                    czyCyfra = true;
                    break;
                }
            }
                if (czyCyfra) {
                TekstCyfry.setTextColor(Color.GREEN);
            } else {
                TekstCyfry.setTextColor(Color.RED);
            }

            boolean czySpecjalny = false;
                for (int i = 0; i < haslo.length(); i++) {
                if (specjalne.contains("" + haslo.charAt(i))) {
                    czySpecjalny = true;
                    break;
                }
            }
                if (czySpecjalny) {
                TekstSpecjalne.setTextColor(Color.GREEN);
            } else {
                TekstSpecjalne.setTextColor(Color.RED);
            }

                if (haslo.length() >= 8) {
                TekstDlugosc.setTextColor(Color.GREEN);
            } else {
                TekstDlugosc.setTextColor(Color.RED);
            }
        }
        });
        ButtonWygenerujHaslo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Podaj długość hasła")
                        .setView(input)
                        .setPositiveButton("OK", (dialog, which) -> {

                            String tekst = input.getText().toString();
                            if (!tekst.isEmpty()) {

                                int dlugosc = Integer.parseInt(tekst);

                                String all = duze + male + specjalne + liczby;

                                Random random = new Random();

                                ArrayList<Integer> ciag = new ArrayList<>();
                                for (int i = 0; i < dlugosc; i++) {
                                    ciag.add(i);
                                }

                                ArrayList<Integer> wyjatki = new ArrayList<>();
                                wyjatki.add(1);
                                wyjatki.add(2);
                                wyjatki.add(3);
                                wyjatki.add(4);

                                char[] wynik = new char[dlugosc];

                                for (int x = 0; x < wyjatki.size(); x++) {

                                    int typ = wyjatki.get(x);
                                    int index = random.nextInt(ciag.size());
                                    int pozycja = ciag.get(index);
                                    ciag.remove(index);

                                    switch (typ) {
                                        case 1:
                                            wynik[pozycja] = duze.charAt(random.nextInt(duze.length()));
                                            break;
                                        case 2:
                                            wynik[pozycja] = male.charAt(random.nextInt(male.length()));
                                            break;
                                        case 3:
                                            wynik[pozycja] = specjalne.charAt(random.nextInt(specjalne.length()));
                                            break;
                                        case 4:
                                            wynik[pozycja] = liczby.charAt(random.nextInt(liczby.length()));
                                            break;
                                    }
                                }

                                for (int pos : ciag) {
                                    wynik[pos] = all.charAt(random.nextInt(all.length()));
                                }

                                String haslo = new String(wynik);
                                TekstZmien.setText(haslo);
                            }
                        })
                        .setNegativeButton("Anuluj", null)
                        .show();
            }
        });

    }
}