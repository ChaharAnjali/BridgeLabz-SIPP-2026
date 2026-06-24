package Java_Interface;

// Interface
interface CouponValidator {

    // Abstract method
    boolean validateCoupon(String code);

    // Static method
    static boolean isLengthValid(String code) {
        return code.length() >= 5 && code.length() <= 10;
    }
}

// Class implementing interface
class ShoppingCart implements CouponValidator {

    // Simple validation rule (you can change logic if needed)
    @Override
    public boolean validateCoupon(String code) {

        // check length using interface static method
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }

        // check format (example: must start with SAVE)
        return code.startsWith("SAVE");
    }

    // Method to check array of coupons
    void checkCoupons(String[] coupons) {
        for (String code : coupons) {
            if (validateCoupon(code)) {
                System.out.println(code + " → VALID");
            } else {
                System.out.println(code + " → INVALID");
            }
        }
    }
}

// Main class
public class CouponValidatorDemo {
    public static void main(String[] args) {

        String[] coupons = {
                "SAVE10",
                "SAVE50",
                "HELLO123",
                "SAVE",
                "DISCOUNT20"
        };

        ShoppingCart cart = new ShoppingCart();
        cart.checkCoupons(coupons);
    }
}