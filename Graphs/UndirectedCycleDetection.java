package Graphs;

import java.util.*;

public class UndirectedCycleDetection {

    // Check cycle in complete graph
    static boolean hasWiringLoop(
            Map<Integer, List<Integer>> circuit,
            int n) {

        Set<Integer> visited = new HashSet<>();

        // Check all components
        for (int v = 0; v < n; v++) {

            if (!visited.contains(v)) {

                if (dfsCycleCheck(
                        circuit,
                        v,
                        -1,
                        visited)) {

                    return true;
                }
            }
        }

        return false;
    }

    // DFS cycle detection
    static boolean dfsCycleCheck(
            Map<Integer, List<Integer>> circuit,
            int node,
            int parent,
            Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : circuit.getOrDefault(
                node,
                Collections.emptyList())) {

            // Visit new node
            if (!visited.contains(neighbor)) {

                if (dfsCycleCheck(
                        circuit,
                        neighbor,
                        node,
                        visited)) {

                    return true;
                }
            }

            // Already visited node but not parent
            else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 5;

        Map<Integer, List<Integer>> circuit = new HashMap<>();

        // Wiring connections
        circuit.put(0, Arrays.asList(1, 2));
        circuit.put(1, Arrays.asList(0, 3));
        circuit.put(2, Arrays.asList(0, 3));
        circuit.put(3, Arrays.asList(1, 2, 4));
        circuit.put(4, Arrays.asList(3));

        boolean result = hasWiringLoop(circuit, n);

        if (result) {

            System.out.println(
                    "Circuit has a wiring loop");

        } else {

            System.out.println(
                    "Circuit is a valid tree structure");
        }
    }
}