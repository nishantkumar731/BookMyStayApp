# 🏨 Book My Stay – Hotel Booking Management System (v12.0)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System built using **Core Java**.  
The project demonstrates how **object-oriented programming and data structures** are applied to solve real-world challenges such as booking management, inventory consistency, concurrency, and system reliability.

This version (**Use Case 12**) focuses on:
- Data persistence
- System recovery after restart
- Durable storage of booking and inventory state

---

## 🎯 Use Case 12: Data Persistence & System Recovery

### 🧑‍💻 Actors
- **System** – Triggers save/load operations
- **PersistenceService** – Handles storing and retrieving system state

---

## 🔄 Flow
1. System prepares for shutdown
2. Current state is serialized
3. Data is written to a file
4. System restarts
5. Data is read from file
6. State is restored into memory
7. System resumes with recovered data

---

## 🧠 Concepts Implemented

### 🔹 Stateful Application
- System maintains data beyond runtime
- Ensures continuity across restarts

---

### 🔹 Persistence
- Stores data in file (`system_state.dat`)
- Prevents data loss

---

### 🔹 Serialization
```java
class Reservation implements Serializable