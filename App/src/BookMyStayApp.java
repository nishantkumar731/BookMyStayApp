// Version: 11.0

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

// Thread-Safe Inventory
class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
    }

    // synchronized → critical section
    public synchronized boolean bookRoom(String type) {

        int available = inventory.getOrDefault(type, 0);

        if (available <= 0) {
            return false;
        }

        // simulate delay (to expose race condition if not synchronized)
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        inventory.put(type, available - 1);
        return true;
    }

    public void displayInventory() {
        System.out.println("\n=== Final Inventory ===");
        for (String type : inventory.keySet()) {
            System.out.println(type + ": " + inventory.get(type));
        }
    }
}

// Shared Booking Queue
class BookingQueue {

    private Queue<Reservation> queue = new LinkedList<>();

    public synchronized void addRequest(Reservation r) {
        queue.offer(r);
    }

    public synchronized Reservation getRequest() {
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Booking Processor (Thread)
class BookingProcessor extends Thread {

    private BookingQueue queue;
    private RoomInventory inventory;

    public BookingProcessor(BookingQueue queue, RoomInventory inventory) {
        this.queue = queue;
        this.inventory = inventory;
    }

    @Override
    public void run() {

        while (true) {

            Reservation r;

            // synchronized retrieval
            synchronized (queue) {
                if (queue.isEmpty()) break;
                r = queue.getRequest();
            }

            if (r != null) {
                boolean success = inventory.bookRoom(r.getRoomType());

                if (success) {
                    System.out.println("✅ " + r.getGuestName() +
                            " booked " + r.getRoomType() +
                            " [" + Thread.currentThread().getName() + "]");
                } else {
                    System.out.println("❌ " + r.getGuestName() +
                            " failed to book " + r.getRoomType());
                }
            }
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingQueue queue = new BookingQueue();

        // Simulate multiple requests
        queue.addRequest(new Reservation("Nishant", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room"));
        queue.addRequest(new Reservation("Anita", "Single Room")); // should fail
        queue.addRequest(new Reservation("Kiran", "Double Room"));

        // Create multiple threads
        Thread t1 = new BookingProcessor(queue, inventory);
        Thread t2 = new BookingProcessor(queue, inventory);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        // Start threads
        t1.start();
        t2.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Final state
        inventory.displayInventory();
    }
}