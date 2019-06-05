package com.example.myappsql.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myappsql.entities.Evento;
import com.example.myappsql.R;


import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter {

    private List persons;

    public EventsAdapter(List persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);
        return new PersonsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Evento person = (Evento) persons.get(position);

        ((PersonsViewHolder)holder).name.setText(person.getNombreEvento());
        ((PersonsViewHolder)holder).start.setText(String.valueOf(person.getInicio()));
        ((PersonsViewHolder)holder).end.setText(String.valueOf(person.getFin()));
        ((PersonsViewHolder)holder).observs.setText(String.valueOf(person.getObservaciones()));

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonsViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView start;
        private final TextView end;
        private final TextView observs;

        public PersonsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nombre_Lista);
            start = itemView.findViewById(R.id.inicio_Lista);
            end = itemView.findViewById(R.id.fin_Lista);
            observs = itemView.findViewById(R.id.observs_lista);

        }
    }
}
