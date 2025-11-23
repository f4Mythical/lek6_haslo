package com.example.zadanie;

import android.view.View;

public class MainZatwierdz implements View.OnClickListener {

    private MainActivity activity;

    public MainZatwierdz(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        String haslo = activity.TekstHaslo.getText().toString();
        String hasloPow = activity.TekstSprawdz.getText().toString();
        String email = activity.TekstEmail.getText().toString();

        if (email.contains("@")) {
            activity.Email.setText("Dobry email");
        } else {
            activity.Email.setText("Zły email");
        }

        if (haslo.equals(hasloPow)) {
            activity.TextPow.setText("Dziala");
        } else {
            activity.TextPow.setText("Nie dziala");
        }

        int poprawne = 0;

        for (int i = 0; i < haslo.length(); i++) {
            if (activity.duze.contains("" + haslo.charAt(i))) {
                poprawne++;
                break;
            }
        }

        for (int i = 0; i < haslo.length(); i++) {
            if (activity.male.contains("" + haslo.charAt(i))) {
                poprawne++;
                break;
            }
        }

        for (int i = 0; i < haslo.length(); i++) {
            if (activity.liczby.contains("" + haslo.charAt(i))) {
                poprawne++;
                break;
            }
        }

        for (int i = 0; i < haslo.length(); i++) {
            if (activity.specjalne.contains("" + haslo.charAt(i))) {
                poprawne++;
                break;
            }
        }

        if (haslo.length() >= 8) {
            poprawne++;
        }

        if (poprawne == 5) {
            activity.TekstZmien.setText("Poprawne");
        } else {
            activity.TekstZmien.setText("Niepoprawne");
        }
    }
}