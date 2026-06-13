# How to Run Hotel Reservation System

## 📋 Prerequisites
- Java JDK 8 or higher installed
- Windows/Linux/Mac with a terminal/command prompt

## ✅ Project Status
✓ All source files compiled successfully
✓ No modifications needed - project is ready to run

## 🚀 How to Run (Windows)

### Method 1: Using the batch script (Easiest)
```bash
cd "d:\java CA task 4"
run.bat
```

### Method 2: Manual compilation and execution
```bash
cd "d:\java CA task 4"
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java
java -cp bin com.hotel.reservation.HotelReservationSystem
```

## 🚀 How to Run (Linux/Mac)

### Method 1: Using the shell script
```bash
cd "d/java CA task 4"
chmod +x run.sh
./run.sh
```

### Method 2: Manual compilation and execution
```bash
cd "d/java CA task 4"
javac -d bin src/com/hotel/reservation/*.java src/com/hotel/reservation/models/*.java src/com/hotel/reservation/utils/*.java
java -cp bin com.hotel.reservation.HotelReservationSystem
```

## 📱 Application Features

Once the application starts, you can:

1. **Register**: Create a new user account
2. **Login**: Access your personalized dashboard
3. **View Rooms**: Browse available rooms by type (Standard, Deluxe, Suite)
4. **Book Rooms**: Reserve rooms for specific dates
5. **Process Payments**: Complete bookings with payment information
6. **View Bookings**: Check all your reservations
7. **Cancel Bookings**: Cancel confirmed reservations

## 📁 File Structure

```
d:\java CA task 4\
├── src/                      # Source code
│   └── com/hotel/reservation/
│       ├── HotelReservationSystem.java    # Main application
│       ├── models/                        # Data models
│       │   ├── Room.java
│       │   ├── User.java
│       │   ├── Booking.java
│       │   └── Hotel.java
│       └── utils/                         # Utility classes
│           ├── FileManager.java
│           └── PaymentProcessor.java
├── bin/                      # Compiled classes
├── data/                      # Data storage (auto-created)
│   ├── rooms.csv
│   ├── bookings.csv
│   └── users.csv
├── run.bat                   # Windows execution script
└── run.sh                    # Linux/Mac execution script
```

## 🎯 Sample Login Credentials

After registration, you can login with the email you registered. Sample data includes:
- 5 pre-loaded rooms (Standard, Deluxe, Suite)
- Example pricing: Standard ($100), Deluxe ($150), Suite ($250)

## 💾 Data Storage

- User data, bookings, and rooms are stored in CSV files
- Located in the `data/` folder
- Automatically created on first run
- Persistent across application restarts

## ⚙️ OOP Concepts Used

- **Encapsulation**: Private attributes with getters/setters
- **Modular Design**: Separate classes for each responsibility
- **File I/O**: CSV-based data persistence
- **Stream API**: Functional filtering and collection operations

## ❓ Troubleshooting

**Issue**: "javac: command not found"
- Solution: Install Java JDK and add it to PATH

**Issue**: "No rooms available"
- Solution: This is normal on first run. Restart the application.

**Issue**: "Port already in use" (if running server)
- Solution: The application runs locally without server, no port issues.

---
**Project Status**: ✅ Ready to run - No modifications required
