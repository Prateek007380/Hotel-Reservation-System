@echo off
REM Hotel Reservation System - Compilation and Execution Script

echo.
echo ========================================
echo Hotel Reservation System
echo ========================================
echo.

REM Create bin directory if it doesn't exist
if not exist "bin" (
    echo Creating bin directory...
    mkdir bin
    echo.
)

REM Compile all Java files
echo Compiling Java files...
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java

REM Check if compilation was successful
if %errorlevel% neq 0 (
    echo.
    echo Compilation failed! Please check the errors above.
    pause
    exit /b 1
)

echo Compilation successful!
echo.
echo Starting application...
echo.

REM Run the application
java -cp bin com.hotel.reservation.HotelReservationSystem

pause
