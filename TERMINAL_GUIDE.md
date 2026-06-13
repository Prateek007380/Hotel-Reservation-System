# Terminal Usage Guide

## 🚀 Easy Methods (Recommended)

### Method 1: Double-click the batch files
- **To compile only:** Double-click `compile.bat`
- **To compile and run:** Double-click `build-and-run.bat`

### Method 2: Run from Command Prompt/PowerShell

**Navigate to project folder:**
```bash
cd d:\java CA task 4
```

**Then use one of these commands:**

#### Compile only:
```bash
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java
```

#### Compile and run:
```bash
javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java && java -cp bin com.hotel.reservation.HotelReservationSystem
```

#### Just run (if already compiled):
```bash
java -cp bin com.hotel.reservation.HotelReservationSystem
```

---

## ⚠️ What NOT to do

❌ **WRONG** - This causes errors:
```bash
cd d:\java CA task 4\src\com\hotel\reservation
javac HotelReservationSystem.java
```

❌ **WRONG** - Incomplete command:
```bash
javac HotelReservationSystem.java
```

---

## 📝 Key Points

1. **Always compile from project root** (`d:\java CA task 4`)
2. **Include all source files** in compilation command
3. **Use `-d bin`** to output compiled classes to bin directory
4. **Package name is important** - `com.hotel.reservation.HotelReservationSystem`

---

## 🎯 Quick Reference

| What to Do | Command |
|-----------|---------|
| Navigate to project | `cd d:\java CA task 4` |
| Compile everything | `javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java` |
| Run application | `java -cp bin com.hotel.reservation.HotelReservationSystem` |
| Do both at once | `javac -d bin src\com\hotel\reservation\*.java src\com\hotel\reservation\models\*.java src\com\hotel\reservation\utils\*.java && java -cp bin com.hotel.reservation.HotelReservationSystem` |

---

## 💡 Pro Tips

- Use batch files for one-click compilation and execution
- Always check for errors before trying to run
- If you get "class not found" errors, make sure you compiled first
- If you get "package not found" errors, make sure you're in the project root directory

---

## ✅ Verification

To verify your setup is working:
```bash
cd d:\java CA task 4
ls bin\com\hotel\reservation\*.class
```

You should see 7 `.class` files listed
