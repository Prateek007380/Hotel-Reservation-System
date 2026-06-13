# Hotel Reservation System

A comprehensive Java-based Hotel Reservation System built with Object-Oriented Programming principles. This project demonstrates key OOP concepts including encapsulation, modular design, and proper separation of concerns.

## Project Overview

The Hotel Reservation System allows users to:
- **Register and Login**: Create user accounts and access personalized services
- **Search Rooms**: Browse available rooms by availability and room type
- **View Room Categories**: Explore Standard, Deluxe, and Suite room options
- **Book Rooms**: Reserve rooms for specific dates with automatic availability management
- **Process Payments**: Simulate payment transactions with validation
- **View Bookings**: Access detailed information about all current and past bookings
- **Cancel Reservations**: Cancel confirmed bookings and free up room availability

## Project Structure

```
d:\java CA task 4\
├── src\
│   └── com\hotel\reservation\
│       ├── HotelReservationSystem.java    # Main application & console UI
│       ├── models\
│       │   ├── Room.java                 # Room entity class
│       │   ├── User.java                 # User entity class
│       │   ├── Booking.java              # Booking entity class
│       │   └── Hotel.java                # Hotel management class
│       └── utils\
│           ├── FileManager.java          # CSV file handling
│           └── PaymentProcessor.java     # Payment simulation
├── data\
│   ├── rooms.csv                         # Room data (auto-created)
│   ├── bookings.csv                      # Booking data (auto-created)
│   └── users.csv                         # User data (auto-created)
└── README.md                             # This file
```

## OOP Principles Used

### 1. **Encapsulation**
- Each class has private attributes with public getter/setter methods
- Example: `Room` class encapsulates room properties and provides controlled access

### 2. **Modular Design**
- Separation of concerns across multiple classes
- `Hotel` class manages business logic
- `FileManager` handles all file I/O operations
- `PaymentProcessor` simulates payment transactions

### 3. **Object-Oriented Design**
- Real-world entities modeled as classes: `Room`, `User`, `Booking`, `Hotel`
- Relationships between classes (Hotel contains Rooms and Bookings)
- Methods for object manipulation and persistence

### 4. **Data Persistence**
- CSV-based file storage for rooms, bookings, and users
- Automatic serialization/deserialization through `toCSV()` and `fromCSV()` methods
- File manager handles all read/write operations

### 5. **Code Reusability**
- Utility classes for common operations (`FileManager`, `PaymentProcessor`)
- Generic methods for file handling
- Filter operations using streams for code efficiency

## Class Descriptions

### Model Classes

**Room.java**
- Represents a hotel room with properties like ID, type, price, and availability
- Supports CSV serialization for data persistence

**User.java**
- Represents a customer with contact information
- Encapsulates user registration data

**Booking.java**
- Represents a room reservation with dates, pricing, and status
- Calculates number of nights automatically

**Hotel.java**
- Core business logic class
- Manages all rooms, bookings, and users
- Loads/saves data to CSV files
- Provides methods for searching, booking, and cancellation

### Utility Classes

**FileManager.java**
- Centralized file handling operations
- Methods: `readFile()`, `writeFile()`, `appendToFile()`
- Manages the `data/` directory creation

**PaymentProcessor.java**
- Simulates credit card payment processing
- Validates card details (number, holder, expiry)
- Returns success/failure with transaction details

### Main Application

**HotelReservationSystem.java**
- Console-based user interface
- Menu-driven navigation
- Handles user input and output
- Manages user sessions and dashboard

## Compiling and Running

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Windows Command Prompt or PowerShell

### Compilation Steps

1. **Navigate to the project directory:**
   ```bash
   cd "d:\java CA task 4"
   ```

2. **Compile all Java files:**
   ```bash
   javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java
   ```

3. **Run the application:**
   ```bash
   java -cp bin com.hotel.reservation.HotelReservationSystem
   ```

### Alternative: One-Step Compilation (from project root)
```bash
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java && java -cp bin com.hotel.reservation.HotelReservationSystem
```

## How to Use

### 1. **First Time Setup**
   - When you run the application, sample data (5 rooms) is automatically created
   - The `data/` folder and CSV files are created automatically

