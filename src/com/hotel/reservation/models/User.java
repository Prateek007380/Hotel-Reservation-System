package com.hotel.reservation.models;

public class User {
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;

    public User(int userId, String name, String email, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    // Convert to CSV format
    public String toCSV() {
        return userId + "," + name + "," + email + "," + phoneNumber;
    }

    // Create User from CSV line
    public static User fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length >= 4) {
            return new User(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    parts[3]
            );
        }
        return null;
    }
}
