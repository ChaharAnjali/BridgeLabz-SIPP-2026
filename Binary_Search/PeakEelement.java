package Binary_Search;

import java.util.*;

public class PeakEelement {

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak
            boolean leftGreater = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightGreater = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            if (leftGreater && rightGreater) {
                return mid;
            }

            // Move to the left half
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Move to the right half
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int peakIndex = findPeak(arr);

        System.out.println("Peak Element: " + arr[peakIndex]);
        System.out.println("Peak Index: " + peakIndex);

        sc.close();
    }
}
