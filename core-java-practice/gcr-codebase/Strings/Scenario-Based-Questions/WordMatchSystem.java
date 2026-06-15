import java.util.Arrays;
import java.util.Scanner;

public class WordMatchSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter first skill keyword: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second skill keyword: ");
        String str2 = sc.nextLine();

        
        System.out.println("\nFirst keyword in uppercase: " + str1.toUpperCase());
        System.out.println("Second keyword in uppercase: " + str2.toUpperCase());

        
        System.out.println("\nLength of first keyword: " + str1.length());
        System.out.println("Length of second keyword: " + str2.length());

        
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();

        
        boolean isAnagram = false;

        if (s1.length() == s2.length()) {
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            isAnagram = Arrays.equals(arr1, arr2);
        }

        
        System.out.println("\n----- Result -----");
        if (isAnagram) {
            System.out.println("The two skill keywords are ANAGRAMS.");
            System.out.println("Message: The candidate has entered matching skill patterns.");
        } else {
            System.out.println("The two skill keywords are NOT ANAGRAMS.");
            System.out.println("Message: The candidate has entered different skill patterns.");
        }

        sc.close();
    }
}