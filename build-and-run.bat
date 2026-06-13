@echo off
REM Hotel Reservation System - Compile and Run Script

echo.
echo ========================================
echo HOTEL RESERVATION SYSTEM
echo ========================================
echo.

REM Navigate to project root
cd /d "%~dp0"

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
    echo ❌ Compilation FAILED! Please check the errors above.
    echo.
    pause
    exit /b 1
)

echo ✓ Compilation successful!
echo.
echo Running application...
echo.

REM Run the application
java -cp bin com.hotel.reservation.HotelReservationSystem

pause
