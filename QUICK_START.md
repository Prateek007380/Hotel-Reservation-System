# Quick Start Guide - Hotel Reservation System

## ⚡ Get Started in 2 Minutes

### Step 1: Compile the Project

**Windows Users:**
Double-click `run.bat` in the project folder, or open Command Prompt and run:
```bash
cd "d:\java CA task 4"
run.bat
```

**Linux/Mac Users:**
Open Terminal and run:
```bash
cd "d:/java CA task 4"
chmod +x run.sh
./run.sh
```

**Manual Compilation (All Platforms):**
```bash
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java
java -cp bin com.hotel.reservation.HotelReservationSystem
```

### Step 2: Follow the Menu

When the application starts, you'll see:
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

## 🎯 Common Tasks

### Register a New Account
1. Press `2` (Register)
2. Enter your name, email, and phone number
3. You're automatically logged in!

### Book a Room
1. From the logged-in menu, press `3` (Book a Room)
2. Choose a room ID from the list
3. Enter check-in date in format: `YYYY-MM-DD` (e.g., `2026-04-25`)
4. Enter check-out date in format: `YYYY-MM-DD` (e.g., `2026-04-27`)
5. Review the booking confirmation
6. Enter payment details:
   - Cardholder name: any name
   - Card number: any 16-digit number
   - Expiry date: MM/YY format (e.g., `12/28`)
7. Payment processes (90% success rate simulated)

### View Your Bookings
1. From the menu, press `4` (View My Bookings)
2. See all your bookings with complete details

### Cancel a Booking
1. From the menu, press `5` (Cancel a Booking)
2. Choose a booking ID from your confirmed bookings
3. Confirm the cancellation

## 📊 Sample Data

The system starts with 5 sample rooms:

**Standard Rooms** (Room IDs: 1, 2)
- Price: $100/night
- Basic room with single bed

**Deluxe Rooms** (Room IDs: 3, 4)
- Price: $150/night
- Spacious room with double bed and sea view

**Suite** (Room ID: 5)
- Price: $250/night
- Luxury suite with living room and jacuzzi

## 💳 Test Payment Details

Use any of these to test payments:

**Valid Card (will likely succeed):**
- Cardholder: John Doe
- Card Number: 4111111111111111
- Expiry: 12/28

**Another Valid Card:**
- Cardholder: Jane Smith
- Card Number: 5500005500005500
- Expiry: 03/27

**Invalid Card (will fail):**
- Cardholder: Test User
- Card Number: 1234567890123456
- Expiry: 99/99

## 📝 Useful Date Examples

For testing bookings, use these date combinations:

**2 Nights Stay:**
- Check-in: 2026-04-25
- Check-out: 2026-04-27
- Cost (Standard): $200

**3 Nights Stay:**
- Check-in: 2026-04-25
- Check-out: 2026-04-28
- Cost (Deluxe): $450

**5 Nights Stay:**
- Check-in: 2026-04-25
- Check-out: 2026-04-30
- Cost (Suite): $1250

## 🐛 Troubleshooting

**"Compilation failed" error**
- Make sure you have Java installed: `java -version`
- Navigate to the correct directory before running
- Check that all .java files are in the correct src folder structure

**"Class not found" error**
- Ensure the `bin` folder was created during compilation
- Try recompiling: `javac -d bin src\...`

**Cannot input dates**
- Use exact format: `YYYY-MM-DD` (e.g., 2026-04-25)
- Cannot use past dates or same day for check-in/check-out

**Payment always fails**
- That's by design! The system has a 90% success rate
- Try multiple times or use different card numbers

## 📁 File Structure After First Run

After running the application once, you'll see:

```
d:\java CA task 4\
├── bin\                    # Compiled Java files
├── data\
│   ├── rooms.csv          # Room information
│   ├── bookings.csv       # Your bookings
│   └── users.csv          # Registered users
└── src\                   # Source code
```

All data is automatically saved to CSV files in the `data/` folder!

## 💡 Tips

- Your data persists! Close the app and open it later - your bookings are still there
- You can have multiple user accounts - try registering different users
- Room availability updates in real-time
- Try cancelling and rebooking to see availability changes
- Check the `data/` folder to see CSV files with your bookings

## 🎓 Learning Points

This project teaches:
- ✓ Object-Oriented Programming (classes, encapsulation)
- ✓ File I/O and CSV handling
- ✓ Collections and Streams
- ✓ Date/Time API
- ✓ User input validation
- ✓ Business logic implementation
- ✓ Modular code design
- ✓ Real-world application structure

## ❓ Need Help?

- Read the full [README.md](README.md) for detailed documentation
- Check the source code comments in the `src/` folder
- Review the OOP principles section in README.md

---

Happy coding! 🚀
