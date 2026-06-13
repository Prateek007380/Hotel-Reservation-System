package com.hotel.reservation.models;

import com.hotel.reservation.utils.FileManager;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private int nextBookingId = 1;
    private int nextUserId = 1;

    // Constructor - load data from files
    public Hotel() {
        loadRoomsFromFile();
        loadBookingsFromFile();
        loadUsersFromFile();
    }

    // ============ Room Management ============

    // Load rooms from CSV file
    private void loadRoomsFromFile() {
        List<String> lines = FileManager.readFile(FileManager.getRoomsFile());
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                Room room = Room.fromCSV(line);
                if (room != null) {
                    rooms.add(room);
                }
            }
        }
    }

    // Save rooms to CSV file
    public void saveRoomsToFile() {
        List<String> lines = rooms.stream()
                .map(Room::toCSV)
                .collect(Collectors.toList());
        FileManager.writeFile(FileManager.getRoomsFile(), lines);
    }

    // Add a room
    public void addRoom(Room room) {
        rooms.add(room);
        saveRoomsToFile();
    }

    // Get all rooms
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    // Get available rooms
    public List<Room> getAvailableRooms() {
        return rooms.stream()
                .filter(Room::isAvailable)
                .collect(Collectors.toList());
    }

    // Get rooms by type
    public List<Room> getRoomsByType(String roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(roomType))
                .collect(Collectors.toList());
    }

    // Get available rooms by type
    public List<Room> getAvailableRoomsByType(String roomType) {
        return rooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable())
                .collect(Collectors.toList());
    }

    // Get room by ID
    public Room getRoomById(int roomId) {
        return rooms.stream()
                .filter(room -> room.getRoomId() == roomId)
                .findFirst()
                .orElse(null);
    }

    // ============ Booking Management ============

    // Load bookings from CSV file
    private void loadBookingsFromFile() {
        List<String> lines = FileManager.readFile(FileManager.getBookingsFile());
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                Booking booking = Booking.fromCSV(line);
                if (booking != null) {
                    bookings.add(booking);
                    if (booking.getBookingId() >= nextBookingId) {
                        nextBookingId = booking.getBookingId() + 1;
                    }
                }
            }
        }
    }

    // Save bookings to CSV file
    public void saveBookingsToFile() {
        List<String> lines = bookings.stream()
                .map(Booking::toCSV)
                .collect(Collectors.toList());
        FileManager.writeFile(FileManager.getBookingsFile(), lines);
    }

    // Create a new booking
    public Booking createBooking(int userId, int roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        Room room = getRoomById(roomId);
        if (room == null) {
            System.out.println("Room not found!");
            return null;
        }

        if (!room.isAvailable()) {
            System.out.println("Room is not available!");
            return null;
        }

        if (checkOutDate.isBefore(checkInDate) || checkOutDate.equals(checkInDate)) {
            System.out.println("Check-out date must be after check-in date!");
            return null;
        }

        // Calculate total price
        long numberOfNights = java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double totalPrice = room.getPricePerNight() * numberOfNights;

        // Create booking
        Booking booking = new Booking(nextBookingId++, userId, roomId, checkInDate, 
                checkOutDate, totalPrice, "Confirmed", LocalDate.now());
        
        bookings.add(booking);
        room.setAvailable(false);  // Mark room as unavailable
        saveBookingsToFile();
        saveRoomsToFile();

        return booking;
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    // Get booking by ID
    public Booking getBookingById(int bookingId) {
        return bookings.stream()
                .filter(booking -> booking.getBookingId() == bookingId)
                .findFirst()
                .orElse(null);
    }

    // Get bookings by user ID
    public List<Booking> getBookingsByUserId(int userId) {
        return bookings.stream()
                .filter(booking -> booking.getUserId() == userId)
                .collect(Collectors.toList());
    }

    // Get confirmed bookings by user ID
    public List<Booking> getConfirmedBookingsByUserId(int userId) {
        return bookings.stream()
                .filter(booking -> booking.getUserId() == userId && "Confirmed".equals(booking.getStatus()))
                .collect(Collectors.toList());
    }

    // Cancel a booking
    public boolean cancelBooking(int bookingId) {
        Booking booking = getBookingById(bookingId);
        if (booking == null) {
            System.out.println("Booking not found!");
            return false;
        }

        if ("Cancelled".equals(booking.getStatus())) {
            System.out.println("This booking is already cancelled!");
            return false;
        }

        // Update booking status
        booking.setStatus("Cancelled");

        // Make room available again
        Room room = getRoomById(booking.getRoomId());
        if (room != null) {
            room.setAvailable(true);
        }

        saveBookingsToFile();
        saveRoomsToFile();
        return true;
    }

    // ============ User Management ============

    // Load users from CSV file
    private void loadUsersFromFile() {
        List<String> lines = FileManager.readFile(FileManager.getUsersFile());
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                User user = User.fromCSV(line);
                if (user != null) {
                    users.add(user);
                    if (user.getUserId() >= nextUserId) {
                        nextUserId = user.getUserId() + 1;
                    }
                }
            }
        }
    }

    // Save users to CSV file
    public void saveUsersToFile() {
        List<String> lines = users.stream()
                .map(User::toCSV)
                .collect(Collectors.toList());
        FileManager.writeFile(FileManager.getUsersFile(), lines);
    }

    // Register a new user
    public User registerUser(String name, String email, String phoneNumber) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return null;
        }

        if (email == null || email.trim().isEmpty()) {
            System.out.println("Email cannot be empty!");
            return null;
        }

        User user = new User(nextUserId++, name, email, phoneNumber);
        users.add(user);
        saveUsersToFile();
        return user;
    }

    // Get user by ID
    public User getUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    // Get user by email
    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    // Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Initialize sample data (if files are empty)
    public void initializeSampleData() {
        if (rooms.isEmpty()) {
            addRoom(new Room(1, "Standard", 100.0, true, "Basic room with single bed"));
            addRoom(new Room(2, "Standard", 100.0, true, "Basic room with single bed"));
            addRoom(new Room(3, "Deluxe", 150.0, true, "Spacious room with double bed and sea view"));
            addRoom(new Room(4, "Deluxe", 150.0, true, "Spacious room with double bed and sea view"));
            addRoom(new Room(5, "Suite", 250.0, true, "Luxury suite with living room and jacuzzi"));
        }
    }
}
