package com.example.zadanie;
import android.app.AlertDialog;
import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GenerowanieHasla implements android.view.View.OnClickListener {

    private final MainActivity activity;

    public GenerowanieHasla(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(android.view.View view) {

        EditText input = new EditText(activity);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        new AlertDialog.Builder(activity)
                .setTitle("Podaj długość hasła")
                .setView(input)
                .setPositiveButton("OK", (dialog, which) -> {

                    String tekst = input.getText().toString();
                    if (!tekst.isEmpty()) {

                        int dlugosc = Integer.parseInt(tekst);

                        if (dlugosc < 4 || dlugosc > 20) {
                            Toast.makeText(activity, "Długość hasła musi być między 4 a 20", Toast.LENGTH_LONG).show();
                            return;
                        }

                        String all = activity.duze + activity.male + activity.specjalne + activity.liczby;
                        Random random = new Random();

                        ArrayList<Integer> ciag = new ArrayList<>();
                        for (int i = 0; i < dlugosc; i++) {
                            ciag.add(i);
                        }

                        ArrayList<Integer> wyjatki = new ArrayList<>();
                        wyjatki.add(1); wyjatki.add(2); wyjatki.add(3); wyjatki.add(4);

                        char[] wynik = new char[dlugosc];

                        for (int x = 0; x < wyjatki.size(); x++) {
                            int typ = wyjatki.get(x);
                            int index = random.nextInt(ciag.size());
                            int pozycja = ciag.get(index);
                            ciag.remove(index);
                            wyjatki.remove(x);
                            x--;

                            switch (typ) {
                                case 1:
                                    wynik[pozycja] = activity.duze.charAt(random.nextInt(activity.duze.length()));
                                    break;
                                case 2:
                                    wynik[pozycja] = activity.male.charAt(random.nextInt(activity.male.length()));
                                    break;
                                case 3:
                                    wynik[pozycja] = activity.specjalne.charAt(random.nextInt(activity.specjalne.length()));
                                    break;
                                case 4:
                                    wynik[pozycja] = activity.liczby.charAt(random.nextInt(activity.liczby.length()));
                                    break;
                            }
                        }

                        for (int pos : ciag) {
                            wynik[pos] = all.charAt(random.nextInt(all.length()));
                        }

                        activity.TekstZmien.setText(new String(wynik));
                        activity.TekstSprawdz.setText(new String(wynik));
                        activity.TekstHaslo.setText(new String(wynik));

                    }
                })
                .setNegativeButton("Anuluj", null)
                .show();
    }
}