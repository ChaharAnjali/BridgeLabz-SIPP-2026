package Sorting.Session1;

import java.util.*;

public class SelectionSort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = ratings[i];
            ratings[i] = ratings[minIndex];
            ratings[minIndex] = temp;
        }

        // Print sorted array
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(ratings[i]);
            if (i != n - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

        sc.close();
    }
}
