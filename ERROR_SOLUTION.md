# 📚 TERMINAL ERROR SOLUTION GUIDE

## ❌ THE ERROR YOU'RE GETTING

```
D:\java CA task 4\src\com\hotel\reservation>javac HotelReservationSystem.java
HotelReservationSystem.java:4: error: package com.hotel.reservation.utils does not exist
```

## 🎯 THE ROOT CAUSE

You're compiling from the **WRONG DIRECTORY** with an **INCOMPLETE COMMAND**

```
❌ WRONG LOCATION:  D:\java CA task 4\src\com\hotel\reservation
❌ WRONG COMMAND:   javac HotelReservationSystem.java (only 1 file)
```

---

## ✅ THE SOLUTION

### Step 1: Navigate to Project Root
```bash
cd d:\java CA task 4
```

### Step 2: Use the Complete Compilation Command
```bash
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java
```

---

## 🚀 EASIEST WAYS TO RUN (Pick One)

### Method 1: ⭐ Double-Click (EASIEST)
- Double-click the **`start.bat`** file in the project folder
- It will compile and run automatically
- **No terminal knowledge needed!**

### Method 2: Type One Command in Terminal
```bash
cd d:\java CA task 4
start.bat
```

### Method 3: PowerShell Function (Advanced Users)
```powershell
# Import the functions first
. "d:\java CA task 4\hotel-app.ps1"

# Then use one of these commands:
Start-HotelApp      # Compile and run
Compile-HotelApp    # Just compile
```

### Method 4: Manual Commands
```bash
# Navigate to project
cd d:\java CA task 4

# Compile
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java

# Run
java -cp bin com.hotel.reservation.HotelReservationSystem
```

---

## 📋 KEY RULES (MUST REMEMBER)

| ❌ DON'T DO | ✅ DO THIS INSTEAD |
|-------------|-------------------|
| `cd src\com\hotel\reservation` | `cd d:\java CA task 4` |
| `javac HotelReservationSystem.java` | Use the full 3-part javac command or start.bat |
| Compile from src directory | **ALWAYS compile from project root** |
| Compile 1 file only | **Compile ALL 3 parts together** |

---

## 🔍 WHAT WORKS NOW

✓ **start.bat** - One-click solution (Best for beginners)
✓ **build-and-run.bat** - Works from anywhere  
✓ **compile.bat** - Compile only
✓ **Terminal commands** - All working correctly
✓ **PowerShell functions** - For advanced users

---

## ✅ VERIFICATION

After compilation, verify it worked:
```bash
ls bin\com\hotel\reservation\*.class
```

You should see **7 .class files**

---

## 🎓 IMPORTANT CONCEPTS

**Package Structure:**
```
com.hotel.reservation
├── HotelReservationSystem.java
├── models/
│   ├── Hotel.java
│   ├── Room.java
│   ├── User.java
│   └── Booking.java
└── utils/
    ├── FileManager.java
    └── PaymentProcessor.java
```

**Compilation Pattern:**
```
javac -d bin [main] [models] [utils]
```

The compiler needs to see ALL packages at compile time!

---

## 🆘 IF YOU STILL GET ERRORS

1. **Check you're in the right directory:**
   ```bash
   cd d:\java CA task 4
   ```

2. **Delete the bin folder and try again:**
   ```bash
   rm -r bin
   javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java
   ```

3. **Use start.bat instead:**
   - Just double-click `start.bat` in the project folder

---

## 💡 TIPS

- **Most Reliable:** Use `start.bat` - works every time
- **From Terminal:** Always cd to project root first
- **Check Before Running:** Compilation must be successful (0 errors)
- **Multiple Runs:** Once compiled, you only need: `java -cp bin com.hotel.reservation.HotelReservationSystem`

---

## 📞 QUICK REFERENCE

```
REMEMBER: Project Root First, Then Compile All Files!
```

```bash
# The Only Command You Need to Remember
cd d:\java CA task 4 && javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java && java -cp bin com.hotel.reservation.HotelReservationSystem
```

Or just double-click `start.bat`! 🎯
