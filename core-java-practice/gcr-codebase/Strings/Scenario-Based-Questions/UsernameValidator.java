import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        // Check for spaces
        if (username.contains(" ")) {
            System.out.println("The username contains spaces.");
        } else {
            System.out.println("The username does not contain spaces.");
        }

        
        System.out.println("Total number of characters: " + username.length());

        
        System.out.println("Username in uppercase: " + username.toUpperCase());

        
        String reversed = "";
        
        for (int i = username.length() - 1; i >= 0; i--) {
            reversed = reversed + username.charAt(i);
        }

        if (username.equalsIgnoreCase(reversed)) {
            System.out.println("The username is a palindrome.");
        } else {
            System.out.println("The username is not a palindrome.");
        }

        sc.close();
    }
}