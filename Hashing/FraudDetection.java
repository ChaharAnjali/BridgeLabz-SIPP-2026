package Hashing;

import java.util.*;

public class FraudDetection {

    public static int[] findFraudPair(int[] amounts, int target) {

        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {

            int complement = target - amounts[i];

            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }

            seen.put(amounts[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] amounts = new int[n];

        for (int i = 0; i < n; i++) {
            amounts[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int[] ans = findFraudPair(amounts, target);

        System.out.println(ans[0] + " " + ans[1]);

        sc.close();
    }
}
