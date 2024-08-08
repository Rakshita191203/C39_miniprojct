package com.rakshi.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusManager {
    public void addBus(String busNumber, int capacity, String route) {
        String query = "INSERT INTO Buses (BusNumber, Capacity, Route) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, busNumber);
            stmt.setInt(2, capacity);
            stmt.setString(3, route);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listBuses() {
        String query = "SELECT * FROM Buses";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Bus ID: " + rs.getInt("BusID"));
                System.out.println("Bus Number: " + rs.getString("BusNumber"));
                System.out.println("Capacity: " + rs.getInt("Capacity"));
                System.out.println("Route: " + rs.getString("Route"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
