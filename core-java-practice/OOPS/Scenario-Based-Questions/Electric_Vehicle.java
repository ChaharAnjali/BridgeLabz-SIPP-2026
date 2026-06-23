class ChargingStation {

    // static variables
       static int totalStations = 0;
       static double elctricityRate = 8.5;
    // instance variables
       int stationId;
    double unitsConsumed;

    // constructor
    ChargingStation(int stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }
    void calculateBill() {
        double bill = unitsConsumed * elctricityRate;
        System.out.println("Bill = " + bill);
    }
    void displayStationDetails() {
          System.out.println(" ");
        System.out.println("Station ID : " + stationId);
        System.out.println("Units Consumed : " + unitsConsumed);
        System.out.println("Electricity Rate : " + elctricityRate);
        calculateBill();
        System.out.println(" ");
    }
    
}

public class Electric_Vehicle {
     public static void main(String[] args) {

        // Create 5 Charging Stations
        ChargingStation s1 = new ChargingStation(101, 120);
        ChargingStation s2 = new ChargingStation(102, 150);
        ChargingStation s3 = new ChargingStation(103, 180);
        ChargingStation s4 = new ChargingStation(104, 200);
        ChargingStation s5 = new ChargingStation(105, 250);

        // Display Bills
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        // Change Electricity Rate
        ChargingStation.elctricityRate = 10;

        System.out.println("\nAfter Changing Electricity Rate\n");

        // New Bills
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        // Total Stations
        System.out.println("Total Stations = " + ChargingStation.totalStations);
    }
}

