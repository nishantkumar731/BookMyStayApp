

// Version: 4.0

import java.util.*;

// Abstract Room Class
abstract class Room {
    private String type;
    private int beds;
    private double size;
    private double price;

    public Room(String type, int beds, double size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq.ft");
        System.out.println("Price: ₹" + price);
    }
}

// Concrete Room Classes
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 200, 1500);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 350, 2500);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 600, 5000);
    }
}

// Inventory Class (State Holder)
class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0); // unavailable
        inventory.put("Suite Room", 2);
    }

    // Read-only access
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Set<String> getAllRoomTypes() {
        return inventory.keySet();
    }
}

// Search Service (Read-only operations)
class RoomSearchService {

    private RoomInventory inventory;
    private Map<String, Room> roomMap;

    public RoomSearchService(RoomInventory inventory, List<Room> rooms) {
        this.inventory = inventory;
        roomMap = new HashMap<>();

        // Map room type → room object
        for (Room room : rooms) {
            roomMap.put(room.getType(), room);
        }
    }

    // Search available rooms
    public void searchAvailableRooms() {
        System.out.println("=== Available Rooms ===\n");

        boolean found = false;

        for (String type : inventory.getAllRoomTypes()) {
            int available = inventory.getAvailability(type);

            // Filter unavailable rooms
            if (available > 0) {
                Room room = roomMap.get(type);

                room.displayRoomDetails();
                System.out.println("Available: " + available);
                System.out.println("--------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms available.");
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Create room objects (domain)
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        // Initialize inventory (state)
        RoomInventory inventory = new RoomInventory();

        // Initialize search service
        RoomSearchService searchService = new RoomSearchService(inventory, rooms);

        // Perform search (read-only)
        searchService.searchAvailableRooms();
    }
}