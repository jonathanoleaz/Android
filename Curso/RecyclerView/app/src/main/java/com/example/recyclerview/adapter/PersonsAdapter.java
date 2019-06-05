package com.example.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.models.*;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter {

    private List persons;

    public PersonsAdapter(List persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_layout, parent, false);
        return new PersonsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Person person = (Person) persons.get(position);

        ((PersonsViewHolder)holder).name.setText(person.getName());
        ((PersonsViewHolder)holder).age.setText(String.valueOf(person.getAge()));
        ((PersonsViewHolder)holder).position.setText(person.getPosition());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonsViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView age;
        private final TextView position;

        public PersonsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            position = itemView.findViewById(R.id.position);

        }
    }
}
