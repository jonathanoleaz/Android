package com.example.jonat.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Metodo 2 La class de la actividad implementa la interfaz onClickListener


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String nombreValorRecuperar = "valoresIngresados";
    private static String valoresIngresados;

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

    Button buttonOpCos;
    Button buttonOpSen;
    Button buttonOpTan;
    Button buttonOpCot;
    Button buttonOpParIzq;
    Button buttonOpParDer;

    TextView textViewExpression;

    Boolean ultimaExpresionIsOperator = false;//ultima expresion que se agregó al textView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //recuperar receferencias a los widgets y asignar codigo necesario
        buttonDigitoCero = (Button) (this.findViewById(R.id.buttonZero));
        buttonDigitoUno = (Button) (this.findViewById(R.id.buttonDigUno));
        buttonDigitoDos = (Button) (this.findViewById(R.id.buttonDos));
        buttonDigitoTres = (Button) (this.findViewById(R.id.buttonTres));
        buttonDigitoCuatro = (Button) (this.findViewById(R.id.buttonDigCuatro));
        buttonDigitoCinco = (Button) (this.findViewById(R.id.buttonCinco));
        buttonDigitoSeis = (Button) (this.findViewById(R.id.buttonSeis));
        buttonDigitoSiete = (Button) (this.findViewById(R.id.buttonDigSiete));
        buttonDigitoOcho = (Button) (this.findViewById(R.id.buttonOcho));
        buttonDigitoNueve = this.findViewById(R.id.buttonNueve);

        buttonOperPunto = (Button) (this.findViewById(R.id.buttonPunto));
        buttonOperMas = (Button) (this.findViewById(R.id.buttonMas));
        buttonOperMenos = (Button) (this.findViewById(R.id.buttonMenos));
        buttonOperMultip = (Button) (this.findViewById(R.id.buttonMultip));
        buttonOperDiv = (Button) (this.findViewById(R.id.buttonDivision));
        buttonOperGato = (Button) (this.findViewById(R.id.buttonGato));

        buttonCero = (Button) (this.findViewById(R.id.buttonCero));
        buttonIgual = (Button) (this.findViewById(R.id.buttonIgual));

        buttonOpCos = (Button) (this.findViewById(R.id.buttonOpCoSeno));
        buttonOpSen = (Button) (this.findViewById(R.id.buttonOpSeno));
        buttonOpTan = (Button) (this.findViewById(R.id.buttonOpTan));
        buttonOpCot = (Button) (this.findViewById(R.id.buttonOpCotTan));

        buttonOpParDer = (Button) (this.findViewById(R.id.buttonOpParDer));
        buttonOpParIzq = (Button) (this.findViewById(R.id.buttonOpParIzq));


        textViewExpression = this.findViewById(R.id.textView2);

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

        if (buttonOpParDer != null)
            buttonOpParDer.setOnClickListener(this);

        if (buttonOpParIzq != null)
            buttonOpParIzq.setOnClickListener(this);

        if (buttonOpCos != null)
            buttonOpCos.setOnClickListener(this);

        if (buttonOpTan != null)
            buttonOpTan.setOnClickListener(this);

        if (buttonOpCot != null)
            buttonOpCot.setOnClickListener(this);

        if (buttonOpSen != null)
            buttonOpSen.setOnClickListener(this);


        buttonCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewExpression.setText("0");
                ultimaExpresionIsOperator = false;
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String expresionToEvaluar = InfixToPostfix(textViewExpression.getText().toString());

                    textViewExpression.setText(EvaluaExpresion(expresionToEvaluar).toString());
                } catch (Exception e) //
                {
                    e.printStackTrace();
                    textViewExpression.setText(getString(R.string.errorInTextView));
                }
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
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of item position
        outState.putString(nombreValorRecuperar, textViewExpression.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Read the state of item position
        valoresIngresados = savedInstanceState.getString(nombreValorRecuperar);
        textViewExpression.setText(valoresIngresados);
    }

    @Override
    public void onClick(View v) { //v describe el objeto
        String expresionToEvaluar = textViewExpression.getText().toString();
        String expresionToConcatenar = ((Button) v).getText().toString();

        System.out.println(expresionToConcatenar);
        System.out.println(ultimaExpresionIsOperator);
        if ((ultimaExpresionIsOperator && expresionToConcatenar.matches("(\\d)|(\\()|(\\))|(SIN)|(COS)|(COT)|(TAN)|(√)")) | (!ultimaExpresionIsOperator)) { //evitar que se pongan
            String texto = expresionToEvaluar + expresionToConcatenar;
            textViewExpression.setText(texto);
            if (expresionToConcatenar.matches("([-+/*^√])"))
                ultimaExpresionIsOperator = true;
            else
                ultimaExpresionIsOperator = false;
        }

    }

    static int Prec(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;

            case "SIN":

            case "COS":

            case "TAN":

            case "COT":
                return 10;

            case "√":
                return 10;

            case ")":
                return 0;
        }
        return -1;
    }

    /*Función para convertir una expresión infija a una expresion postfija*/
    public String InfixToPostfix(String exp) {

        /*Se agregan espacios en blanco entre cada token. Un token es un numero (con o sin parte decimal), operador (-+/*^),
        o función trigonométrica*/

        String exp2 = exp.replaceAll("(?<=\\d)\\s*([-+/*^√])\\s*(?=\\d)", " $1 ");

        //se agregan espacios en blanco entre cada paréntesis
        exp2 = exp2.replaceAll("((\\()|(\\)))", " $1 ");

        //se agregan espacios entre cada operador de ser necesario
        exp2 = exp2.replaceAll("([-+/*^√])", " $1 ");

        //se quitan espacios inncesarios (dejando a lo más un espacio entre cada token)
        exp2 = exp2.replaceAll(" +", " ").trim();

        String[] tokens = exp2.split(" "); //se dejan los tokens en un arreglo

        String result = "";

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; ++i) {
            String token = tokens[i].trim();//por si tiene espacios al principio o al comienzo

            // Si el token es un número (operando)
            if (token.matches("[0-9]*\\.?[0-9]+")) {
                result += token + " ";
            } // If the scanned character is an '(', push it to the stack.
            else if ("(".equals(token)) {
                stack.push(token);
            } // If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (")".equals(token)) {
                while (!stack.isEmpty() && !("(".equals(stack.peek()))) {
                    result += stack.pop() + " ";
                }

                if (!stack.isEmpty() && !("(".equals(stack.peek()))) {
                    return "Error en paréntesis"; // invalid expression
                } else {
                    stack.pop();  //se vacía la pila con los paréntesis que hayan quedado.
                }
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(token) <= Prec(stack.peek())) {
                    result += stack.pop() + " ";
                }
                stack.push(token);
            }
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }

        return result;

    }

    /*Función que evalua una expresión postfija*/
    public Double EvaluaExpresion(String exp) {
        String[] tokens = exp.split(" "); //se dejan los tokens en un arreglo

        Stack<Double> stack = new Stack<>();

        // Se recorren los tokens a través del arreglo
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];

            // Si el token es un operando, en este caso, un número con o sin parte decimal
            if (c.matches("[0-9]*\\.?[0-9]+")) {
                stack.push(Double.parseDouble(c));
            } //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else {
                if (c.matches("SIN|COS|TAN|COT|√"))//es funcion u operador unario
                {
                    Double val1 = stack.pop();
                    switch (c) {
                        case "SIN":
                            stack.push(Math.sin(val1));
                            break;
                        case "COS":
                            stack.push(Math.cos(val1));
                            break;
                        case "TAN":
                            stack.push(Math.tan(val1));
                            break;
                        case "COT":
                            stack.push(Math.atan(val1));
                            break;
                        case "√":
                            stack.push(Math.sqrt(val1));
                    }

                } else {
                    Double val1 = stack.pop();
                    Double val2 = stack.pop();

                    switch (c) {
                        case "+":
                            stack.push(val2 + val1);
                            break;

                        case "-":
                            stack.push(val2 - val1);
                            break;

                        case "/":
                            stack.push(val2 / val1);
                            break;

                        case "*":
                            stack.push(val2 * val1);
                            break;

                        case "^":
                            stack.push(Math.pow(val2, val1));
                            break;
                    }
                }
            }
        }
        return stack.pop();
    }
}
