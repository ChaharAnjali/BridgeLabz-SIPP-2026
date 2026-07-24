package Recursion;

import java.util.*;

public class FeatureFlagSubsets {

    static List<List<String>> generateFlagCombinations(
            String[] flags) {

        List<List<String>> result = new ArrayList<>();

        backtrack(
                flags,
                0,
                new ArrayList<>(),
                result);

        return result;
    }

    static void backtrack(
            String[] flags,
            int index,
            List<String> current,
            List<List<String>> result) {

        // All flags processed
        if (index == flags.length) {

            result.add(
                    new ArrayList<>(current));

            return;
        }

        // Choice 1: Flag ON
        current.add(flags[index]);

        backtrack(
                flags,
                index + 1,
                current,
                result);

        // Undo choice (backtracking)
        current.remove(
                current.size() - 1);

        // Choice 2: Flag OFF
        backtrack(
                flags,
                index + 1,
                current,
                result);
    }

    public static void main(String[] args) {

        String[] flags = {
                "DarkMode",
                "NewCheckout",
                "BetaSearch"
        };

        List<List<String>> combinations = generateFlagCombinations(flags);

        System.out.println(
                "Total Combinations: "
                        + combinations.size());

        for (List<String> combo : combinations) {

            System.out.println(combo);
        }
    }
}
