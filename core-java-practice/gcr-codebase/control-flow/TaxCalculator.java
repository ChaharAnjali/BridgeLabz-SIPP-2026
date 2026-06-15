import java.util.Scanner;

public class TaxCalculator {

    
    public static double calculateTax(double income) {
        if (income < 10000) {
            return income * 0.05;
        } else if (income <= 50000) {
            return income * 0.15;
        } else {
            return income * 0.30;
        }
    }

    
    public static String getBracket(double income) {
        if (income < 10000) {
            return "5%";
        } else if (income <= 50000) {
            return "15%";
        } else {
            return "30%";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter citizen's income: ");
        double singleIncome = scanner.nextDouble();
        
        String bracket = getBracket(singleIncome);
        double tax = calculateTax(singleIncome);
        
        System.out.println("Tax Bracket: " + bracket);
        System.out.printf("Tax Amount: %.2f\n\n", tax);

        
        double[] citizensIncomes = {8000, 12000, 45000, 60000, 9500, 25000, 70000, 15000, 4000, 55000};
        double totalTaxCollected = 0;

        System.out.println("Processing 10 Citizens from Array:");
        for (int i = 0; i < citizensIncomes.length; i++) {
            double currentIncome = citizensIncomes[i];
            String currentBracket = getBracket(currentIncome);
            double currentTax = calculateTax(currentIncome);
            
            totalTaxCollected += currentTax;
            
            System.out.printf("Citizen %d - Income: %.2f, Bracket: %s, Tax: %.2f\n", 
                              (i + 1), currentIncome, currentBracket, currentTax);
        }

        System.out.printf("\nTotal Tax Collected: %.2f\n", totalTaxCollected);
        scanner.close();
    }
}