## 🏨 Book My Stay – Hotel Booking Management System (v3.1)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System built using **Core Java**.  
This project demonstrates how **data structures and object-oriented design** are applied to solve real-world software engineering problems.

This version (**Use Case 3**) focuses on:
- Centralized inventory management
- Efficient state handling using `HashMap`
- Eliminating inconsistencies caused by scattered variables

---

## 🎯 Use Case 3: Centralized Room Inventory Management

### 🧑‍💻 Actor
`RoomInventory` – responsible for managing and providing room availability across the system.

---

## 🔄 Flow
1. Inventory component is initialized
2. Room types are registered with availability
3. Availability is stored in a centralized `HashMap`
4. Availability is accessed and updated via methods
5. Inventory state is displayed

---

## 🧠 Concepts Implemented

### 🔹 Problem of Scattered State
Previously, availability was stored in separate variables:
- Difficult to manage
- Error-prone
- Not scalable

---

### 🔹 HashMap (Core Concept)
```java
HashMap<String, Integer> inventory;