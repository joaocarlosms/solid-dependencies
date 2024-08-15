package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnector {
    private Connection connection;

    public SQLiteConnector(String dbName) throws SQLException {
        String url = "jdbc:sqlite:" + dbName;
        this.connection = DriverManager.getConnection(url);

        createTablePerson();
    }

    public Connection getConnection() {
        return connection;
    }

    private void createTablePerson() {
        String sql = "CREATE TABLE IF NOT EXISTS person (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "cpf TEXT NOT NULL," +
                "age INTEGER NOT NULL" +
                ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
}
