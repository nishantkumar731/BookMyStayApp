/// Version: 8.0

import java.util.*;

// Reservation Class
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Room: " + roomType);
    }
}

// Booking History (stores confirmed bookings)
class BookingHistory {

    private List<Reservation> bookingHistory;

    public BookingHistory() {
        bookingHistory = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        bookingHistory.add(reservation);
    }

    // Get all bookings (read-only)
    public List<Reservation> getAllBookings() {
        return bookingHistory;
    }
}

// Reporting Service
class BookingReportService {

    // Display all bookings
    public void displayBookings(List<Reservation> bookings) {
        System.out.println("=== Booking History ===\n");

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : bookings) {
            r.display();
        }
    }

    // Generate summary report
    public void generateReport(List<Reservation> bookings) {
        System.out.println("\n=== Booking Report ===");

        int totalBookings = bookings.size();

        // Count per room type
        Map<String, Integer> roomCount = new HashMap<>();

        for (Reservation r : bookings) {
            String type = r.getRoomType();
            roomCount.put(type, roomCount.getOrDefault(type, 0) + 1);
        }

        System.out.println("Total Bookings: " + totalBookings);

        System.out.println("Bookings by Room Type:");
        for (String type : roomCount.keySet()) {
            System.out.println(type + ": " + roomCount.get(type));
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize components
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Simulate confirmed bookings (from Use Case 6)
        history.addReservation(new Reservation("Nishant", "Single Room"));
        history.addReservation(new Reservation("Rahul", "Double Room"));
        history.addReservation(new Reservation("Anita", "Suite Room"));
        history.addReservation(new Reservation("Kiran", "Single Room"));

        // Display history
        reportService.displayBookings(history.getAllBookings());

        // Generate report
        reportService.generateReport(history.getAllBookings());
    }
}