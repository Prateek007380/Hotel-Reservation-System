package com.hotel.reservation;

import com.hotel.reservation.models.*;
import com.hotel.reservation.utils.PaymentProcessor;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class HotelReservationSystem {
    private Hotel hotel;
    private User currentUser;
    private Scanner scanner;
    private PaymentProcessor paymentProcessor;

    public HotelReservationSystem() {
        this.hotel = new Hotel();
        this.scanner = new Scanner(System.in);
        this.paymentProcessor = new PaymentProcessor();
        this.currentUser = null;
    }

    // Main menu
    public void start() {
        // Initialize sample data if database is empty
        hotel.initializeSampleData();

        System.out.println("========================================");
        System.out.println("  WELCOME TO HOTEL RESERVATION SYSTEM");
        System.out.println("========================================\n");

        boolean running = true;
        while (running) {
            displayMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    userLoginMenu();
                    break;
                case "2":
                    userRegistrationMenu();
                    break;
                case "3":
                    displayAllRooms();
                    break;
                case "4":
                    running = false;
                    System.out.println("\nThank you for using Hotel Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }

    // Display main menu
    private void displayMainMenu() {
        if (currentUser == null) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. View All Rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
        } else {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("Welcome, " + currentUser.getName() + "!");
            System.out.println("1. View Available Rooms");
            System.out.println("2. View Room by Type");
            System.out.println("3. Book a Room");
            System.out.println("4. View My Bookings");
            System.out.println("5. Cancel a Booking");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
        }
    }

    // ============ User Management ============

    // User login
    private void userLoginMenu() {
        System.out.println("\n========== USER LOGIN ==========");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();

        User user = hotel.getUserByEmail(email);
        if (user != null) {
            currentUser = user;
            System.out.println("Welcome back, " + user.getName() + "!");
            userDashboard();
        } else {
            System.out.println("User not found. Please register first.");
        }
    }

    // User registration
    private void userRegistrationMenu() {
        System.out.println("\n========== USER REGISTRATION ==========");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine().trim();

        User user = hotel.registerUser(name, email, phoneNumber);
        if (user != null) {
            currentUser = user;
            System.out.println("\nRegistration successful! Your User ID: " + user.getUserId());
            System.out.println("Welcome to Hotel Reservation System!");
            userDashboard();
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    // User dashboard
    private void userDashboard() {
        boolean inDashboard = true;
        while (inDashboard && currentUser != null) {
            displayMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    viewAvailableRooms();
                    break;
                case "2":
                    viewRoomsByType();
                    break;
                case "3":
                    bookRoomMenu();
                    break;
                case "4":
                    viewMyBookings();
                    break;
                case "5":
                    cancelBookingMenu();
                    break;
                case "6":
                    currentUser = null;
                    System.out.println("\nYou have been logged out.");
                    inDashboard = false;
                    break;
                case "7":
                    currentUser = null;
                    System.out.println("\nThank you for using Hotel Reservation System. Goodbye!");
                    inDashboard = false;
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    // ============ Room Management ============

    // View all rooms
    private void displayAllRooms() {
        System.out.println("\n========== ALL AVAILABLE ROOMS ==========");
        List<Room> rooms = hotel.getAvailableRooms();

        if (rooms.isEmpty()) {
            System.out.println("No rooms available at the moment.");
        } else {
            for (Room room : rooms) {
                displayRoomInfo(room);
            }
        }
    }

    // View available rooms
    private void viewAvailableRooms() {
        System.out.println("\n========== AVAILABLE ROOMS ==========");
        List<Room> rooms = hotel.getAvailableRooms();

        if (rooms.isEmpty()) {
            System.out.println("No rooms available at the moment.");
        } else {
            for (Room room : rooms) {
                displayRoomInfo(room);
            }
        }
    }

    // View rooms by type
    private void viewRoomsByType() {
        System.out.println("\n========== SEARCH BY ROOM TYPE ==========");
        System.out.println("1. Standard Rooms");
        System.out.println("2. Deluxe Rooms");
        System.out.println("3. Suite Rooms");
        System.out.print("Choose room type: ");
        String choice = scanner.nextLine().trim();

        String roomType = null;
        switch (choice) {
            case "1":
                roomType = "Standard";
                break;
            case "2":
                roomType = "Deluxe";
                break;
            case "3":
                roomType = "Suite";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\n========== " + roomType.toUpperCase() + " ROOMS ==========");
        List<Room> rooms = hotel.getAvailableRoomsByType(roomType);

        if (rooms.isEmpty()) {
            System.out.println("No " + roomType + " rooms available.");
        } else {
            for (Room room : rooms) {
                displayRoomInfo(room);
            }
        }
    }

    // Display room info
    private void displayRoomInfo(Room room) {
        System.out.println("\n--- Room ID: " + room.getRoomId() + " ---");
        System.out.println("Type: " + room.getRoomType());
        System.out.println("Price per Night: $" + String.format("%.2f", room.getPricePerNight()));
        System.out.println("Description: " + room.getDescription());
        System.out.println("Available: " + (room.isAvailable() ? "Yes" : "No"));
    }

    // ============ Booking Management ============

    // Book a room
    private void bookRoomMenu() {
        System.out.println("\n========== BOOK A ROOM ==========");

        // Display available rooms
        List<Room> availableRooms = hotel.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("Sorry, no rooms available for booking.");
            return;
        }

        System.out.println("Available Rooms:");
        for (Room room : availableRooms) {
            System.out.println("Room " + room.getRoomId() + " (" + room.getRoomType() + ") - $" + 
                             String.format("%.2f", room.getPricePerNight()) + " per night");
        }

        // Get room ID
        System.out.print("\nEnter Room ID to book: ");
        int roomId;
        try {
            roomId = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid room ID.");
            return;
        }

        Room room = hotel.getRoomById(roomId);
        if (room == null || !room.isAvailable()) {
            System.out.println("Room not available.");
            return;
        }

        // Get check-in date
        LocalDate checkInDate = getDateInput("Enter check-in date (YYYY-MM-DD): ");
        if (checkInDate == null) return;

        // Get check-out date
        LocalDate checkOutDate = getDateInput("Enter check-out date (YYYY-MM-DD): ");
        if (checkOutDate == null) return;

        if (checkOutDate.isBefore(checkInDate) || checkOutDate.equals(checkInDate)) {
            System.out.println("Check-out date must be after check-in date.");
            return;
        }

        // Create booking
        Booking booking = hotel.createBooking(currentUser.getUserId(), roomId, checkInDate, checkOutDate);
        if (booking != null) {
            displayBookingConfirmation(booking, room);
            processPaymentMenu(booking, room);
        }
    }

    // Process payment
    private void processPaymentMenu(Booking booking, Room room) {
        System.out.println("\n========== PAYMENT PROCESS ==========");
        System.out.println("Booking Amount: $" + String.format("%.2f", booking.getTotalPrice()));

        System.out.print("\nProceed with payment? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (!confirm.equals("yes")) {
            System.out.println("Booking cancelled.");
            hotel.cancelBooking(booking.getBookingId());
            return;
        }

        // Get payment details
        System.out.print("\nEnter cardholder name: ");
        String cardHolder = scanner.nextLine().trim();

        System.out.print("Enter card number (16 digits): ");
        String cardNumber = scanner.nextLine().trim();

        System.out.print("Enter expiry date (MM/YY): ");
        String expiryDate = scanner.nextLine().trim();

        // Process payment
        if (paymentProcessor.processPayment(booking.getTotalPrice(), cardNumber, cardHolder, expiryDate)) {
            System.out.println("\nBooking confirmed!");
            System.out.println("Your Booking ID: " + booking.getBookingId());
            System.out.println("Check-in: " + booking.getCheckInDate());
            System.out.println("Check-out: " + booking.getCheckOutDate());
        } else {
            System.out.println("\nPayment failed. Booking cancelled.");
            hotel.cancelBooking(booking.getBookingId());
        }
    }

    // View my bookings
    private void viewMyBookings() {
        System.out.println("\n========== MY BOOKINGS ==========");
        List<Booking> bookings = hotel.getBookingsByUserId(currentUser.getUserId());

        if (bookings.isEmpty()) {
            System.out.println("You have no bookings.");
        } else {
            for (Booking booking : bookings) {
                displayBookingDetails(booking);
            }
        }
    }

    // Cancel booking
    private void cancelBookingMenu() {
        System.out.println("\n========== CANCEL BOOKING ==========");
        List<Booking> bookings = hotel.getConfirmedBookingsByUserId(currentUser.getUserId());

        if (bookings.isEmpty()) {
            System.out.println("You have no confirmed bookings to cancel.");
            return;
        }

        System.out.println("Your confirmed bookings:");
        for (Booking booking : bookings) {
            System.out.println("\nBooking ID: " + booking.getBookingId());
            System.out.println("Room ID: " + booking.getRoomId());
            System.out.println("Check-in: " + booking.getCheckInDate());
            System.out.println("Check-out: " + booking.getCheckOutDate());
            System.out.println("Total Price: $" + String.format("%.2f", booking.getTotalPrice()));
        }

        System.out.print("\nEnter Booking ID to cancel: ");
        int bookingId;
        try {
            bookingId = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid booking ID.");
            return;
        }

        if (hotel.cancelBooking(bookingId)) {
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Failed to cancel booking.");
        }
    }

    // ============ Helper Methods ============

    // Display booking confirmation
    private void displayBookingConfirmation(Booking booking, Room room) {
        System.out.println("\n========== BOOKING CONFIRMATION ==========");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Guest: " + currentUser.getName());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Room ID: " + room.getRoomId());
        System.out.println("Check-in Date: " + booking.getCheckInDate());
        System.out.println("Check-out Date: " + booking.getCheckOutDate());
        System.out.println("Number of Nights: " + booking.getNumberOfNights());
        System.out.println("Price per Night: $" + String.format("%.2f", room.getPricePerNight()));
        System.out.println("Total Amount: $" + String.format("%.2f", booking.getTotalPrice()));
        System.out.println("=========================================");
    }

    // Display booking details
    private void displayBookingDetails(Booking booking) {
        Room room = hotel.getRoomById(booking.getRoomId());
        System.out.println("\n--- Booking ID: " + booking.getBookingId() + " ---");
        System.out.println("Room Type: " + (room != null ? room.getRoomType() : "Unknown"));
        System.out.println("Room ID: " + booking.getRoomId());
        System.out.println("Check-in: " + booking.getCheckInDate());
        System.out.println("Check-out: " + booking.getCheckOutDate());
        System.out.println("Total Price: $" + String.format("%.2f", booking.getTotalPrice()));
        System.out.println("Status: " + booking.getStatus());
        System.out.println("Booking Date: " + booking.getBookingDate());
    }

    // Get date input from user
    private LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String dateString = scanner.nextLine().trim();
            try {
                return LocalDate.parse(dateString);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        system.start();
    }
}
