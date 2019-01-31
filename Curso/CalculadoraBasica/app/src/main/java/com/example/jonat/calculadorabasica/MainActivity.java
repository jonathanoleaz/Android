package com.example.jonat.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Metodo 2 La class de la actividad implementa la interfaz onClickListener


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonDigitoCero;
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
        buttonDigitoCero=(Button) (this.findViewById(R.id.buttonZero));
        buttonDigitoUno=(Button) (this.findViewById(R.id.buttonDigUno));

        buttonDigitoDos=(Button) (this.findViewById(R.id.buttonDos));
        buttonDigitoTres=(Button) (this.findViewById(R.id.buttonTres));
        buttonDigitoCuatro=(Button) (this.findViewById(R.id.buttonDigCuatro));
        buttonDigitoCinco=(Button) (this.findViewById(R.id.buttonCinco));
        buttonDigitoSeis=(Button) (this.findViewById(R.id.buttonSeis));
        buttonDigitoSiete=(Button) (this.findViewById(R.id.buttonDigSiete));
        buttonDigitoOcho=(Button) (this.findViewById(R.id.buttonOcho));
        buttonDigitoNueve=(Button) (this.findViewById(R.id.buttonNueve));

        textViewExpression=this.findViewById(R.id.textView2);

        buttonDigitoCero.setOnClickListener(this); //es la misma actividad la que va implementar el onClickListener
        buttonDigitoUno.setOnClickListener(this);
        buttonDigitoDos.setOnClickListener(this);
        buttonDigitoTres.setOnClickListener(this);
        buttonDigitoCuatro.setOnClickListener(this);
        buttonDigitoCinco.setOnClickListener(this);
        buttonDigitoSeis.setOnClickListener(this);
        buttonDigitoSiete.setOnClickListener(this);
        buttonDigitoOcho.setOnClickListener(this);
        buttonDigitoNueve.setOnClickListener(this);

        //Método 1: definir una inner class por cada objeto
        /*
        buttonDigitoUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String texto= textViewExpression.getText().toString()+"1";
                    textViewExpression.setText(texto);
            }
        });*/
    }

    @Override
    public void onClick(View v) { //v describe el objeto
        String texto= textViewExpression.getText().toString()+ ((Button)v).getText().toString();
        textViewExpression.setText(texto);

    }
}
