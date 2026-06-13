package com.hotel.reservation.utils;

import java.util.Random;

public class PaymentProcessor {
    private Random random = new Random();

    // Simulate payment processing
    public boolean processPayment(double amount, String cardNumber, String cardHolder, String expiryDate) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Payment failed.");
            return false;
        }

        if (cardNumber == null || cardNumber.length() != 16 || !isNumeric(cardNumber)) {
            System.out.println("Invalid card number. Must be 16 digits.");
            return false;
        }

        if (cardHolder == null || cardHolder.trim().isEmpty()) {
            System.out.println("Invalid cardholder name.");
            return false;
        }

        if (expiryDate == null || !expiryDate.matches("\\d{2}/\\d{2}")) {
            System.out.println("Invalid expiry date. Use MM/YY format.");
            return false;
        }

        // Simulate payment processing with 90% success rate
        boolean success = random.nextDouble() < 0.9;

        if (success) {
            System.out.println("\n========== PAYMENT PROCESSED ==========");
            System.out.println("Amount: $" + String.format("%.2f", amount));
            System.out.println("Card: **** **** **** " + cardNumber.substring(12));
            System.out.println("Cardholder: " + cardHolder);
            System.out.println("Status: SUCCESS");
            System.out.println("Transaction ID: TXN" + generateTransactionId());
            System.out.println("========================================\n");
        } else {
            System.out.println("\n========== PAYMENT FAILED ==========");
            System.out.println("Amount: $" + String.format("%.2f", amount));
            System.out.println("Card: **** **** **** " + cardNumber.substring(12));
            System.out.println("Status: DECLINED");
            System.out.println("Message: Payment declined. Please try again with another card.");
            System.out.println("=====================================\n");
        }

        return success;
    }

    // Helper method to validate if string contains only digits
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // Generate a random transaction ID
    private String generateTransactionId() {
        return String.format("%010d", random.nextInt(1000000000));
    }

    // Generate a test card number
    public static String generateTestCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }
}
