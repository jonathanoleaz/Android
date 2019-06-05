package com.example.myappsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myappsql.R;
import com.example.myappsql.adapter.EventsAdapter;
import com.example.myappsql.asyncTasks.BuscarRegistroAsyncTask;
import com.example.myappsql.asyncTasks.ObtenerTodosAsyncTask;
import com.example.myappsql.entities.EventoFactory;
import com.example.myappsql.entities.Evento;


import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView personsRecyclerView = findViewById(R.id.events_recycler_view);
        List<Evento> inMemoryData = EventoFactory.createInMemoryData();

        /*Busqueda en la BD*/
        System.out.println("Actualizar abierto s 3");
        String user=getResources().getString(R.string.userDB);
        String pass=getResources().getString(R.string.passDB);
        String url=getResources().getString(R.string.urlDB);

        ObtenerTodosAsyncTask buscarRegistroAsyncTask =new ObtenerTodosAsyncTask(url, user, pass, this);
        buscarRegistroAsyncTask.execute("SELECT * from evento;");
        /*FIN de Busqueda en la BD*/

        EventsAdapter personsAdapter = new EventsAdapter(inMemoryData);

      /*  System.out.println("Es nulo: "+personsAdapter.toString());
        System.out.println("Es nulo: "+personsRecyclerView.toString());
        personsRecyclerView.setAdapter(personsAdapter);
        personsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        personsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));*/

    }
}
