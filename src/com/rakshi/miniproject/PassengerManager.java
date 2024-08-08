package com.rakshi.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerManager {
    public void addPassenger(String name, String email, String phone) {
        String query = "INSERT INTO Passengers (Name, Email, Phone) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listPassengers() {
        String query = "SELECT * FROM Passengers";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Passenger ID: " + rs.getInt("PassengerID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("Phone: " + rs.getString("Phone"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
