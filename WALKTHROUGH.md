# Detailed Walkthrough Example

This document shows a complete example of using the Hotel Reservation System step-by-step.

## Scenario: Complete Booking and Cancellation Workflow

### Part 1: Starting the Application

**Terminal Input:**
```
> run.bat
```

**System Output:**
```
========================================
  WELCOME TO HOTEL RESERVATION SYSTEM
========================================

========== MAIN MENU ==========
1. Login
2. Register
3. View All Rooms
4. Exit
Enter your choice:
```

### Part 2: User Registration

**User Choice:** `2` (Register)

**Terminal Output:**
```
========== USER REGISTRATION ==========
Enter your name: John Smith
Enter your email: john@example.com
Enter your phone number: 555-1234

Registration successful! Your User ID: 1
Welcome to Hotel Reservation System!

========== MAIN MENU ==========
Welcome, John Smith!
1. View Available Rooms
2. View Room by Type
3. Book a Room
4. View My Bookings
5. Cancel a Booking
6. Logout
7. Exit
Enter your choice:
```

### Part 3: View Available Rooms

**User Choice:** `1` (View Available Rooms)

**Terminal Output:**
```
========== AVAILABLE ROOMS ==========

--- Room ID: 1 ---
Type: Standard
Price per Night: $100.00
Description: Basic room with single bed
Available: Yes

--- Room ID: 2 ---
Type: Standard
Price per Night: $100.00
Description: Basic room with single bed
Available: Yes

--- Room ID: 3 ---
Type: Deluxe
Price per Night: $150.00
Description: Spacious room with double bed and sea view
Available: Yes

--- Room ID: 4 ---
Type: Deluxe
Price per Night: $150.00
Description: Spacious room with double bed and sea view
Available: Yes

--- Room ID: 5 ---
Type: Suite
Price per Night: $250.00
Description: Luxury suite with living room and jacuzzi
Available: Yes

========== MAIN MENU ==========
Welcome, John Smith!
1. View Available Rooms
2. View Room by Type
3. Book a Room
4. View My Bookings
5. Cancel a Booking
6. Logout
7. Exit
Enter your choice:
```

### Part 4: Search Rooms by Type

**User Choice:** `2` (View Room by Type)

**Terminal Output:**
```
========== SEARCH BY ROOM TYPE ==========
1. Standard Rooms
2. Deluxe Rooms
3. Suite Rooms
Choose room type: 2
```

**System Output:**
```
========== DELUXE ROOMS ==========

--- Room ID: 3 ---
Type: Deluxe
Price per Night: $150.00
Description: Spacious room with double bed and sea view
Available: Yes

--- Room ID: 4 ---
Type: Deluxe
Price per Night: $150.00
Description: Spacious room with double bed and sea view
Available: Yes
```

### Part 5: Make a Booking

**User Choice:** `3` (Book a Room)

**Terminal Output:**
```
========== BOOK A ROOM ==========
Available Rooms:
Room 1 (Standard) - $100.00 per night
Room 2 (Standard) - $100.00 per night
Room 3 (Deluxe) - $150.00 per night
Room 4 (Deluxe) - $150.00 per night
Room 5 (Suite) - $250.00 per night

Enter Room ID to book: 3
Enter check-in date (YYYY-MM-DD): 2026-04-25
Enter check-out date (YYYY-MM-DD): 2026-04-27
```

### Part 6: Booking Confirmation

**System Output:**
```
========== BOOKING CONFIRMATION ==========
Booking ID: 1
Guest: John Smith
Room Type: Deluxe
Room ID: 3
Check-in Date: 2026-04-25
Check-out Date: 2026-04-27
Number of Nights: 2
Price per Night: $150.00
Total Amount: $300.00
=========================================
```

### Part 7: Payment Processing

**Terminal Output:**
```
========== PAYMENT PROCESS ==========
Booking Amount: $300.00

Proceed with payment? (yes/no): yes

Enter cardholder name: John Smith
Enter card number (16 digits): 4111111111111111
Enter expiry date (MM/YY): 12/28
```

**Payment Processing (Success Case):**
```
========== PAYMENT PROCESSED ==========
Amount: $300.00
Card: **** **** **** 1111
Cardholder: John Smith
Status: SUCCESS
Transaction ID: TXN0123456789
========================================

Booking confirmed!
Your Booking ID: 1
Check-in: 2026-04-25
Check-out: 2026-04-27
```

### Part 8: View My Bookings

**User Choice:** `4` (View My Bookings)

**Terminal Output:**
```
========== MY BOOKINGS ==========

--- Booking ID: 1 ---
Room Type: Deluxe
Room ID: 3
Check-in: 2026-04-25
Check-out: 2026-04-27
Total Price: $300.00
Status: Confirmed
Booking Date: 2026-04-21
```

