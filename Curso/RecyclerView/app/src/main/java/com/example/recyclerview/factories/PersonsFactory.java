package com.example.recyclerview.factories;

import com.example.recyclerview.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonsFactory {

    public static List createInMemoryData(){
        List people = new ArrayList<>();
        people.add(new Person("John", 39, "IT Director"));
        people.add(new Person("Lena", 24, "Credit Review"));
        people.add(new Person("Smith", 21, "Operations Trainee"));
        people.add(new Person("Adam", 31, "Technical Lead"));
        people.add(new Person("Kate", 26, "Senior Human Resources"));
        people.add(new Person("Robert", 33, "IT Manager"));
        people.add(new Person("Lora", 29, "Digital Marketing Lead"));

        return people;
    }
}
