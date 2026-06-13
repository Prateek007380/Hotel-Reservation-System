# OOP Concepts Explained in Hotel Reservation System

This document explains how Object-Oriented Programming principles are applied in this project.

## 1. Classes and Objects

### What is a Class?
A class is a blueprint for creating objects. It defines attributes and methods.

### Example in Our Project:

**Room.java** is a class:
```java
public class Room {
    private int roomId;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private String description;
    
    // Constructor - creates a Room object
    public Room(int roomId, String roomType, double pricePerNight, 
                boolean isAvailable, String description) {
        // Initialize attributes
    }
}
```

**Creating Objects (Instances):**
```java
// In Hotel.java
Room room1 = new Room(1, "Standard", 100.0, true, "Basic room with single bed");
Room room2 = new Room(2, "Deluxe", 150.0, true, "Spacious room");
```

Each room is a separate object with its own properties.

---

## 2. Encapsulation

### What is Encapsulation?
Hiding internal details of an object and providing controlled access through methods.

### Implementation:

```java
public class Room {
    // PRIVATE attributes - cannot be accessed directly from outside
    private int roomId;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    
    // PUBLIC getter - controlled read access
    public int getRoomId() {
        return roomId;
    }
    
    // PUBLIC setter - controlled write access with validation
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
}
```

### Benefits:
- **Data Protection**: Cannot accidentally modify room properties
- **Validation**: Setters can validate data before storing
- **Flexibility**: Can change internal implementation without affecting external code
- **Maintenance**: Easier to modify class behavior

### Real Example in Code:
```java
// In HotelReservationSystem.java
Room room = hotel.getRoomById(3);

// We cannot do this (private):
// room.roomId = -5;  ❌ ERROR

// We must use public methods:
room.setAvailable(false);  ✓ Controlled access
boolean available = room.isAvailable();  ✓ Safe
```

---

## 3. Inheritance

### What is Inheritance?
A class inheriting properties and methods from another class (parent-child relationship).

### Note: Not Used Extensively in This Project

This project keeps the design simple for learning purposes. However, inheritance could be used like:

```java
// Hypothetical example (not in this project)
public class LuxuryRoom extends Room {
    private boolean hasJacuzzi;
    private boolean hasMiniBar;
    
    public LuxuryRoom(int roomId, String roomType, double pricePerNight) {
        super(roomId, roomType, pricePerNight, true, "Luxury room");
    }
}
```

---

## 4. Polymorphism

### What is Polymorphism?
Objects behaving differently based on their context or method overriding.

### Implementation in This Project:

**Method Overriding:**
```java
// In Room.java
@Override
public String toString() {
    return "Room{" +
            "roomId=" + roomId +
            ", roomType='" + roomType + '\'' +
            // ... more fields
            '}';
}

// In Booking.java
@Override
public String toString() {
    return "Booking{" +
            "bookingId=" + bookingId +
            ", userId=" + userId +
            // ... different structure
            '}';
}
```

Both Room and Booking override `toString()` differently - same method name, different behavior!

**Usage:**
```java
System.out.println(room);      // Uses Room's toString()
System.out.println(booking);   // Uses Booking's toString()
```

---

## 5. Abstraction

### What is Abstraction?
Showing only essential features while hiding complexity.

### Implementation:

**User doesn't need to know details:**
```java
// Simple call - abstraction hides complexity
Booking booking = hotel.createBooking(userId, roomId, checkInDate, checkOutDate);

// But internally, it does complex operations:
// - Validates room availability
// - Calculates total price
// - Creates booking object
// - Updates room status
// - Saves to file
```

**FileManager provides abstraction:**
```java
// User just calls this simple method:
List<String> lines = FileManager.readFile(FileManager.getRoomsFile());

// But internally it handles:
// - File existence checking
// - IOException handling
// - Directory creation
// - Stream management
```

---

## 6. Modularity

### What is Modularity?
Breaking a large system into smaller, independent, reusable modules.

### Our Project Structure:

```
Models (Domain Objects)
├── Room.java           - Represents a room
├── User.java           - Represents a user
├── Booking.java        - Represents a booking
└── Hotel.java          - Business logic coordinator

Utils (Helper Classes)
├── FileManager.java    - File I/O operations
└── PaymentProcessor.java - Payment logic

UI
└── HotelReservationSystem.java - User interface
```

