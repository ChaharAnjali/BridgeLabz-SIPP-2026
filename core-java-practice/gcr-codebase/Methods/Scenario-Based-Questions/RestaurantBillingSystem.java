import java.util.Scanner;

public class RestaurantBillingSystem {

    static Scanner sc = new Scanner(System.in);

    
    public static double calculateFoodCost(double price, int quantity) {
        return price * quantity;
    }

    
    public static double calculateGST(double foodCost) {
        return foodCost * 0.05;
    }

    
    public static double calculateDiscount(double foodCost) {
        if (foodCost >= 1000) {
            return foodCost * 0.10;
        } else {
            return 0;
        }
    }

    
    public static double generateFinalBill(double foodCost,
                                           double gst,
                                           double discount) {
        return foodCost + gst - discount;
    }

    
    public static void main(String[] args) {

        System.out.print("Enter Food Item Name: ");
        String itemName = sc.nextLine();

        System.out.print("Enter Price per Item: ₹");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

       
        double foodCost = calculateFoodCost(price, quantity);
        double gst = calculateGST(foodCost);
        double discount = calculateDiscount(foodCost);
        double finalAmount = generateFinalBill(foodCost, gst, discount);

        
        System.out.println("\n------- RESTAURANT BILL -------");
        System.out.println("Food Item      : " + itemName);
        System.out.println("Price per Item : ₹" + price);
        System.out.println("Quantity       : " + quantity);
        System.out.println("Food Cost      : ₹" + foodCost);
        System.out.println("GST (5%)       : ₹" + gst);
        System.out.println("Discount       : ₹" + discount);
        System.out.println("--------------------------------");
        System.out.println("Payable Amount : ₹" + finalAmount);

        sc.close();
    }
}
