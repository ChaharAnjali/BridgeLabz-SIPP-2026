class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    static void processPayment(double billAmount, double availableAmount)
            throws InsufficientFundsException {

        if (availableAmount < billAmount) {
            throw new InsufficientFundsException("Payment Failed: Insufficient funds.");
        }

        System.out.println("Payment Successful.");
    }

    public static void main(String[] args) {

        try {
            processPayment(5000, 3000);
        }
        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}