package com.example.myappsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myappsql.asyncTasks.BuscarRegistroAsyncTask;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonAdd;
    Button botonUpdate;

    EditText idTxt;
    EditText nombreTxt;
    EditText inicioTxt;
    EditText finTxt;
    EditText observsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        botonAdd = (Button) findViewById(R.id.buttonAceptarNuevoUpdate);
        botonAdd.setOnClickListener(this);

        botonUpdate = (Button) findViewById(R.id.buttonAceptarNuevoUpdate);
        botonUpdate.setOnClickListener(this);

        idTxt=(EditText) findViewById(R.id.idNuevoEventoUpdate);
        nombreTxt=(EditText) findViewById(R.id.nombreNuevoEventoUpdate);
        inicioTxt=(EditText) findViewById(R.id.inicioNuevoEventoUpdate);
        finTxt=(EditText) findViewById(R.id.finNuevoEventoUpdate);
        observsTxt=(EditText) findViewById(R.id.observacionesNuevoEventoUpdate);

    }

    @Override
    public void onClick(View v) {

        System.out.println("Actualizar abierto");
        if (v.getId() == R.id.buttonAceptarNuevoUpdate) {
            System.out.println("Actualizar abierto s 3");
            String user=getResources().getString(R.string.userDB);
            String pass=getResources().getString(R.string.passDB);
            String url=getResources().getString(R.string.urlDB);

            BuscarRegistroAsyncTask buscarRegistroAsyncTask =new BuscarRegistroAsyncTask(url, user, pass, this);
            buscarRegistroAsyncTask.execute("SELECT * from evento WHERE nombreevento like ?", nombreTxt.getText().toString());
            //El Toast se muestra una vez finalizado el AsyncTask desde el AsyncTask
        }

        if (v.getId() == R.id.buttonActualizar) {
            System.out.println("Actualizar abierto s 3");
            String user=getResources().getString(R.string.userDB);
            String pass=getResources().getString(R.string.passDB);
            String url=getResources().getString(R.string.urlDB);

            BuscarRegistroAsyncTask buscarRegistroAsyncTask =new BuscarRegistroAsyncTask(url, user, pass, this);
            buscarRegistroAsyncTask.execute("UPDATE evento set nombreEvento=?, inicio=?, fin=?, observaciones=? WHERE idEvento=?", nombreTxt.getText().toString());
            //El Toast se muestra una vez finalizado el AsyncTask desde el AsyncTask
        }
    }
}
