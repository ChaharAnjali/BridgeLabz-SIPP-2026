public class MathWizard {

    
    private String wizardName = "Math Wizard";

    
    public boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    
    public long factorial(int n) {
        long result = 1;   // local variable

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    
    public double factorial(double n) {
        
        double result = 1;

        for (int i = 1; i <= (int) n; i++) {
            result *= i;
        }

        return result;
    }

    
    public int fibonacci(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1, c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    
    public long power(int base, int exp) {
        long result = 1;

        for (int i = 1; i <= exp; i++) {
            result *= base;
        }

        return result;
    }

    
    public void scopeDemo() {
        int localVariable = 100;  // local variable

        System.out.println("Instance variable (wizardName): " + wizardName);
        System.out.println("Local variable (localVariable): " + localVariable);
    }

    
    public static void main(String[] args) {

        MathWizard mw = new MathWizard();

        System.out.println("Is Prime (7): " + mw.isPrime(7));
        System.out.println("Factorial (5): " + mw.factorial(5));
        System.out.println("Factorial (5.0): " + mw.factorial(5.0));

        System.out.println("Fibonacci (7): " + mw.fibonacci(7));

        System.out.println("GCD (48, 18): " + mw.gcd(48, 18));
        System.out.println("LCM (48, 18): " + mw.lcm(48, 18));

        System.out.println("Power (2^5): " + mw.power(2, 5));

        System.out.println("\n--- Scope Demo ---");
        mw.scopeDemo();
    }
}