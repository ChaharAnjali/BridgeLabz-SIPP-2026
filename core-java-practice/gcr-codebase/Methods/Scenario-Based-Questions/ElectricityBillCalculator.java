import java.util.Scanner;

public class ElectricityBillCalculator {

    static Scanner sc = new Scanner(System.in);

   
    public static String acceptCustomerName() {
        System.out.print("Enter Customer Name: ");
        return sc.nextLine();
    }

    
    public static int acceptUnits() {
        System.out.print("Enter Units Consumed: ");
        return sc.nextInt();
    }

    
    public static double calculateBill(int units) {
        double bill;

        if (units <= 100) {
            bill = units * 1.50;
        } else if (units <= 200) {
            bill = (100 * 1.50) + ((units - 100) * 2.50);
        } else {
            bill = (100 * 1.50) + (100 * 2.50) + ((units - 200) * 4.00);
        }

        return bill;
    }

    
    public static void displayBill(String name, int units, double amount) {
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Customer Name : " + name);
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount   : ₹" + amount);
    }

    
    public static void main(String[] args) {

        String customerName = acceptCustomerName();

        int units = acceptUnits();

        double billAmount = calculateBill(units);

        displayBill(customerName, units, billAmount);

        sc.close();  
    }
}