package com.example.myappsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myappsql.asyncTasks.InsertarRegistroAsyncTask;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonAdd;

    EditText nombreTxt;
    EditText inicioTxt;
    EditText finTxt;
    EditText observsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        botonAdd = (Button) findViewById(R.id.buttonAceptarNuevo);
        botonAdd.setOnClickListener(this);

        nombreTxt=(EditText) findViewById(R.id.nombreNuevoEvento);
        inicioTxt=(EditText) findViewById(R.id.inicioNuevoEvento);
        finTxt=(EditText) findViewById(R.id.finNuevoEvento);
        observsTxt=(EditText) findViewById(R.id.observacionesNuevoEvento);

    }

    @Override
    public void onClick(View v) {
        System.out.println("Agregar abierto s");

        if (v.getId() == R.id.buttonAceptarNuevo) {
            System.out.println("Agregar abierto s 3");
            String user=getResources().getString(R.string.userDB);
            String pass=getResources().getString(R.string.passDB);
            String url=getResources().getString(R.string.urlDB);

            InsertarRegistroAsyncTask insertarRegistroAsyncTask =new InsertarRegistroAsyncTask(url, user, pass, this);
            insertarRegistroAsyncTask.execute("INSERT INTO evento (nombreEvento, inicio, fin, observaciones) VALUES (?, ?, ?, ?)", nombreTxt.getText().toString(), inicioTxt.getText().toString(), finTxt.getText().toString(), observsTxt.getText().toString());

            //Toast toast1 =
              //      Toast.makeText(getApplicationContext(),
                //            "Toast por defecto", Toast.LENGTH_SHORT);


        }
    }
}
