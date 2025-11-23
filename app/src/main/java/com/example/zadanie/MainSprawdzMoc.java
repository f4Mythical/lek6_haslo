package com.example.zadanie;

import android.graphics.Color;
import android.view.View;
import com.example.zadanie.MainActivity;

public class MainSprawdzMoc implements View.OnClickListener {

    private MainActivity activity;

    public MainSprawdzMoc(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        String haslo = activity.TekstHaslo.getText().toString();

        boolean czyDuzaLitera = false;
        for (int i = 0; i < haslo.length(); i++) {
            if (activity.duze.contains("" + haslo.charAt(i))) {
                czyDuzaLitera = true;
                break;
            }
        }
        if (czyDuzaLitera) {
            activity.TekstDuzeLitery.setTextColor(Color.GREEN);
        } else {
            activity.TekstDuzeLitery.setTextColor(Color.RED);
        }

        boolean czyMalaLitera = false;
        for (int i = 0; i < haslo.length(); i++) {
            if (activity.male.contains("" + haslo.charAt(i))) {
                czyMalaLitera = true;
                break;
            }
        }
        if (czyMalaLitera) {
            activity.TekstMaleLitery.setTextColor(Color.GREEN);
        } else {
            activity.TekstMaleLitery.setTextColor(Color.RED);
        }

        boolean czyCyfra = false;
        for (int i = 0; i < haslo.length(); i++) {
            if (activity.liczby.contains("" + haslo.charAt(i))) {
                czyCyfra = true;
                break;
            }
        }
        if (czyCyfra) {
            activity.TekstCyfry.setTextColor(Color.GREEN);
        } else {
            activity.TekstCyfry.setTextColor(Color.RED);
        }

        boolean czySpecjalny = false;
        for (int i = 0; i < haslo.length(); i++) {
            if (activity.specjalne.contains("" + haslo.charAt(i))) {
                czySpecjalny = true;
                break;
            }
        }
        if (czySpecjalny) {
            activity.TekstSpecjalne.setTextColor(Color.GREEN);
        } else {
            activity.TekstSpecjalne.setTextColor(Color.RED);
        }

        if (haslo.length() >= 8) {
            activity.TekstDlugosc.setTextColor(Color.GREEN);
        } else {
            activity.TekstDlugosc.setTextColor(Color.RED);
        }
    }
}

