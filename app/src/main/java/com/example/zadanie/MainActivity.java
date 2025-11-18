package com.example.zadanie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
  private EditText TekstEmail;
  private EditText TekstHaslo;
  private Button ButttonZatwierdz;
  private Button ButtonWygenerujHaslo;
  private Button ButtonSprawdzMoc;
  private TextView TekstDuzeLitery;
  private TextView TekstMaleLitery;
  private TextView TekstSpecjalne;
  private TextView TekstCyfry;
  private TextView TekstDlugosc;
  private String haslo;
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
        ButttonZatwierdz = findViewById(R.id.buttonRegister);
        ButtonWygenerujHaslo = findViewById(R.id.buttonRandom);
        ButtonSprawdzMoc = findViewById(R.id.buttonPower);
        TekstDuzeLitery = findViewById(R.id.UpperCase);
        TekstMaleLitery = findViewById(R.id.LowerCase);
        TekstSpecjalne = findViewById(R.id.Special);
        TekstCyfry = findViewById(R.id.Number);
        TekstDlugosc= findViewById(R.id.Lenght);


        ButttonZatwierdz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }
        );
    }
}