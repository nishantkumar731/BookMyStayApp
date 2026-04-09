/// Version: 12.0

import java.io.*;
import java.util.*;

// Reservation Class (Serializable)
class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

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

// System State (Inventory + Booking History)
class SystemState implements Serializable {
    private static final long serialVersionUID = 1L;

    Map<String, Integer> inventory;
    List<Reservation> bookingHistory;

    public SystemState(Map<String, Integer> inventory, List<Reservation> bookingHistory) {
        this.inventory = inventory;
        this.bookingHistory = bookingHistory;
    }
}

// Persistence Service
class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    // Save state to file
    public void saveState(SystemState state) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(state);
            System.out.println("✅ System state saved successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error saving system state: " + e.getMessage());
        }
    }

    // Load state from file
    public SystemState loadState() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            SystemState state = (SystemState) ois.readObject();
            System.out.println("✅ System state loaded successfully.");
            return state;

        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No previous state found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error loading state. Starting with safe defaults.");
        }

        // Return default state if failure
        Map<String, Integer> defaultInventory = new HashMap<>();
        defaultInventory.put("Single Room", 2);
        defaultInventory.put("Double Room", 1);

        return new SystemState(defaultInventory, new ArrayList<>());
    }
}

// Main Class
public class BookMyStayApp{

    public static void main(String[] args) {

        PersistenceService service = new PersistenceService();

        // Load previous state
        SystemState state = service.loadState();

        Map<String, Integer> inventory = state.inventory;
        List<Reservation> history = state.bookingHistory;

        // Display recovered data
        System.out.println("\n=== Recovered Inventory ===");
        for (String type : inventory.keySet()) {
            System.out.println(type + ": " + inventory.get(type));
        }

        System.out.println("\n=== Recovered Booking History ===");
        if (history.isEmpty()) {
            System.out.println("No previous bookings.");
        } else {
            for (Reservation r : history) {
                r.display();
            }
        }

        // Simulate new booking
        System.out.println("\nAdding new booking...");
        Reservation newRes = new Reservation("Nishant", "Single Room");

        history.add(newRes);
        inventory.put("Single Room", inventory.get("Single Room") - 1);

        // Save updated state
        service.saveState(new SystemState(inventory, history));
    }
}