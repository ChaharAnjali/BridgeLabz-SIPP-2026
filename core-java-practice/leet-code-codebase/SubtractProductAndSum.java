import java.util.Scanner;

public class SubtractProductAndSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = input.nextInt();

        int result = subtractProductAndSum(n);

        System.out.println("Result: " + result);

        input.close();
    }

    static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n = n / 10;
        }

        return product - sum;
    }
}