### 2. **User Registration**
   - Select "Register" from the main menu
   - Enter your name, email, and phone number
   - You'll be automatically logged in after registration

### 3. **Search Rooms**
   - Use "View Available Rooms" to see all available rooms
   - Use "View Room by Type" to filter by Standard/Deluxe/Suite
   - Each room shows its ID, type, price, and description

### 4. **Make a Reservation**
   - Select "Book a Room"
   - Choose a room ID
   - Enter check-in and check-out dates (YYYY-MM-DD format)
   - Review the booking confirmation
   - Enter payment details:
     - Cardholder Name
     - Card Number (16 digits)
     - Expiry Date (MM/YY format)
   - Payment has 90% success rate (simulated)

### 5. **View Your Bookings**
   - Select "View My Bookings"
   - See all your bookings with detailed information

### 6. **Cancel a Booking**
   - Select "Cancel a Booking"
   - Choose from your confirmed bookings
   - Confirm cancellation
   - Room becomes available again

### 7. **Logout**
   - Select "Logout" to return to the main menu

## Sample Test Data

The system includes 5 pre-configured rooms:

| Room ID | Type    | Price/Night | Description                              |
|---------|---------|-------------|------------------------------------------|
| 1       | Standard| $100.00     | Basic room with single bed               |
| 2       | Standard| $100.00     | Basic room with single bed               |
| 3       | Deluxe  | $150.00     | Spacious room with double bed and sea view |
| 4       | Deluxe  | $150.00     | Spacious room with double bed and sea view |
| 5       | Suite   | $250.00     | Luxury suite with living room and jacuzzi |

## Features Demonstrated

### ✓ Object-Oriented Programming
- Four main entity classes with encapsulation
- Proper use of getters/setters
- Constructor initialization

### ✓ Modular Design
- Separation between models, utilities, and UI
- Each class has single responsibility
- Easy to extend and maintain

### ✓ Data Persistence
- CSV-based storage system
- Automatic file management
- Data survives application restarts

### ✓ User Management
- User registration and authentication
- User dashboard
- Personal booking history

### ✓ Payment Processing
- Payment validation
- Transaction simulation
- Booking confirmation workflow

### ✓ Business Logic
- Room availability management
- Automatic price calculation
- Booking status tracking

## Data Format

### rooms.csv
```
roomId,roomType,pricePerNight,isAvailable,description
```

### bookings.csv
```
bookingId,userId,roomId,checkInDate,checkOutDate,totalPrice,status,bookingDate
```

### users.csv
```
userId,name,email,phoneNumber
```

## Testing Scenarios

### Scenario 1: Complete Booking Flow
1. Register a new user
2. Search available rooms
3. Book a room with dates 2-3 days apart
4. Enter test payment details
5. Verify booking appears in "My Bookings"

### Scenario 2: Room Type Filtering
1. Login
2. Select "View Room by Type"
3. Choose different room types and verify results

### Scenario 3: Booking Cancellation
1. Make a booking
2. View your bookings
3. Cancel the booking
4. Verify room is available again for other users

### Scenario 4: Payment Failure
1. Attempt booking with invalid card number
2. Observe payment rejection
3. Verify booking was cancelled

## Learning Points

This project demonstrates:
- **File I/O**: Reading and writing CSV files
- **Collections**: Using ArrayList and Stream API
- **Exception Handling**: Try-catch blocks for file operations
- **Date/Time API**: Working with LocalDate
- **String Handling**: Parsing and formatting
- **Console Input**: Scanner for user input
- **Business Logic**: Calculating prices and managing state
- **Code Organization**: Package structure and naming conventions

## Future Enhancements

Possible extensions to improve the system:
- Database integration (SQLite, MySQL)
- GUI using Swing or JavaFX
- Email notifications for bookings
- Review and rating system
- Multiple hotel chains support
- Advanced filtering and search
- Admin dashboard
- Real payment gateway integration
- Loyalty program
- Room maintenance scheduling

## Notes for Learning

- The code is written in a student-friendly style with comments
- Each class follows single responsibility principle
- Method names are descriptive and self-documenting
- CSV storage is intentionally simple (not optimized) for educational purposes
- The payment processor simulates real-world validation logic

---

**Created as a learning project for OOP and Java fundamentals**
