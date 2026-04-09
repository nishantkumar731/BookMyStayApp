git add .🏨 Book My Stay – Hotel Booking Management System (v6.0)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System developed using **Core Java**.  
The project demonstrates how **object-oriented programming and data structures** are applied to solve real-world challenges such as fair request handling, inventory consistency, and prevention of double-booking.

This version (**Use Case 6**) focuses on:
- Booking confirmation and room allocation
- Preventing double-booking using Set
- Maintaining consistency between booking and inventory

---

## 🎯 Use Case 6: Reservation Confirmation & Room Allocation

### 🧑‍💻 Actors
- **BookingService** – Processes booking requests and allocates rooms
- **RoomInventory** – Maintains and updates room availability

---

## 🔄 Flow
1. Booking request is dequeued from the queue (FIFO)
2. System checks room availability
3. Unique room ID is generated
4. Room ID is validated against existing allocations
5. Inventory is updated immediately
6. Reservation is confirmed

---

## 🧠 Concepts Implemented

### 🔹 Problem of Double Booking
Without control:
- Same room may be assigned to multiple guests
- Leads to inconsistent system state

---

### 🔹 Set (Uniqueness Enforcement)
```java
Set<String> allocatedRoomIds = new HashSet<>();