### Part 9: Cancel a Booking

**User Choice:** `5` (Cancel a Booking)

**Terminal Output:**
```
========== CANCEL BOOKING ==========
Your confirmed bookings:

Booking ID: 1
Room ID: 3
Check-in: 2026-04-25
Check-out: 2026-04-27
Total Price: $300.00

Enter Booking ID to cancel: 1
Booking cancelled successfully.
```

### Part 10: Verify Cancellation

**User Choice:** `4` (View My Bookings)

**Terminal Output:**
```
========== MY BOOKINGS ==========

--- Booking ID: 1 ---
Room Type: Deluxe
Room ID: 3
Check-in: 2026-04-25
Check-out: 2026-04-27
Total Price: $300.00
Status: Cancelled
Booking Date: 2026-04-21
```

### Part 11: Logout

**User Choice:** `6` (Logout)

**Terminal Output:**
```
You have been logged out.

========== MAIN MENU ==========
1. Login
2. Register
3. View All Rooms
4. Exit
Enter your choice:
```

---

## Scenario 2: Login and View Existing Bookings

If you restart the application and want to access your previous data:

**User Choice:** `1` (Login)

**Terminal Output:**
```
========== USER LOGIN ==========
Enter your email: john@example.com
Welcome back, John Smith!

========== MAIN MENU ==========
Welcome, John Smith!
1. View Available Rooms
2. View Room by Type
3. Book a Room
4. View My Bookings
5. Cancel a Booking
6. Logout
7. Exit
Enter your choice:
```

Your previous bookings and data are still there!

---

## Scenario 3: Payment Failure Example

Sometimes payment fails (10% of the time simulated):

**After entering payment details:**
```
========== PAYMENT FAILED ==========
Amount: $300.00
Card: **** **** **** 1111
Status: DECLINED
Message: Payment declined. Please try again with another card.
=====================================

Payment failed. Booking cancelled.
```

The room becomes available again immediately.

---

## Scenario 4: Room Type Filtering Example

**User Choice:** `2` (View Room by Type)

**System Output:**
```
========== SEARCH BY ROOM TYPE ==========
1. Standard Rooms
2. Deluxe Rooms
3. Suite Rooms
Choose room type: 1
```

**Filtered Results:**
```
========== STANDARD ROOMS ==========

--- Room ID: 1 ---
Type: Standard
Price per Night: $100.00
Description: Basic room with single bed
Available: Yes

--- Room ID: 2 ---
Type: Standard
Price per Night: $100.00
Description: Basic room with single bed
Available: Yes
```

---

## Key Observations from Walkthrough

1. **Data Persistence**: After logout and login, your bookings are still there
2. **Real-time Updates**: Room availability changes immediately after booking
3. **Automatic Calculations**: Total price is calculated based on number of nights
4. **User-Friendly**: Clear menus and prompts guide you through each step
5. **Error Handling**: Invalid inputs are caught and user is prompted again
6. **Status Tracking**: Bookings show current status (Confirmed/Cancelled)

---

## Common User Paths

### Path 1: Quick Browser
1. Start app
2. View all rooms (Choice 3)
3. Exit (Choice 4)

### Path 2: Register and Book
1. Register (Choice 2)
2. View rooms (Choice 1)
3. Book room (Choice 3)
4. Make payment
5. Logout (Choice 6)

### Path 3: Returning Customer
1. Login (Choice 1)
2. View my bookings (Choice 4)
3. Cancel booking if needed (Choice 5)
4. Logout (Choice 6)

### Path 4: Price Comparison
1. Login (Choice 1)
2. View Standard rooms (Choice 2)
3. View Deluxe rooms (Choice 2)
4. View Suite rooms (Choice 2)
5. Decide and book

---

## Tips for Testing

- **Test Invalid Inputs**: Try entering letters for room ID to see error handling
- **Test Date Validation**: Try same date for check-in/check-out
- **Test Multiple Bookings**: Register multiple users and make different bookings
- **Test Payment Failures**: Some payments will fail (10% chance) - try multiple times
- **Test Cancellation**: Cancel a booking and verify room is available again
- **Test Data Persistence**: Exit and restart - your bookings should still be there

---

## File Changes During Testing

After running through these scenarios, check the `data/` folder:

**data/users.csv** will contain:
```
1,John Smith,john@example.com,555-1234
```

**data/bookings.csv** will contain:
```
1,1,3,2026-04-25,2026-04-27,300.0,Cancelled,2026-04-21
```

**data/rooms.csv** will show updated availability (though cancelled bookings return rooms to available status)

---

This walkthrough covers all major features of the Hotel Reservation System!
