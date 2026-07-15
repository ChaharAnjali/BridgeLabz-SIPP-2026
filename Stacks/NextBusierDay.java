package Stacks;

import java.util.*;

public class NextBusierDay {

    static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                answer[stack.pop()] = visitors[i];
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] visitors = { 100, 80, 120, 90, 150 };

        int[] result = nextBusierDay(visitors);

        System.out.println("Next Greater Visitor Count:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