### Benefits:
- **Separation of Concerns**: Each class has one job
- **Reusability**: FileManager can be used by any class
- **Testability**: Can test each module independently
- **Maintainability**: Easy to find and fix issues

---

## 7. Composition

### What is Composition?
A class contains objects of other classes (has-a relationship).

### Implementation:

```java
// Hotel class HAS multiple Room objects
public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    
    // Hotel uses these objects
    public void addRoom(Room room) {
        rooms.add(room);
    }
}

// HotelReservationSystem HAS a Hotel
public class HotelReservationSystem {
    private Hotel hotel;
    private User currentUser;
    
    public HotelReservationSystem() {
        this.hotel = new Hotel();
    }
}
```

**Relationship Diagram:**
```
HotelReservationSystem
        ├── contains Hotel
        │   ├── contains List<Room>
        │   ├── contains List<Booking>
        │   └── contains List<User>
        ├── contains User (currentUser)
        └── contains PaymentProcessor
```

---

## 8. Collections and Generics

### What are Collections?
Data structures that hold multiple objects.

### Implementation:

```java
// In Hotel.java
private List<Room> rooms = new ArrayList<>();
private List<Booking> bookings = new ArrayList<>();
private List<User> users = new ArrayList<>();

// Using collections to find specific items
public Room getRoomById(int roomId) {
    return rooms.stream()
            .filter(room -> room.getRoomId() == roomId)
            .findFirst()
            .orElse(null);
}

// Using streams for filtering
public List<Room> getAvailableRooms() {
    return rooms.stream()
            .filter(Room::isAvailable)
            .collect(Collectors.toList());
}
```

### Why Collections?
- Flexible storage of any number of objects
- Built-in methods for searching, filtering, sorting
- Type-safe with Generics (List<Room> instead of List)

---

## 9. Access Modifiers

### What are Access Modifiers?
Keywords that control visibility and accessibility of classes and members.

### In This Project:

```java
// PUBLIC - accessible everywhere
public class Room { }
public Room getRoomById(int roomId) { }
public double getPricePerNight() { }

// PRIVATE - accessible only within the class
private int roomId;
private String roomType;
private void saveToFile() { }

// NO MODIFIER (package-private) - accessible in same package
String roomType;  // visible in com.hotel.reservation.models package
```

### Benefits:
- **Encapsulation**: Private data cannot be accidentally modified
- **API Design**: Public methods form the interface
- **Data Hiding**: Internal details stay hidden

---

## 10. Immutability (Partial)

### What is Immutability?
Objects that cannot be changed after creation.

### Implementation (Partial):

```java
// LocalDate is immutable
LocalDate checkInDate = LocalDate.parse("2026-04-25");
// checkInDate cannot be changed directly

// But our classes ARE mutable (for educational simplicity)
Room room = new Room(1, "Standard", 100.0, true, "Basic room");
room.setAvailable(false);  // Can be changed
```

### When to Use:
- String class is immutable in Java
- LocalDate is immutable
- Thread-safe operations
- In production, consider immutable patterns for data integrity

---

## 11. Design Patterns Used

### Singleton-like Pattern (implicit)
```java
// Single Hotel instance in the application
public class HotelReservationSystem {
    private Hotel hotel;  // Only one Hotel
    
    public HotelReservationSystem() {
        this.hotel = new Hotel();
    }
}
```

### Builder Pattern (could be used)
Current approach:
```java
Room room = new Room(1, "Standard", 100.0, true, "Description");
```

### Data Transfer Object (DTO) Pattern
```java
// CSV conversion follows DTO pattern
public String toCSV() { }
public static Room fromCSV(String csvLine) { }
```

---

## 12. Exception Handling

### What is Exception Handling?
Managing errors gracefully.

### Implementation:

