import java.util.Scanner;

public class WarehouseStockRecoverySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        int[] stock = new int[n];

        
        System.out.println("Enter stock quantities:");
        for (int i = 0; i < n; i++) {
            System.out.print("Product " + (i + 1) + ": ");
            stock[i] = sc.nextInt();
        }

        int zeroPosition = -1;
        int sum = 0;
        int count = 0;

        
        for (int i = 0; i < n; i++) {

            if (stock[i] == 0) {
                zeroPosition = i;
            } else {
                sum += stock[i];
                count++;
            }
        }

        
        int average = sum / count;

        
        stock[zeroPosition] = average;

        // Display results
        System.out.println("\n----- Inventory Recovery Report -----");

        System.out.println("Missing stock found at position: "
                           + (zeroPosition + 1));

        System.out.println("Average stock of non-zero products: "
                           + average);

        System.out.println("\nUpdated Inventory:");

        for (int i = 0; i < n; i++) {
            System.out.println("Product " + (i + 1)
                               + " : " + stock[i]);
        }

        sc.close();
    }
}
