## 🏨 Book My Stay – Hotel Booking Management System (v2.1)

## 📌 Overview
**Book My Stay** is a console-based Hotel Booking Management System built using **Core Java**.  
This project demonstrates how fundamental **Object-Oriented Programming (OOP)** concepts are applied in real-world software design.

This version (**Use Case 2**) focuses on:
- Object modeling using abstraction and inheritance
- Static room availability management
- Clear separation between domain and system state

---

## 🎯 Use Case 2: Basic Room Types & Static Availability

### 🧑‍💻 Actor
User executes the program to view predefined room types and their availability.

### 🔄 Flow
1. User runs the application
2. Room objects are initialized
3. Availability is stored using simple variables
4. Room details and availability are displayed
5. Application terminates

---

## 🧠 Concepts Implemented

### 🔹 Abstraction
An abstract class `Room` defines common attributes:
- Room type
- Number of beds
- Size
- Price

### 🔹 Inheritance
Concrete classes extend `Room`:
- `SingleRoom`
- `DoubleRoom`
- `SuiteRoom`

### 🔹 Polymorphism
All room objects are handled using the `Room` reference type.

### 🔹 Encapsulation
Room properties are private and accessed via getter methods.

### 🔹 Static Availability
Room availability is managed using simple variables:
```java
int singleRoomAvailable = 5;
int doubleRoomAvailable = 3;
int suiteRoomAvailable = 2;