package com.example.myappsql;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.myappsql.entities.Evento;
import com.example.myappsql.entities.EventoAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListActivity extends AppCompatActivity {

    private List<Evento> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        Evento[] myListData = new Evento[] {
                new Evento(1, "sd", new Date(), new Date()),
                new Evento(2, "Info", new Date(), new Date())
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        EventoAdapter adapter = new EventoAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        System.out.println("NANANNANA");



    }

    private void initBookData() {
        Evento book = new Evento(1, "Fiesta", new Date(), new Date());
        book.setObservaciones("Ninguna");
        bookList.add(book);

        Evento book2 = new Evento(1, "Fiesta", new Date(), new Date());
        book2.setObservaciones("Ning");
        bookList.add(book2);

        System.out.println(bookList.toArray().toString());
        mAdapter.notifyDataSetChanged();
    }

}
