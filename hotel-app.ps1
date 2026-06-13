# Hotel Reservation System - PowerShell Helper

function Start-HotelApp {
    Write-Host "`n========================================" -ForegroundColor Cyan
    Write-Host "  HOTEL RESERVATION SYSTEM LAUNCHER" -ForegroundColor Cyan
    Write-Host "========================================`n" -ForegroundColor Cyan

    $projectPath = "d:\java CA task 4"
    
    # Check if project exists
    if (-not (Test-Path $projectPath)) {
        Write-Host "Error: Project path not found at $projectPath" -ForegroundColor Red
        return
    }

    Write-Host "Navigating to project directory..." -ForegroundColor Yellow
    Push-Location $projectPath

    Write-Host "Compiling Java files..." -ForegroundColor Yellow
    javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java 2>&1
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host "`n✓ Compilation SUCCESSFUL`n" -ForegroundColor Green
        Write-Host "Starting application..." -ForegroundColor Cyan
        Write-Host "========================================`n" -ForegroundColor Cyan
        java -cp bin com.hotel.reservation.HotelReservationSystem
    } else {
        Write-Host "`n✗ Compilation FAILED" -ForegroundColor Red
        Write-Host "Please check the errors above" -ForegroundColor Red
    }
    
    Pop-Location
}

function Compile-HotelApp {
    Write-Host "`n========================================" -ForegroundColor Cyan
    Write-Host "  HOTEL RESERVATION SYSTEM COMPILER" -ForegroundColor Cyan
    Write-Host "========================================`n" -ForegroundColor Cyan

    $projectPath = "d:\java CA task 4"
    
    if (-not (Test-Path $projectPath)) {
        Write-Host "Error: Project path not found at $projectPath" -ForegroundColor Red
        return
    }

    Push-Location $projectPath
    
    Write-Host "Creating bin directory..." -ForegroundColor Yellow
    if (-not (Test-Path "bin")) {
        New-Item -ItemType Directory -Name "bin" | Out-Null
    }

    Write-Host "Compiling Java files..." -ForegroundColor Yellow
    javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java 2>&1
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host "`n✓✓✓ Compilation SUCCESSFUL ✓✓✓" -ForegroundColor Green
        Write-Host "`nTo run the application, type:" -ForegroundColor Cyan
        Write-Host "  Start-HotelApp`n" -ForegroundColor Yellow
    } else {
        Write-Host "`n✗ Compilation FAILED" -ForegroundColor Red
    }
    
    Pop-Location
}

# Display menu
Write-Host "`n╔════════════════════════════════════════╗" -ForegroundColor Cyan
Write-Host "║    HOTEL RESERVATION SYSTEM COMMANDS   ║" -ForegroundColor Cyan
Write-Host "╚════════════════════════════════════════╝" -ForegroundColor Cyan
Write-Host "`nAvailable Commands:`n" -ForegroundColor Green
Write-Host "  1. Start-HotelApp    - Compile & Run the application" -ForegroundColor Yellow
Write-Host "  2. Compile-HotelApp  - Compile only`n" -ForegroundColor Yellow
Write-Host "Examples:" -ForegroundColor Green
Write-Host "  PS> Start-HotelApp" -ForegroundColor Cyan
Write-Host "  PS> Compile-HotelApp`n" -ForegroundColor Cyan
