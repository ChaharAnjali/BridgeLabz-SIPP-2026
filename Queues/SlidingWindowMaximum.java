package Queues;

import java.util.*;

public class SlidingWindowMaximum {

    static int[] maxThroughputWindow(
            int[] readings,
            int k) {

        int n = readings.length;

        int[] result = new int[n - k + 1];

        // Stores indices in decreasing order
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove elements outside window
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // Remove smaller values from back
            while (!deque.isEmpty()
                    && readings[deque.peekLast()] <= readings[i]) {

                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Window completed
            if (i >= k - 1) {

                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] readings = {
                10, 5, 8, 12, 7, 9
        };

        int k = 3;

        int[] maximum = maxThroughputWindow(
                readings,
                k);

        System.out.println(
                Arrays.toString(maximum));
    }
}