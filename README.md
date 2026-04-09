
# 🏨 Book My Stay – Hotel Booking Management System (v10.0)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System developed using **Core Java**.  
The project demonstrates how **object-oriented programming and data structures** are used to solve real-world challenges such as booking management, inventory consistency, fairness, and prevention of double-booking.

This version (**Use Case 10**) focuses on:
- Booking cancellation
- Safe rollback of system state
- Maintaining inventory consistency after cancellation

---

## 🎯 Use Case 10: Booking Cancellation & Inventory Rollback

### 🧑‍💻 Actors
- **Guest** – Initiates cancellation request
- **CancellationService** – Handles validation and rollback operations
- **RoomInventory** – Restores room availability
- **BookingHistory** – Updates booking records

---

## 🔄 Flow
1. Guest initiates cancellation request
2. System validates if reservation exists
3. Room ID is added to rollback stack
4. Inventory is restored (incremented)
5. Booking is removed from history
6. System state is updated consistently

---

## 🧠 Concepts Implemented

### 🔹 State Reversal (Rollback)
- Undo previously confirmed bookings
- Restore system to consistent state

---

### 🔹 Stack Data Structure (LIFO)
```java
Stack<String> rollbackStack = new Stack<>();