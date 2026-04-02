# BookMyStayApp
Overview

This project demonstrates a Hotel Booking Management System built using Core Java and data structures.
The focus is on understanding core logic, system behavior, and real-world problem solving such as request handling and system consistency.

✅ Use Case 1: Application Entry & Welcome Message
🎯 Goal

To create a clear starting point for the application and demonstrate how a Java program executes.

👤 Actor
User runs the application via Command Line / IDE
🔄 Flow
User runs the program
JVM invokes main() method
Application prints welcome message
Application terminates
💡 Key Concepts
Class → Basic unit of Java program
main() Method → Entry point of execution
static Keyword → Allows execution without object creation
Console Output → System.out.println()
String Literals → Immutable text values
Method Invocation → Calling methods on objects
Program Flow → Top-to-bottom execution
JavaDoc Comments → Code documentation
Annotations → @author, @version
🛠 Requirements
Create a Java class
Implement main() method
Print welcome message
Show app name & version
Add JavaDoc comments
Ensure error-free execution
💻 Sample Code
/**
* Book My Stay App - Entry Point
* @author Student
* @version 1.0
  */
  public class UseCase1HotelBookingApp {

  public static void main(String[] args) {
  System.out.println("Welcome to Book My Stay App!");
  System.out.println("Hotel Booking System v1.0");
  }
  }
  ▶️ How to Run
  javac UseCase1HotelBookingApp.java
  java UseCase1HotelBookingApp
  🎯 Output
  Welcome to Book My Stay App!
  Hotel Booking System v1.0
  🚀 Benefits
  Clear application entry point
  Easy debugging
  Structured program flow
  Foundation for future features