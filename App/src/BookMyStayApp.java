

    // Abstract Class
    abstract class Room {
        private String type;
        private int beds;
        private double size;
        private double price;

        // Constructor
        public Room(String type, int beds, double size, double price) {
            this.type = type;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        // Getters (Encapsulation)
        public String getType() {
            return type;
        }

        public int getBeds() {
            return beds;
        }

        public double getSize() {
            return size;
        }

        public double getPrice() {
            return price;
        }

        // Common method
        public void displayRoomDetails() {
            System.out.println("Room Type: " + type);
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sq.ft");
            System.out.println("Price: ₹" + price);
        }
    }

    // Single Room Class
    class SingleRoom extends Room {
        public SingleRoom() {
            super("Single Room", 1, 200, 1500);
        }
    }

    // Double Room Class
    class DoubleRoom extends Room {
        public DoubleRoom() {
            super("Double Room", 2, 350, 2500);
        }
    }

    // Suite Room Class
    class SuiteRoom extends Room {
        public SuiteRoom() {
            super("Suite Room", 3, 600, 5000);
        }
    }

    // Main Class
    public class BookMyStayApp {

        public static void main(String[] args) {

            // Static availability (simple variables)
            int singleRoomAvailable = 5;
            int doubleRoomAvailable = 3;
            int suiteRoomAvailable = 2;

            // Object creation (Polymorphism)
            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();

            System.out.println("=== Hotel Room Details ===\n");

            // Display Single Room
            single.displayRoomDetails();
            System.out.println("Available: " + singleRoomAvailable);
            System.out.println("--------------------------");

            // Display Double Room
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + doubleRoomAvailable);
            System.out.println("--------------------------");

            // Display Suite Room
            suite.displayRoomDetails();
            System.out.println("Available: " + suiteRoomAvailable);
            System.out.println("--------------------------");

            System.out.println("\nApplication Terminated.");
        }
    }