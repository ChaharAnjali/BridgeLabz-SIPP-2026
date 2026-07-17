package Hashing;

import java.util.*;

public class SubarraySum {

    public static int subarraySumEqualsK(int[] revenueChanges, int k) {

        HashMap<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {

            runningSum += change;

            answer += prefixCount.getOrDefault(runningSum - k, 0);

            prefixCount.put(
                    runningSum,
                    prefixCount.getOrDefault(runningSum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] revenueChanges = new int[n];

        for (int i = 0; i < n; i++) {
            revenueChanges[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(subarraySumEqualsK(revenueChanges, k));

        sc.close();
    }
}
