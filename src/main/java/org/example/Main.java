package org.example;

import org.example.database.SQLiteConnector;
import org.example.model.DataService;
import org.example.model.Person;
import org.example.model.RepositoryDataBase;
import org.example.model.interfaces.IRepositoryData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            SQLiteConnector connector = new SQLiteConnector("persons.db");
            Connection connection = connector.getConnection();

            // Criando o repositorio do banco de dados
            IRepositoryData repositorio = new RepositoryDataBase(connector);

            // Entregando para o serviço, que vai usar em Inversão de Dependência
            DataService service = new DataService(repositorio);

            // Adicionando pessoas
            service.addPerson("João", "123.456.789-00", 25);
            service.addPerson("Maria", "987.654.321-00", 30);
            service.addPerson("Test", "123.123.324-93", 19);

            // Excluindo uma pessoa
            service.deletePerson(2);

            // Listando pessoas. Busca no banco de dados
            List<Person> lst = service.getPersons();

            // Imprime a lista de pessoas
            for (Person p : lst) {
                System.out.println(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inicializar o sistema: " + e.getMessage());
        }
    }
}