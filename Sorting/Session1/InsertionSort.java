package Sorting.Session1;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] empID = new int[n];

        for (int i = 0; i < n; i++) {
            empID[i] = sc.nextInt();
        }

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = empID[i];
            int j = i - 1;

            while (j >= 0 && empID[j] > key) {
                empID[j + 1] = empID[j];
                j--;
            }

            empID[j + 1] = key;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(empID[i] + " ");
        }

        sc.close();
    }
}
