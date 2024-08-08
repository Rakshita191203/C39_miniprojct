package com.rakshi.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingManager {
    public void bookTicket(int busID, int passengerID, String bookingDate) {
        if (!isPassengerExists(passengerID)) {
            System.out.println("Passenger ID " + passengerID + " does not exist. Please add the passenger first.");
            return;
        }

        String query = "INSERT INTO Bookings (BusID, PassengerID, BookingDate) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, busID);
            stmt.setInt(2, passengerID);
            stmt.setDate(3, java.sql.Date.valueOf(bookingDate));
            stmt.executeUpdate();
            System.out.println("Booking successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isPassengerExists(int passengerID) {
        String query = "SELECT 1 FROM Passengers WHERE PassengerID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, passengerID);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if a result exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void listBookings() {
        String query = "SELECT * FROM Bookings";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Booking ID: " + rs.getInt("BookingID"));
                System.out.println("Bus ID: " + rs.getInt("BusID"));
                System.out.println("Passenger ID: " + rs.getInt("PassengerID"));
                System.out.println("Booking Date: " + rs.getDate("BookingDate"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
