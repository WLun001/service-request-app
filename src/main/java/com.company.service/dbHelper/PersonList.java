package com.company.service.dbHelper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class PersonList {
    protected List<Person> persons;

    public Person search(String id) {
        List<Person> tempPerson = persons
                .stream()
                .filter(person -> person.getId().equals(id))
                .collect(Collectors.toList());
        if (tempPerson.size() > 0)
            return tempPerson.get(0);
        else return null;
    }

    public abstract List<Person> getPersonList();
}
