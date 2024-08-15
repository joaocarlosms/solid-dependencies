package org.example.model;

public class Person {
    private String name;
    private String cpf;
    private int age;

    public Person(int age, String cpf, String name) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
