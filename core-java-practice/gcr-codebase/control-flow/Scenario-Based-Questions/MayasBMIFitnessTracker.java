import java.util.Scanner;

public class MayasBMIFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input client's weight in kilograms
        System.out.print("Enter weight (in kg): ");
        double weight = sc.nextDouble();

        // Input client's height in meters
        System.out.print("Enter height (in meters): ");
        double height = sc.nextDouble();

        // Calculate BMI using the formula
        double bmi = weight / (height * height);

        // Display the calculated BMI
        System.out.printf("BMI: %.2f%n", bmi);

        // Determine BMI category using if-else
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi < 25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }

        sc.close();
    }
}
