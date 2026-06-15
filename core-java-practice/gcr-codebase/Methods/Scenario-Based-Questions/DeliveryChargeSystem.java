import java.util.Scanner;

public class DeliveryChargeSystem {

    
    public static double calculateCharge(int distance) {
        return distance * 10;
    }

    
    public static double calculateCharge(int distance, int weight) {
        return (distance * 10) + (weight * 5);
    }

    
    public static double calculateCharge(int distance,
                                         int weight,
                                         boolean expressDelivery) {

        double charge = (distance * 10) + (weight * 5);

        if (expressDelivery) {
            charge += 100;
        }

        return charge;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Delivery Option:");
        System.out.println("1. Distance Only");
        System.out.println("2. Distance + Weight");
        System.out.println("3. Distance + Weight + Express Delivery");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        double finalCharge = 0;

        switch (choice) {

            case 1:
                System.out.print("Enter distance (km): ");
                int distance1 = sc.nextInt();

                finalCharge = calculateCharge(distance1);
                break;

            case 2:
                System.out.print("Enter distance (km): ");
                int distance2 = sc.nextInt();

                System.out.print("Enter weight (kg): ");
                int weight2 = sc.nextInt();

                finalCharge = calculateCharge(distance2, weight2);
                break;

            case 3:
                System.out.print("Enter distance (km): ");
                int distance3 = sc.nextInt();

                System.out.print("Enter weight (kg): ");
                int weight3 = sc.nextInt();

                System.out.print("Express Delivery (true/false): ");
                boolean express = sc.nextBoolean();

                finalCharge = calculateCharge(distance3,
                                              weight3,
                                              express);
                break;

            default:
                System.out.println("Invalid Choice!");
                sc.close();
                return;
        }

        System.out.println("\nFinal Delivery Charge: ₹" + finalCharge);

        sc.close();
    }
}
