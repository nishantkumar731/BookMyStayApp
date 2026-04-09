# 🏨 Book My Stay – Hotel Booking Management System (v4.0)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System developed using **Core Java**.  
This project demonstrates how **object-oriented design and data structures** are applied to solve real-world software engineering problems.

This version (**Use Case 4**) focuses on:
- Room search functionality
- Read-only access to inventory
- Safe data handling without modifying system state

---

## 🎯 Use Case 4: Room Search & Availability Check

### 🧑‍💻 Actors
- **Guest** – Searches for available rooms
- **RoomSearchService** – Handles read-only search logic

---

## 🔄 Flow
1. Guest initiates room search
2. System retrieves availability from inventory
3. Room details are fetched from room objects
4. Unavailable rooms are filtered out
5. Available rooms are displayed
6. System state remains unchanged

---

## 🧠 Concepts Implemented

### 🔹 Read-Only Access
Search operations **do not modify inventory**, ensuring system stability.

---

### 🔹 Defensive Programming
- Only valid room types are processed
- Rooms with **0 availability are excluded**

---

### 🔹 Separation of Concerns
- `Room` → Defines room details
- `RoomInventory` → Holds availability
- `RoomSearchService` → Handles search logic

---

### 🔹 Inventory as State Holder
Inventory is used only for **reading availability**, not modifying it.

---

### 🔹 Domain Model Usage
Room objects provide:
- Pricing
- Size
- Bed details

---

### 🔹 Validation Logic
Only rooms with:
```java
availability > 0