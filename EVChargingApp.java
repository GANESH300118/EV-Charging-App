import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EVChargingStation {
    String name;
    String location;
    String chargerType;
    int availableSlots;

    EVChargingStation(String name, String location, String chargerType, int availableSlots) {
        this.name = name;
        this.location = location;
        this.chargerType = chargerType;
        this.availableSlots = availableSlots;
    }

    void displayStation() {
        System.out.println("Station Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Charger Type: " + chargerType);
        System.out.println("Available Slots: " + availableSlots);
    }
}

class ChargingSlot {
    String timeSlot;
    boolean isBooked;

    ChargingSlot(String timeSlot) {
        this.timeSlot = timeSlot;
        this.isBooked = false;
    }
}

class User {
    String name;
    String vehicleNumber;

    User(String name, String vehicleNumber) {
        this.name = name;
        this.vehicleNumber = vehicleNumber;
    }
}
class ChargingStationFinder {
    List<EVChargingStation> stations;

    ChargingStationFinder() {
        stations = new ArrayList<>();
        stations.add(new EVChargingStation("Station A", "Downtown", "Fast Charger", 3));
        stations.add(new EVChargingStation("Station B", "Uptown", "Standard Charger", 5));
        stations.add(new EVChargingStation("Station C", "Midtown", "Fast Charger", 2));
    }
    List<EVChargingStation> findStations(String location, String chargerType) {
        List<EVChargingStation> filteredStations = new ArrayList<>();
        for (EVChargingStation station : stations) {
            if (station.location.equalsIgnoreCase(location) && station.chargerType.equalsIgnoreCase(chargerType)) {
                filteredStations.add(station);
            }
        }
        return filteredStations;
    }
}
class BookingSystem {
    List<ChargingSlot> slots;

    BookingSystem() {
        slots = new ArrayList<>();
        slots.add(new ChargingSlot("9:00 AM - 10:00 AM"));
        slots.add(new ChargingSlot("10:00 AM - 11:00 AM"));
        slots.add(new ChargingSlot("11:00 AM - 12:00 PM"));
    }

    void bookSlot(int slotNumber) {
        if (!slots.get(slotNumber).isBooked) {
            slots.get(slotNumber).isBooked = true;
            System.out.println("Slot booked successfully for " + slots.get(slotNumber).timeSlot);
        } else {
            System.out.println("Slot is already booked.");
        }
    }

    void displayAvailableSlots() {
        System.out.println("Available Slots:");
        for (int i = 0; i < slots.size(); i++) {
            if (!slots.get(i).isBooked) {
                System.out.println((i + 1) + ". " + slots.get(i).timeSlot);
            }
        }
    }
}

public class EVChargingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ChargingStationFinder finder = new ChargingStationFinder();
        BookingSystem bookingSystem = new BookingSystem();

        System.out.println("Welcome to the EV Charging Station Finder and Slot Booking System");

        System.out.print("Enter your preferred location: ");
        String location = scanner.nextLine();

        System.out.print("Enter your preferred charger type (e.g., Fast Charger, Standard Charger): ");
        String chargerType = scanner.nextLine();

        List<EVChargingStation> availableStations = finder.findStations(location, chargerType);

        if (availableStations.isEmpty()) {
            System.out.println("No stations found for your criteria.");
        } else {
            System.out.println("Available Stations:");
            for (int i = 0; i < availableStations.size(); i++) {
                System.out.println((i + 1) + ". " + availableStations.get(i).name + " at " + availableStations.get(i).location);
            }

            System.out.print("Select a station to book a slot (enter the number): ");
            int stationChoice = scanner.nextInt();

            if (stationChoice > 0 && stationChoice <= availableStations.size()) {
                EVChargingStation selectedStation = availableStations.get(stationChoice - 1);
                selectedStation.displayStation();

                System.out.println("\nBooking a slot at " + selectedStation.name + "...");
                bookingSystem.displayAvailableSlots();

                System.out.print("Select a slot to book (enter the number): ");
                int slotChoice = scanner.nextInt();

                if (slotChoice > 0 && slotChoice <= bookingSystem.slots.size()) {
                    bookingSystem.bookSlot(slotChoice - 1);
                } else {
                    System.out.println("Invalid slot choice.");
                }
            } else {
                System.out.println("Invalid station choice.");
            }
        }

        scanner.close();
    }
}
