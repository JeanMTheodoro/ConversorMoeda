package com.example.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ImageButton usa, china, englad, euro;
    private EditText editText;
    TextView textView;
    Button bntclear;

    final static double DOLAR = 4.50;
    final static double YUAN = 0.62;
    final static double LIBRA = 5.69;
    final static double EURO = 4.76;

    String realField = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usa = findViewById(R.id.usa);
        china = findViewById(R.id.china);
        englad = findViewById(R.id.englad);
        euro = findViewById(R.id.euro);
        editText = (EditText) findViewById(R.id.editText);
        textView = findViewById(R.id.textview);
        bntclear = findViewById(R.id.bntclear);


        usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conveterMoedas("usa");
            }
        });


        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conveterMoedas("china");
            }
        });

        englad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conveterMoedas("englad");
            }
        });

        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conveterMoedas("euro");

            }
        });

        bntclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                textView.setText("");
            }
        });
    }

    private void conveterMoedas(String country) {

        double money = 0;

        if (country.equals("usa")) {

            try {
                money = readInput();

            }catch (NumberFormatException exception){
                Toast.makeText(this, "Entrada inválida!", Toast.LENGTH_SHORT).show();
                money = 0;
            }

            textView.setText(String.format("DOLAR $: %.2f", money/DOLAR));

        } else if (country.equals("china")) {

            try {
                money = readInput();

            }catch (NumberFormatException exception){

                money = 0;
            }

            textView.setText(String.format("YUAN CNY: %.2f",money/YUAN));


        } else if (country.equals("englad")) {

            try {
                money = readInput();

            }catch (NumberFormatException exception){

                money = 0;
            }

            textView.setText(String.format("LIBRA GBP: %.2f",money/LIBRA ));


        } else if (country.equals("euro")) {

            try {
                money = readInput();

            }catch (NumberFormatException exception){

                money = 0;
            }

            textView.setText(String.format("EURO EUR: %.2f ", money/EURO));
        }
    }

    private double readInput() throws NumberFormatException {

        double valueInput = 0;

        try {

            valueInput = Double.valueOf(editText.getText().toString());

        } catch (NumberFormatException exception) {
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
            throw exception;

        }

        return valueInput;
    }


}