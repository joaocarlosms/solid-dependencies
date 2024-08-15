package org.example.model.interfaces;

import org.example.model.Person;

import java.util.List;

public interface IRepositoryData {

    void save(Person person);
    void delete(int idPerson);
    List<Person> getListPerson();
}
