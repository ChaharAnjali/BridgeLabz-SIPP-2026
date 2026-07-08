package Sorting.Session2;

import java.util.*;

public class MergeCustomerRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] a = new int[n1];

        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] b = new int[n2];

        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < n1) {
            result[k++] = a[i++];
        }

        while (j < n2) {
            result[k++] = b[j++];
        }

        for (i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}