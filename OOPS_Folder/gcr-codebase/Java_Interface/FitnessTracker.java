package Java_Interface;

// Interface 1
interface Trackable {
    void logActivity();

    // Default method
    default void resetData() {
        System.out.println("Data reset successfully.");
    }
}

// Interface 2
interface Reportable {
    void generateReport();
}

// Interface 3
interface Notifiable {
    void sendAlert();
}

// Class implementing multiple interfaces
class FitnessDevice implements Trackable, Reportable, Notifiable {

    @Override
    public void logActivity() {
        System.out.println("Activity logged: Running 5km");
    }

    @Override
    public void generateReport() {
        System.out.println("Report generated: Calories burned = 300");
    }

    @Override
    public void sendAlert() {
        System.out.println("Alert: Daily goal achieved!");
    }
}

// Main class
public class FitnessTracker {
    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();

        // default method from interface
        device.resetData();
    }
}
