package com.project.databaseapp.config.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SQLiteConnection {
    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC"); // zaladowanie sterownika JDBC SQLite
            String url = "jdbc:sqlite:mydatabase.db";// polaczenie z bazą danych
            connection = DriverManager.getConnection(url);
            System.out.println("Polaczono z bazą danych SQLite.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas nawiazywania polaczenia z baza danych");
        }
        return connection;
    }
    public static ResultSet selectFromTable(String tableName) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName);
             ResultSet resultSet = statement.executeQuery()) {
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void insertIntoDevices(String deviceName, String deviceType, String deviceStatus) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Devices (device_name, device_type, device_status) VALUES (?, ?, ?)")) {
            statement.setString(1, deviceName);
            statement.setString(2, deviceType);
            statement.setString(3, deviceStatus);
            statement.executeUpdate();
            System.out.println("Dodano nowe urządzenie.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateDevices(int deviceId, String deviceName, String deviceType, String deviceStatus) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Devices SET device_name = ?, device_type = ?, device_status = ? WHERE device_id = ?")) {
            statement.setString(1, deviceName);
            statement.setString(2, deviceType);
            statement.setString(3, deviceStatus);
            statement.setInt(4, deviceId);
            statement.executeUpdate();
            System.out.println("Zaktualizowano urządzenie o ID " + deviceId + ".");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFromDevices(int deviceId) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM Devices WHERE device_id = ?")) {
            statement.setInt(1, deviceId);
            statement.executeUpdate();
            System.out.println("Usunięto urządzenie o ID " + deviceId + ".");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}