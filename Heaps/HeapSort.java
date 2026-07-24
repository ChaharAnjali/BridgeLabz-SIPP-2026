package Heaps;

import java.util.Arrays;

public class HeapSort {

    // Heap Sort
    static void heapSort(int[] arr) {

        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }

        // Move maximum element to end
        for (int end = n - 1; end > 0; end--) {

            // Swap root(max) with last element
            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;

            // Restore heap property
            siftDownMax(arr, 0, end);
        }
    }

    // Maintain Max Heap
    static void siftDownMax(int[] arr, int i, int size) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // Swap if child is greater
        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            siftDownMax(arr, largest, size);
        }
    }

    public static void main(String[] args) {

        int[] sensorReadings = { 45, 12, 78, 34, 23, 90, 11 };

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(sensorReadings));

        heapSort(sensorReadings);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(sensorReadings));
    }
}