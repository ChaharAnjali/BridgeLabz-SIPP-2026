class PackageThis {
    private String trackingId;
    private double weight;

    // Constructor
    public PackageThis(String trackingId, double weight) {
        this.trackingId = trackingId;
        setWeight(weight); // using setter for validation
    }

    // Getter
    public String getTrackingId() {
        return trackingId;
    }

    public double getWeight() {
        return weight;
    }

    // Setter with validation
    public void setWeight(double weight) {
        if (weight <= 0.0) {
            System.out.println("Error: Weight must be greater than 0.0");
        } else {
            this.weight = weight;
        }
    }
}

// Subclass
class ExpressPackageThis extends PackageThis {
    private String priorityLevel;

    // Constructor
    public ExpressPackageThis(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }

    // Getter
    public String getPriorityLevel() {
        return priorityLevel;
    }

    // Method to print shipping label
    public void printShippingLabel() {
        System.out.println("----- Shipping Label -----");
        System.out.println("Tracking ID   : " + getTrackingId());
        System.out.println("Weight        : " + getWeight());
        System.out.println("Priority Level: " + priorityLevel);
    }
}

// Main class (for testing)
public class Main {
    public static void main(String[] args) {

        // Valid input
        ExpressPackageThis p1 = new ExpressPackageThis("EXP101", 2.5, "Critical");
        p1.printShippingLabel();

        System.out.println();

        // Invalid input
        ExpressPackageThis p2 = new ExpressPackageThis("EXP102", -1.5, "High");
        p2.printShippingLabel();
    }
}