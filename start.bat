@echo off
REM Simple one-command compilation from anywhere

setlocal enabledelayedexpansion

REM Navigate to the project root
cd /d "%~dp0"

REM Check if we're in the right directory
if not exist "src\com\hotel\reservation\HotelReservationSystem.java" (
    echo Error: Cannot find project files!
    echo Please make sure you're running this from the project root directory.
    pause
    exit /b 1
)

REM Display banner
cls
echo.
echo ========================================
echo    HOTEL RESERVATION SYSTEM
echo ========================================
echo.

REM Create bin directory
if not exist "bin" mkdir bin

REM Compile
echo Compiling...
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java

if %errorlevel% neq 0 (
    echo.
    echo *** COMPILATION FAILED ***
    echo.
    pause
    exit /b 1
)

echo.
echo ===== COMPILATION SUCCESSFUL =====
echo.
echo Running application...
echo.

REM Run the application
java -cp bin com.hotel.reservation.HotelReservationSystem

pause
