package com.hotel.reservation.models;

public class Room {
    private int roomId;
    private String roomType;      // Standard, Deluxe, Suite
    private double pricePerNight;
    private boolean isAvailable;
    private String description;

    public Room(int roomId, String roomType, double pricePerNight, boolean isAvailable, String description) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
        this.description = description;
    }

    // Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Display room information
    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", isAvailable=" + isAvailable +
                ", description='" + description + '\'' +
                '}';
    }

    // Convert to CSV format
    public String toCSV() {
        return roomId + "," + roomType + "," + pricePerNight + "," + isAvailable + "," + description;
    }

    // Create Room from CSV line
    public static Room fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length >= 5) {
            return new Room(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    Double.parseDouble(parts[2]),
                    Boolean.parseBoolean(parts[3]),
                    parts[4]
            );
        }
        return null;
    }
}
