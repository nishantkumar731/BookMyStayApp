// Version: 10.0

import java.util.*;

// Reservation Class
class Reservation {
    private String guestName;
    private String roomType;
    private String roomId;

    public Reservation(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }
}

// Inventory Class
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 1);
    }

    public void increaseAvailability(String type) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
    }

    public void displayInventory() {
        System.out.println("\n=== Current Inventory ===");
        for (String type : inventory.keySet()) {
            System.out.println(type + ": " + inventory.get(type));
        }
    }
}

// Booking History
class BookingHistory {
    private Map<String, Reservation> bookings = new HashMap<>();

    public void addReservation(Reservation r) {
        bookings.put(r.getRoomId(), r);
    }

    public Reservation getReservation(String roomId) {
        return bookings.get(roomId);
    }

    public void removeReservation(String roomId) {
        bookings.remove(roomId);
    }
}

// Cancellation Service
class CancellationService {

    private RoomInventory inventory;
    private BookingHistory history;

    // Stack for rollback tracking (LIFO)
    private Stack<String> rollbackStack = new Stack<>();

    public CancellationService(RoomInventory inventory, BookingHistory history) {
        this.inventory = inventory;
        this.history = history;
    }

    public void cancelBooking(String roomId) {

        System.out.println("\nProcessing cancellation for Room ID: " + roomId);

        // Validate reservation
        Reservation r = history.getReservation(roomId);

        if (r == null) {
            System.out.println("❌ Cancellation failed: Reservation not found");
            return;
        }

        // Push to rollback stack
        rollbackStack.push(roomId);

        // Restore inventory
        inventory.increaseAvailability(r.getRoomType());

        // Remove booking from history
        history.removeReservation(roomId);

        System.out.println("✅ Cancellation successful for " + r.getGuestName());
    }

    public void displayRollbackStack() {
        System.out.println("\nRollback Stack (Recent Releases): " + rollbackStack);
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();
        CancellationService cancelService = new CancellationService(inventory, history);

        // Simulate confirmed bookings
        Reservation r1 = new Reservation("Nishant", "Single Room", "SI-101");
        Reservation r2 = new Reservation("Rahul", "Double Room", "DO-201");

        history.addReservation(r1);
        history.addReservation(r2);

        // Perform cancellation
        cancelService.cancelBooking("SI-101"); // valid
        cancelService.cancelBooking("XX-999"); // invalid

        // Show rollback tracking
        cancelService.displayRollbackStack();

        // Show updated inventory
        inventory.displayInventory();
    }
}