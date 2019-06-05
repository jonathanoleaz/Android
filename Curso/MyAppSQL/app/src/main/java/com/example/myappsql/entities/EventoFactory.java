package com.example.myappsql.entities;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoFactory {

    public static List createInMemoryData(){
        List eventos = new ArrayList<>();
        eventos.add(new Evento(1, "Ejemplo", new Date(), new Date()));
        eventos.add(new Evento(2, "Ejemplo", new Date(), new Date()));
        eventos.add(new Evento(3, "Ejemplo", new Date(), new Date()));
        eventos.add(new Evento(4, "Ejemplo", new Date(), new Date()));
        eventos.add(new Evento(5, "Ejemplo", new Date(), new Date()));


        return eventos;
    }
}
