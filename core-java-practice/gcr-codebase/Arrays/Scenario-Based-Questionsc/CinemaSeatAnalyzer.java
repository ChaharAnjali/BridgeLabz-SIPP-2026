import java.util.Scanner;

public class CinemaSeatAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept total number of seats
        System.out.print("Enter total number of seats: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        // Accept seat status
        System.out.println("Enter seat status (0 = Empty, 1 = Booked):");

        for (int i = 0; i < n; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            seats[i] = sc.nextInt();
        }

        int booked = 0;
        int available = 0;

        int currentLength = 0;
        int maxLength = 0;

        int currentStart = 0;
        int longestStart = -1;
        int longestEnd = -1;

        
        for (int i = 0; i < n; i++) {

            if (seats[i] == 1) {
                booked++;

                currentLength = 0;
            } else {
                available++;

                
                if (currentLength == 0) {
                    currentStart = i;
                }

                currentLength++;

                
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    longestStart = currentStart;
                    longestEnd = i;
                }
            }
        }

       
        System.out.println("\n----- Cinema Seat Report -----");

        System.out.println("Total Booked Seats   : " + booked);
        System.out.println("Total Available Seats: " + available);

        if (maxLength > 0) {
            System.out.println("\nLongest Continuous Block of Available Seats:");
            System.out.println("Starting Position: " + (longestStart + 1));
            System.out.println("Ending Position  : " + (longestEnd + 1));
            System.out.println("Block Size       : " + maxLength);
        } else {
            System.out.println("\nNo available seats found.");
        }

        
        if (maxLength >= 5) {
            System.out.println("\nSuggestion: YES");
            System.out.println("A group of 5 people can sit together.");
        } else {
            System.out.println("\nSuggestion: NO");
            System.out.println("A group of 5 people cannot sit together.");
        }

        sc.close();
    }
}