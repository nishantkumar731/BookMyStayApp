// Version: 6.0

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
}

// Booking Queue (FIFO)
class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation r) {
        queue.offer(r);
    }

    public Reservation getNextRequest() {
        return queue.poll(); // removes from queue
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Inventory Service
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void decreaseAvailability(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }

    public void displayInventory() {
        System.out.println("\n=== Current Inventory ===");
        for (String type : inventory.keySet()) {
            System.out.println(type + ": " + inventory.get(type));
        }
    }
}

// Booking Service (Allocation Logic)
class BookingService {

    private RoomInventory inventory;

    // Track allocated room IDs (uniqueness)
    private Set<String> allocatedRoomIds = new HashSet<>();

    // Map room type → allocated IDs
    private Map<String, Set<String>> roomAllocations = new HashMap<>();

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Generate unique room ID
    private String generateRoomId(String type) {
        return type.substring(0, 2).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 5);
    }

    // Process booking
    public void processBooking(Reservation reservation) {

        String type = reservation.getRoomType();

        System.out.println("\nProcessing request for " + reservation.getGuestName());

        // Check availability
        if (inventory.getAvailability(type) <= 0) {
            System.out.println("❌ No rooms available for " + type);
            return;
        }

        // Generate unique ID
        String roomId;
        do {
            roomId = generateRoomId(type);
        } while (allocatedRoomIds.contains(roomId));

        // Add to set (uniqueness)
        allocatedRoomIds.add(roomId);

        // Add to mapping
        roomAllocations.putIfAbsent(type, new HashSet<>());
        roomAllocations.get(type).add(roomId);

        // Decrease inventory (atomic step)
        inventory.decreaseAvailability(type);

        // Confirm booking
        System.out.println("✅ Booking Confirmed!");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Type: " + type);
        System.out.println("Room ID: " + roomId);
    }

    public void displayAllocations() {
        System.out.println("\n=== Allocated Rooms ===");
        for (String type : roomAllocations.keySet()) {
            System.out.println(type + " -> " + roomAllocations.get(type));
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingService bookingService = new BookingService(inventory);

        // Add booking requests
        queue.addRequest(new Reservation("Nishant", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room"));
        queue.addRequest(new Reservation("Anita", "Single Room")); // should fail

        // Process queue
        while (!queue.isEmpty()) {
            Reservation r = queue.getNextRequest();
            bookingService.processBooking(r);
        }

        // Show final state
        bookingService.displayAllocations();
        inventory.displayInventory();
    }
}