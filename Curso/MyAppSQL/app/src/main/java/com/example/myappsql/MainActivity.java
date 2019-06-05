package com.example.myappsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonAdd = (Button) findViewById(R.id.buttonAdd);
        botonAdd.setOnClickListener(this);

        Button botonFind = (Button) findViewById(R.id.buttonFind);
        botonFind.setOnClickListener(this);

        Button botonUpdate = (Button) findViewById(R.id.buttonUpdate);
        botonUpdate.setOnClickListener(this);
    }


    @Override
    public void onClick (View v)
    {
        // El boton uno cambiara suetiqueta sin importar que boton se le de click
        //Button boton = (Button)
        //        findViewById(R.id.button1);
        //boton.setText("Click a un boton sin controlar la fuente del click");


        // Para tener control secondiciona la identificacion del boton al que se le dio click
        // de estaforma solo se ejecutael codigo correspondiente a ese boton
        if (v.getId() == R.id.buttonAdd) {
            Intent i = new Intent(getApplicationContext(),AddActivity.class);
            startActivity(i);
        }

        if (v.getId() == R.id.buttonUpdate) {
            Intent i = new Intent(getApplicationContext(),UpdateActivity.class);
            startActivity(i);
        }

        if (v.getId() == R.id.buttonFind) {
            Intent i = new Intent(getApplicationContext(),ListActivity.class);
            startActivity(i);
        }



    }

    public void openAddEvent(View view)
    {
        System.out.println("Agregar abierto");
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }


}
