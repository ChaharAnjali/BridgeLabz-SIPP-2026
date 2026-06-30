import java.util.ArrayList;

public class SmartParkingManager {

    ArrayList<String> parkedVehicles = new ArrayList<>();

    // 1. Add vehicle (Enter parking)
    public void addVehicle(String regNumber) {
        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Vehicle already parked!");
        } else {
            parkedVehicles.add(regNumber);
            System.out.println("Vehicle Entered: " + regNumber);
        }
    }

    // 2. Remove vehicle (Exit parking)
    public void removeVehicle(String regNumber) {
        if (parkedVehicles.remove(regNumber)) {
            System.out.println("Vehicle Exited: " + regNumber);
        } else {
            System.out.println("Vehicle not found in parking!");
        }
    }

    // 3. Search vehicle
    public void searchVehicle(String regNumber) {
        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Vehicle is currently parked: " + regNumber);
        } else {
            System.out.println("Vehicle is NOT parked here.");
        }
    }

    // 4. Display all vehicles + count
    public void displayVehicles() {
        System.out.println("\n--- Parked Vehicles ---");
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles parked.");
        } else {
            for (String vehicle : parkedVehicles) {
                System.out.println(vehicle);
            }
        }
        System.out.println("Total Occupied Slots: " + parkedVehicles.size());
    }

    // Main method
    public static void main(String[] args) {
        SmartParkingManager spm = new SmartParkingManager();

        spm.addVehicle("UP80AB1234");
        spm.addVehicle("DL10XY9876");
        spm.addVehicle("MH12PQ4567");

        spm.displayVehicles();

        spm.searchVehicle("DL10XY9876");

        spm.removeVehicle("UP80AB1234");

        spm.displayVehicles();
    }
}