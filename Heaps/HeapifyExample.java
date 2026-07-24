package Heaps;

import java.util.Arrays;

public class HeapifyExample {

    // Build Min Heap
    static void buildHeap(int[] priorities) {

        int n = priorities.length;

        // Last non-leaf node se root tak
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(priorities, i, n);
        }
    }

    // Maintain Min Heap property
    static void siftDown(int[] arr, int i, int size) {

        int smallest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // Check right child
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // Swap if child is smaller
        if (smallest != i) {

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Continue downward
            siftDown(arr, smallest, size);
        }
    }

    public static void main(String[] args) {

        int[] shipmentPriority = { 40, 20, 30, 10, 50, 60, 15 };

        System.out.println("Before Heapify:");
        System.out.println(Arrays.toString(shipmentPriority));

        buildHeap(shipmentPriority);

        System.out.println("After Heapify (Min Heap):");
        System.out.println(Arrays.toString(shipmentPriority));
    }
}
