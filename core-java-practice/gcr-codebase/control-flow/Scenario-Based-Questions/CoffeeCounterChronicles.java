import java.util.Scanner;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final double GST_RATE = 0.18; // 18% GST

        while (true) {
            System.out.print("Enter coffee type (Espresso, Latte, Cappuccino, Mocha) or 'exit' to quit: ");
            String coffeeType = sc.nextLine();

            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Cafe closed. Thank you!");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // consume newline

            double price = 0;

            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    price = 120;
                    break;

                case "latte":
                    price = 150;
                    break;

                case "cappuccino":
                    price = 180;
                    break;

                case "mocha":
                    price = 200;
                    break;

                default:
                    System.out.println("Invalid coffee type!");
                    continue;
            }

            double totalBill = price * quantity;
            double gst = totalBill * GST_RATE;
            double finalAmount = totalBill + gst;

            System.out.println("\n----- BILL -----");
            System.out.println("Coffee Type : " + coffeeType);
            System.out.println("Quantity    : " + quantity);
            System.out.println("Bill Amount : ₹" + totalBill);
            System.out.println("GST (18%)   : ₹" + gst);
            System.out.println("Total Amount: ₹" + finalAmount);
            System.out.println("----------------\n");
        }

        sc.close();
    }
}
