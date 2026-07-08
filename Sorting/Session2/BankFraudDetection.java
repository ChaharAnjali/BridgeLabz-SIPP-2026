package Sorting.Session2;

import java.util.*;

public class BankFraudDetection {

    static long mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;

        long count = 0;
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        count += countPairs(arr, left, mid, right);
        merge(arr, left, mid, right);

        return count;
    }

    static long countPairs(int[] arr, int left, int mid, int right) {
        long count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) arr[i] > 3L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] amount = new int[n];

        for (int i = 0; i < n; i++) {
            amount[i] = sc.nextInt();
        }

        System.out.println(mergeSort(amount, 0, n - 1));

        sc.close();
    }
}
