package com.example.jonat.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

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

    Button buttonCero;
    Button buttonIgual;


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

        buttonOperPunto=(Button) (this.findViewById(R.id.buttonPunto));
        buttonOperMas=(Button) (this.findViewById(R.id.buttonMas));
        buttonOperMenos=(Button) (this.findViewById(R.id.buttonMenos));
        buttonOperMultip=(Button) (this.findViewById(R.id.buttonMultip));
        buttonOperDiv=(Button) (this.findViewById(R.id.buttonDivision));
        buttonOperGato=(Button) (this.findViewById(R.id.buttonGato));

        buttonCero=(Button) (this.findViewById(R.id.buttonCero));
        buttonIgual=(Button) (this.findViewById(R.id.buttonIgual));

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

        buttonOperPunto.setOnClickListener(this);
        buttonOperMas.setOnClickListener(this);
        buttonOperMenos.setOnClickListener(this);
        buttonOperMultip.setOnClickListener(this);
        buttonOperDiv.setOnClickListener(this);
        buttonOperGato.setOnClickListener(this);

        buttonCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewExpression.setText("0");
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewExpression.setText(EvaluaExpresion(textViewExpression.getText().toString()).toString());
            }
        });

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
/*Función para convertir una expresión infija a una expresion postfija*/
    public String InfixToPostfix(String infixExpr){
        String postfixExpr=null;


        return postfixExpr;
    }

/*Función que evalua una expresión postfija*/
    public Double EvaluaExpresion(String postfixExpr){
        Double resultado=null;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("-", 1);
        map.put("+", 1);
        map.put("%", 2);
        map.put("*", 2);
        map.put("/", 2);
        map.put("SIN", 6);
        map.put("COS", 6);
        map.put("TAN", 6);
        map.put("COT", 6);

        map.put("(", 12); /* '(' tiene más prioridad que cualquier operador*/
        map.put(")", 0);  /* '(' tiene menos prioridad que cualquier operador*/


        return resultado;
    }
}
