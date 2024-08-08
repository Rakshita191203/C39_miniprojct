package com.rakshi.miniproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BusManager busManager = new BusManager();
        PassengerManager passengerManager = new PassengerManager();
        BookingManager bookingManager = new BookingManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bus Booking System");
            System.out.println("1. Add Bus");
            System.out.println("2. Add Passenger");
            System.out.println("3. Book Ticket");
            System.out.println("4. List Buses");
            System.out.println("5. List Passengers");
            System.out.println("6. List Bookings");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Bus Number: ");
                    String busNumber = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Route: ");
                    String route = scanner.nextLine();
                    busManager.addBus(busNumber, capacity, route);
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    passengerManager.addPassenger(name, email, phone);
                    break;

                case 3:
                    System.out.print("Enter Bus ID: ");
                    int busID = scanner.nextInt();
                    System.out.print("Enter Passenger ID: ");
                    int passengerID = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Booking Date (YYYY-MM-DD): ");
                    String bookingDate = scanner.nextLine();
                    bookingManager.bookTicket(busID, passengerID, bookingDate);
                    break;

                case 4:
                    System.out.println("Buses:");
                    busManager.listBuses();
                    break;

                case 5:
                    System.out.println("Passengers:");
                    passengerManager.listPassengers();
                    break;

                case 6:
                    System.out.println("Bookings:");
                    bookingManager.listBookings();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
