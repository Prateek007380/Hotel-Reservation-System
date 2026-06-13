package com.hotel.reservation.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileManager {
    private static final String DATA_DIR = "data/";
    private static final String ROOMS_FILE = DATA_DIR + "rooms.csv";
    private static final String BOOKINGS_FILE = DATA_DIR + "bookings.csv";
    private static final String USERS_FILE = DATA_DIR + "users.csv";

    // Static initializer to ensure data directory exists
    static {
        try {
            Files.createDirectories(Paths.get(DATA_DIR));
        } catch (IOException e) {
            System.err.println("Error creating data directory: " + e.getMessage());
        }
    }

    // Read all lines from a file
    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(filename);
            if (file.exists()) {
                lines = Files.readAllLines(Paths.get(filename));
            }
        } catch (IOException e) {
            System.err.println("Error reading file " + filename + ": " + e.getMessage());
        }
        return lines;
    }

    // Write lines to a file
    public static void writeFile(String filename, List<String> lines) {
        try {
            Files.createDirectories(Paths.get(DATA_DIR));
            Files.write(Paths.get(filename), lines, StandardOpenOption.CREATE, 
                       StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        }
    }

    // Append a line to a file
    public static void appendToFile(String filename, String line) {
        try {
            Files.createDirectories(Paths.get(DATA_DIR));
            Files.write(Paths.get(filename), (line + "\n").getBytes(), StandardOpenOption.CREATE, 
                       StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error appending to file " + filename + ": " + e.getMessage());
        }
    }

    // Get the rooms file path
    public static String getRoomsFile() {
        return ROOMS_FILE;
    }

    // Get the bookings file path
    public static String getBookingsFile() {
        return BOOKINGS_FILE;
    }

    // Get the users file path
    public static String getUsersFile() {
        return USERS_FILE;
    }
}
