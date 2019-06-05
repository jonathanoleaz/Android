package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.adapter.PersonsAdapter;
import com.example.recyclerview.factories.PersonsFactory;
import com.example.recyclerview.models.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView personsRecyclerView = findViewById(R.id.persons_recycler_view);
        List<Person> inMemoryData = PersonsFactory.createInMemoryData();

        PersonsAdapter personsAdapter = new PersonsAdapter(inMemoryData);

        personsRecyclerView.setAdapter(personsAdapter);
        personsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        personsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
