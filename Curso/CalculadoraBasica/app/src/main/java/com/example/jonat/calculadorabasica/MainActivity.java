package com.example.jonat.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button buttonDigitoUno;
    Button buttonDigitoDos;
    Button buttonDigitoTres;
    Button buttonDigitoCuatro;
    Button buttonDigitoCinco;
    Button buttonDigitoSeis;
    Button buttonDigitoSiete;
    Button buttonDigitoOcho;

    Button buttonDigitoNueve;
    Button buttonOperPunto;
    Button buttonOperMas;
    Button buttonOperMenos;
    Button buttonOperMultip;
    Button buttonOperDiv;
    Button buttonOperGato;


    TextView textViewExpression;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //recuperar receferencias a los widgets y asignar codigo necesario
        buttonDigitoUno=(Button) (this.findViewById(R.id.buttonDigUno));
        buttonDigitoDos=(Button) (this.findViewById(R.id.buttonDos));
        buttonDigitoCuatro=(Button) (this.findViewById(R.id.buttonDigCuatro));
        textViewExpression=this.findViewById(R.id.textView2);

        //definir una inner class por cada objeto
        buttonDigitoUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto= (String) buttonDigitoUno.getText();
                textViewExpression.setText(texto);
            }
        });
    }
}
