package org.example.model;

import org.example.model.interfaces.IRepositoryData;

import java.util.List;

public class DataService {
    private IRepositoryData repositoryData;

    public DataService(IRepositoryData repositoryData) {
        this.repositoryData = repositoryData;
    }

    public void addPerson(String name, String cpf, int age) {
        Person person = new Person(age, cpf, name);
        repositoryData.save(person);
    }

    public void deletePerson(int idPerson) {
        repositoryData.delete(idPerson);
    }

    public List<Person> getPersons() {
        return repositoryData.getListPerson();
    }
}
