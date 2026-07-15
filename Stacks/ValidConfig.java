package Stacks;

import java.util.*;

public class ValidConfig {

    static boolean isValidConfig(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "{[()]}";

        if (isValidConfig(s))
            System.out.println("Valid Configuration");
        else
            System.out.println("Invalid Configuration");
    }
}
