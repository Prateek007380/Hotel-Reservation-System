package com.hotel.reservation.models;

import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private int userId;
    private int roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;
    private String status;  // Confirmed, Cancelled, Completed
    private LocalDate bookingDate;

    public Booking(int bookingId, int userId, int roomId, LocalDate checkInDate, 
                   LocalDate checkOutDate, double totalPrice, String status, LocalDate bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    // Calculate number of nights
    public long getNumberOfNights() {
        return java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", bookingDate=" + bookingDate +
                '}';
    }

    // Convert to CSV format
    public String toCSV() {
        return bookingId + "," + userId + "," + roomId + "," + checkInDate + "," + 
               checkOutDate + "," + totalPrice + "," + status + "," + bookingDate;
    }

    // Create Booking from CSV line
    public static Booking fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length >= 8) {
            return new Booking(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]),
                    LocalDate.parse(parts[3]),
                    LocalDate.parse(parts[4]),
                    Double.parseDouble(parts[5]),
                    parts[6],
                    LocalDate.parse(parts[7])
            );
        }
        return null;
    }
}
