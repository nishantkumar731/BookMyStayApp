
# 🏨 Book My Stay – Hotel Booking Management System (v8.0)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System built using **Core Java**.  
The project demonstrates how **object-oriented programming and data structures** solve real-world challenges such as booking management, inventory consistency, fairness, and system scalability.

This version (**Use Case 8**) focuses on:
- Tracking booking history
- Generating reports for administrative use
- Maintaining an audit trail of confirmed reservations

---

## 🎯 Use Case 8: Booking History & Reporting

### 🧑‍💻 Actors
- **Admin** – Reviews booking history and reports
- **BookingHistory** – Stores confirmed reservations
- **BookingReportService** – Generates reports

---

## 🔄 Flow
1. Booking is successfully confirmed
2. Reservation is added to booking history
3. History maintains records in insertion order
4. Admin requests reports
5. Data is retrieved and displayed
6. Stored data remains unchanged

---

## 🧠 Concepts Implemented

### 🔹 Operational Visibility
- Enables tracking of past bookings
- Helps analyze system behavior

---

### 🔹 List Data Structure
```java
List<Reservation> bookingHistory;