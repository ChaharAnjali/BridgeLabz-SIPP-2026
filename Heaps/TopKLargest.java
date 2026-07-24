package Heaps;

import java.util.*;

public class TopKLargest {

    static List<Integer> topKLargest(int[] transactions, int k) {

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int amount : transactions) {

            // First k elements add karo
            if (minHeap.size() < k) {

                minHeap.offer(amount);

            }

            // Agar new value smallest top-k se badi hai
            else if (amount > minHeap.peek()) {

                minHeap.poll(); // Remove smallest
                minHeap.offer(amount);
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {

        int[] transactions = {
                5000, 12000, 3000, 25000, 8000, 15000, 40000
        };

        int k = 3;

        List<Integer> result = topKLargest(transactions, k);

        System.out.println("Top " + k + " Highest Spending Customers:");
        System.out.println(result);
    }
}