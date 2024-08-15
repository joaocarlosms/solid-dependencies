package org.example.model;

import org.example.database.SQLiteConnector;
import org.example.model.interfaces.IRepositoryData;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RepositoryDataBase implements IRepositoryData {
    private SQLiteConnector connector;

    public RepositoryDataBase(SQLiteConnector connector) {
        this.connector = connector;
    }

    @Override
    public void save(Person person) {
        String sql = "INSERT INTO person (name, cpf, age) VALUES(?, ?, ?)";
        try(PreparedStatement stmt = connector.getConnection().prepareStatement(sql)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getCpf());
            stmt.setInt(3, person.getAge());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int idPerson) {
        String sql = "DELETE FROM person WHERE id = ?";
        try(PreparedStatement stmt = connector.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, idPerson);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getListPerson() {
        String sql = "SELECT * FROM person";
        List<Person> persons = new ArrayList<>();
        try(Statement stmt = connector.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                persons.add(new Person(
                        rs.getInt("age"),
                        rs.getString("cpf"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }
}
