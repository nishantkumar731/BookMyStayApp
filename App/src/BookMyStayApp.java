

    /// Version: 3.1

    import java.util.HashMap;

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

    // Room Inventory Class (Centralized State)
    class RoomInventory {

        private HashMap<String, Integer> inventory;

        // Constructor → Initialize inventory
        public RoomInventory() {
            inventory = new HashMap<>();

            inventory.put("Single Room", 5);
            inventory.put("Double Room", 3);
            inventory.put("Suite Room", 2);
        }

        // Get availability
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Update availability
        public void updateAvailability(String roomType, int newCount) {
            if (inventory.containsKey(roomType)) {
                inventory.put(roomType, newCount);
            } else {
                System.out.println("Room type not found!");
            }
        }

        // Display inventory
        public void displayInventory() {
            System.out.println("=== Room Inventory ===\n");
            for (String type : inventory.keySet()) {
                System.out.println(type + " Available: " + inventory.get(type));
            }
        }
    }

    // Main Class
    public class BookMyStayApp {

        public static void main(String[] args) {

            // Initialize rooms (domain)
            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();

            // Initialize inventory (state)
            RoomInventory inventory = new RoomInventory();

            // Display initial inventory
            inventory.displayInventory();

            System.out.println("\n--- Updating Inventory ---");

            // Example update (simulate booking)
            int current = inventory.getAvailability("Single Room");
            inventory.updateAvailability("Single Room", current - 1);

            // Display updated inventory
            System.out.println();
            inventory.displayInventory();
        }
    }