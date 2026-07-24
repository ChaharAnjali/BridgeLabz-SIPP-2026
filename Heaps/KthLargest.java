package Heaps;

import java.util.PriorityQueue;

public class KthLargest {

    static int findKthLargest(int[] scores, int k) {

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int score : scores) {

            // First k scores insert karo
            if (minHeap.size() < k) {

                minHeap.offer(score);

            }

            else if (score > minHeap.peek()) {

                minHeap.poll(); // Remove smallest
                minHeap.offer(score);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] scores = {
                85, 92, 76, 95, 88, 70, 98
        };

        int k = 3;

        int result = findKthLargest(scores, k);

        System.out.println(
                k + "th Largest Score: " + result);
    }
}