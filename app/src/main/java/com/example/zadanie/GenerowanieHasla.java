package com.example.zadanie;
import android.app.AlertDialog;
import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
public class GenerowanieHasla  implements android.view.View.OnClickListener {

    private final Context context;
    private final TextView wynikText;
    private final String duze;
    private final String male;
    private final String specjalne;
    private final String liczby;

    public GenerowanieHasla(Context context, TextView wynikText,
                            String duze, String male, String specjalne, String liczby) {

        this.context = context;
        this.wynikText = wynikText;
        this.duze = duze;
        this.male = male;
        this.specjalne = specjalne;
        this.liczby = liczby;
    }

    @Override
    public void onClick(android.view.View view) {

        EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        new AlertDialog.Builder(context)
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
                        wyjatki.add(1); wyjatki.add(2); wyjatki.add(3); wyjatki.add(4);

                        char[] wynik = new char[dlugosc];

                        for (int x = 0; x < wyjatki.size(); x++) {
                            int typ = wyjatki.get(x);
                            int index = random.nextInt(ciag.size());
                            int pozycja = ciag.get(index);
                            ciag.remove(index);
                            wyjatki.remove(index);
                            switch (typ) {
                                case 1:
                                wynik[pozycja] = duze.charAt(random.nextInt(duze.length()));
                                break; case 2: wynik[pozycja] = male.charAt(random.nextInt(male.length()));
                                    break; case 3: wynik[pozycja] = specjalne.charAt(random.nextInt(specjalne.length()));
                                    break; case 4: wynik[pozycja] = liczby.charAt(random.nextInt(liczby.length())); break;
                            }
                        }

                        for (int pos : ciag) {
                            wynik[pos] = all.charAt(random.nextInt(all.length()));
                        }

                        wynikText.setText(new String(wynik));
                    }
                })
                .setNegativeButton("Anuluj", null)
                .show();
    }
}