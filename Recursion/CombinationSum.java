package Recursion;

import java.util.*;

public class CombinationSum {

    static List<List<Integer>> makeChange(
            int[] coins,
            int target) {

        Arrays.sort(coins);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                coins,
                target,
                0,
                0,
                new ArrayList<>(),
                result);

        return result;
    }

    static void backtrack(
            int[] coins,
            int target,
            int start,
            int sum,
            List<Integer> path,
            List<List<Integer>> result) {

        // Target reached
        if (sum == target) {

            result.add(
                    new ArrayList<>(path));

            return;
        }

        for (int i = start; i < coins.length; i++) {

            // Pruning
            if (sum + coins[i] > target) {

                break;
            }

            // Choose coin
            path.add(coins[i]);

            // Same coin can be reused
            backtrack(
                    coins,
                    target,
                    i,
                    sum + coins[i],
                    path,
                    result);

            // Backtrack
            path.remove(
                    path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] coins = {
                1, 2, 5
        };

        int target = 5;

        List<List<Integer>> ways = makeChange(coins, target);

        System.out.println(
                "Possible combinations:");

        for (List<Integer> way : ways) {

            System.out.println(way);
        }
    }
}
