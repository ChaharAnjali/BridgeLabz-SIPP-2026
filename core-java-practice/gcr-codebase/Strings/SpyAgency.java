import java.util.HashMap;
import java.util.Map;

public class SpyAgency {

    public static String reverseMessage(String msg) {
        return new StringBuilder(msg).reverse().toString();
    }

    // check palindrome
    public static boolean isPalindrome(String msg) {
        String cleaned = msg.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    // 3. Count vowels and consonants
    public static void countVowelsConsonants(String msg) {
        int vowels = 0, consonants = 0;

        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char c = Character.toLowerCase(ch);
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // 4. Check anagram
    public static boolean areAnagrams(String s1, String s2) {
        s1 = s1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        s2 = s2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    // 5. First non-repeating character
    public static Character firstNonRepeating(String log) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : log.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : log.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

    // Main method
    public static void main(String[] args) {
        String secret = "Radar";
        String intercept1 = "listen";
        String intercept2 = "silent";
        String log = "surveillance";

        System.out.println("Original: " + secret);
        System.out.println("Reversed: " + reverseMessage(secret));
        System.out.println("Palindrome: " + isPalindrome(secret));

        countVowelsConsonants(secret);

        System.out.println("Anagrams: " + areAnagrams(intercept1, intercept2));

        System.out.println("First Non-Repeating Character: " + firstNonRepeating(log));
    }
}