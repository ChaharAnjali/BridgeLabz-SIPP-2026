import java.util.Scanner;

public class StudentMarksAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        // Accept marks
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Initialize variables
        int highest = marks[0];
        int lowest = marks[0];
        int countAbove75 = 0;
        int sum = 0;

        // Process the array
        for (int i = 0; i < n; i++) {

            // Highest marks
            if (marks[i] > highest) {
                highest = marks[i];
            }

            // Lowest marks
            if (marks[i] < lowest) {
                lowest = marks[i];
            }

            
            if (marks[i] > 75) {
                countAbove75++;
            }

            
            sum += marks[i];
        }

        
        double average = (double) sum / n;

       
        System.out.println("\n----- Student Marks Report -----");
        System.out.println("Highest Marks          : " + highest);
        System.out.println("Lowest Marks           : " + lowest);
        System.out.println("Students Above 75      : " + countAbove75);
        System.out.println("Average Marks          : " + average);

        
        System.out.print("Marks Greater Than Average: ");
        for (int i = 0; i < n; i++) {
            if (marks[i] > average) {
                System.out.print(marks[i] + " ");
            }
        }

        sc.close();
    }
}