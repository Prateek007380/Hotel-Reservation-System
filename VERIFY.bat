@echo off
REM Quick verification script
REM Run this to check if everything is set up correctly

cls
echo.
echo ============================================
echo   VERIFICATION SCRIPT
echo ============================================
echo.

cd /d "%~dp0"

echo Checking project structure...
echo.

if not exist "src" (
    echo ERROR: src folder not found!
    goto error
)

if not exist "src\com\hotel\reservation\HotelReservationSystem.java" (
    echo ERROR: HotelReservationSystem.java not found!
    goto error
)

if not exist "src\com\hotel\reservation\models\Hotel.java" (
    echo ERROR: Hotel.java not found!
    goto error
)

if not exist "src\com\hotel\reservation\utils\FileManager.java" (
    echo ERROR: FileManager.java not found!
    goto error
)

echo ✓ All source files found!
echo.

echo Compiling...
if not exist "bin" mkdir bin

javac -d bin ^
    src\com\hotel\reservation\*.java ^
    src\com\hotel\reservation\models\*.java ^
    src\com\hotel\reservation\utils\*.java 2>&1

if %ERRORLEVEL% neq 0 (
    echo.
    echo ERROR: Compilation failed!
    goto error
)

echo ✓ Compilation successful!
echo.

for /f %%A in ('dir /s /b bin\*.class 2^>nul ^| find /c "."') do set COUNT=%%A
echo ✓ Generated %COUNT% class files!
echo.
echo ============================================
echo   ALL CHECKS PASSED!
echo ============================================
echo.
echo You can now run: RUN.bat
echo.
pause
exit /b 0

:error
echo.
echo ============================================
echo   VERIFICATION FAILED
echo ============================================
echo.
pause
exit /b 1
