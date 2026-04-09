
# 🏨 Book My Stay – Hotel Booking Management System (v7.0)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System built using **Core Java**.  
The project demonstrates how **object-oriented programming and data structures** are used to solve real-world challenges such as booking management, inventory consistency, and prevention of double-booking.

This version (**Use Case 7**) focuses on:
- Adding optional services to reservations
- Extending system functionality without modifying core booking logic
- Maintaining clean separation between core and optional features

---

## 🎯 Use Case 7: Add-On Service Selection

### 🧑‍💻 Actors
- **Guest** – Selects additional services
- **AddOnService** – Represents an optional service
- **AddOnServiceManager** – Manages services linked to reservations

---

## 🔄 Flow
1. Guest selects one or more add-on services
2. Services are stored in a list
3. Services are mapped to a reservation ID
4. Additional cost is calculated
5. Core booking and inventory remain unchanged

---

## 🧠 Concepts Implemented

### 🔹 Business Extensibility
- New features (services) added without modifying booking logic
- Demonstrates scalable system design

---

### 🔹 One-to-Many Relationship
- One reservation → multiple services

```java
Map<String, List<AddOnService>> serviceMap;