```java
// In FileManager.java
try {
    File file = new File(filename);
    if (file.exists()) {
        lines = Files.readAllLines(Paths.get(filename));
    }
} catch (IOException e) {
    System.err.println("Error reading file: " + e.getMessage());
}

// In Hotel.java
if (checkOutDate.isBefore(checkInDate)) {
    System.out.println("Check-out date must be after check-in date!");
    return null;
}

// In PaymentProcessor.java
if (amount <= 0) {
    System.out.println("Invalid amount. Payment failed.");
    return false;
}
```

### Benefits:
- **Robustness**: Application doesn't crash on errors
- **User Experience**: Clear error messages
- **Debugging**: Easy to track what went wrong

---

## 13. Validation and Error Prevention

### Input Validation:

```java
// Email validation
if (email == null || email.trim().isEmpty()) {
    System.out.println("Email cannot be empty!");
    return null;
}

// Card validation
if (cardNumber == null || cardNumber.length() != 16 || !isNumeric(cardNumber)) {
    System.out.println("Invalid card number. Must be 16 digits.");
    return false;
}

// Date validation
if (checkOutDate.equals(checkInDate)) {
    System.out.println("Check-out date must be after check-in date!");
    return null;
}
```

---

## 14. State Management

### Managing Object State:

```java
// Booking status changes
booking.setStatus("Confirmed");   // After payment
booking.setStatus("Cancelled");   // If cancelled

// Room availability changes
room.setAvailable(false);  // When booked
room.setAvailable(true);   // When cancelled

// User session state
currentUser = user;      // User logs in
currentUser = null;      // User logs out
```

---

## Real-World OOP Example Flow

### User Registration Flow:

1. **Encapsulation**: User enters data in console
2. **Validation**: Check email isn't empty (abstraction of complexity)
3. **Object Creation**: `new User(...)` creates object
4. **Composition**: `hotel.users.add(user)` adds to collection
5. **Persistence**: `saveUsersToFile()` saves object state
6. **State Change**: `currentUser = user` changes application state

```java
public User registerUser(String name, String email, String phoneNumber) {
    // Encapsulation: private validation
    if (email == null || email.trim().isEmpty()) {
        return null;
    }
    
    // Object creation with encapsulated data
    User user = new User(nextUserId++, name, email, phoneNumber);
    
    // Composition: user belongs to hotel
    users.add(user);
    
    // Abstraction: saves details hidden in method
    saveUsersToFile();
    
    return user;
}
```

---

## Learning Path

### Beginner
1. **Classes & Objects**: Understand Room, User, Booking classes
2. **Attributes & Methods**: See how data and behavior are organized
3. **Constructors**: Learn how objects are created

### Intermediate
4. **Encapsulation**: Study private/public usage in Room class
5. **Collections**: Understand List<Room> and how it works
6. **Methods**: See how objects interact (hotel.addRoom(), etc.)

### Advanced
7. **Composition**: How Hotel contains Rooms, Bookings, Users
8. **Design Patterns**: Observer patterns in file persistence
9. **Abstractions**: How complexity is hidden (FileManager, PaymentProcessor)

---

## Exercises

### Exercise 1: Add Validation
Modify `Room.java` to validate that price is positive:
```java
public void setPricePerNight(double pricePerNight) {
    if (pricePerNight > 0) {
        this.pricePerNight = pricePerNight;
    }
}
```

### Exercise 2: Add Method
Add a method to calculate discount price:
```java
public double getDiscountedPrice(double discountPercent) {
    return pricePerNight * (1 - discountPercent / 100);
}
```

### Exercise 3: Extend Functionality
Add a new class `Review.java` with rating and comment, similar to User class structure

### Exercise 4: Use Collections
Filter bookings by month in Hotel class:
```java
public List<Booking> getBookingsByMonth(int month) {
    return bookings.stream()
            .filter(b -> b.getCheckInDate().getMonthValue() == month)
            .collect(Collectors.toList());
}
```

---

## Key Takeaways

✅ **Classes** organize code into logical units  
✅ **Encapsulation** protects data and provides controlled access  
✅ **Composition** builds complex objects from simpler ones  
✅ **Collections** manage multiple objects efficiently  
✅ **Abstraction** hides complexity and provides simple interfaces  
✅ **Validation** ensures data integrity  
✅ **Modularity** makes code reusable and maintainable  

---

This project demonstrates practical OOP in a real-world application!
