import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Take age input
            System.out.print("Enter voter's age (-1 to exit): ");
            int age = sc.nextInt();

           
            if (age == -1) {
                System.out.println("Polling booth closed.");
                break;
            }

            
            if (age >= 18) {
                System.out.println("Eligible to vote.");

                // Record vote
                System.out.println("Choose your candidate:");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");

                System.out.print("Enter your vote (1, 2, or 3): ");
                int vote = sc.nextInt();

                
                if (vote >= 1 && vote <= 3) {
                    System.out.println("Vote recorded successfully!");
                } else {
                    System.out.println("Invalid vote. Please select 1, 2, or 3.");
                }

            } else {
                System.out.println("Not eligible to vote.");
            }

            System.out.println();
        }

        sc.close();
    }
}
