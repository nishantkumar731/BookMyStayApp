# 🏨 Book My Stay – Hotel Booking Management System (v5.0)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System built using **Core Java**.  
The project demonstrates how **data structures and object-oriented design** are applied to solve real-world software challenges.

This version (**Use Case 5**) focuses on:
- Handling multiple booking requests
- Ensuring fairness using a Queue (FIFO)
- Decoupling request intake from booking allocation

---

## 🎯 Use Case 5: Booking Request (First-Come-First-Served)

### 🧑‍💻 Actors
- **Reservation** – Represents a guest’s booking request
- **BookingRequestQueue** – Manages incoming requests in order

---

## 🔄 Flow
1. Guest submits a booking request
2. Request is added to the queue
3. Requests are stored in arrival order
4. Queue maintains FIFO processing order
5. Requests wait for allocation
6. No inventory update occurs at this stage

---

## 🧠 Concepts Implemented

### 🔹 Problem of Simultaneous Requests
During peak demand:
- Multiple requests arrive at the same time
- Without ordering → unfair booking

---

### 🔹 Queue Data Structure
```java
Queue<Reservation> queue = new LinkedList<>();git add .