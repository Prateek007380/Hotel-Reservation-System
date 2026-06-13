#!/bin/bash
# Hotel Reservation System - Compilation and Execution Script for Linux/Mac

echo ""
echo "========================================"
echo "Hotel Reservation System"
echo "========================================"
echo ""

# Create bin directory if it doesn't exist
if [ ! -d "bin" ]; then
    echo "Creating bin directory..."
    mkdir -p bin
    echo ""
fi

# Compile all Java files
echo "Compiling Java files..."
javac -d bin src/com/hotel/reservation/*.java src/com/hotel/reservation/models/*.java src/com/hotel/reservation/utils/*.java

# Check if compilation was successful
if [ $? -ne 0 ]; then
    echo ""
    echo "Compilation failed! Please check the errors above."
    exit 1
fi

echo "Compilation successful!"
echo ""
echo "Starting application..."
echo ""

# Run the application
java -cp bin com.hotel.reservation.HotelReservationSystem
