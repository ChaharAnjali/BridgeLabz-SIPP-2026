package Graphs;

import java.util.*;

public class DirectedCycleDetection {

    static boolean hasCircularDependency(
            Map<Integer, List<Integer>> tasks,
            int n) {

        // 0 = WHITE, 1 = GRAY, 2 = BLACK
        int[] state = new int[n];

        for (int v = 0; v < n; v++) {

            if (state[v] == 0) {

                if (dfsCycleCheck(tasks, v, state)) {

                    return true;
                }
            }
        }

        return false;
    }

    static boolean dfsCycleCheck(
            Map<Integer, List<Integer>> tasks,
            int node,
            int[] state) {

        // Mark as currently exploring
        state[node] = 1; // GRAY

        for (int dep : tasks.getOrDefault(
                node,
                Collections.emptyList())) {

            // Back edge found => cycle
            if (state[dep] == 1) {

                return true;
            }

            // Explore unvisited node
            if (state[dep] == 0) {

                if (dfsCycleCheck(
                        tasks,
                        dep,
                        state)) {

                    return true;
                }
            }
        }

        // Fully explored
        state[node] = 2; // BLACK

        return false;
    }

    public static void main(String[] args) {

        int n = 5;

        Map<Integer, List<Integer>> tasks = new HashMap<>();

        /*
         * 0 -> 1
         * 1 -> 2
         * 2 -> 3
         * 3 -> 1 (cycle)
         */

        tasks.put(0, Arrays.asList(1));
        tasks.put(1, Arrays.asList(2));
        tasks.put(2, Arrays.asList(3));
        tasks.put(3, Arrays.asList(1));
        tasks.put(4, Arrays.asList());

        boolean result = hasCircularDependency(tasks, n);

        if (result) {

            System.out.println(
                    "Circular dependency detected");

        } else {

            System.out.println(
                    "Build can be completed");
        }
    }
}
