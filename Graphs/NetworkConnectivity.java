package Graphs;

import java.util.*;

public class NetworkConnectivity {

    // Count connected components
    static int countNetworkSegments(
            Map<Integer, List<Integer>> network,
            int n) {

        Set<Integer> visited = new HashSet<>();

        int segments = 0;

        // Check every server
        for (int server = 0; server < n; server++) {

            // New component found
            if (!visited.contains(server)) {

                segments++;

                dfsMark(
                        network,
                        server,
                        visited);
            }
        }

        return segments;
    }

    // DFS traversal
    static void dfsMark(
            Map<Integer, List<Integer>> network,
            int node,
            Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : network.getOrDefault(
                node,
                Collections.emptyList())) {

            if (!visited.contains(neighbor)) {

                dfsMark(
                        network,
                        neighbor,
                        visited);
            }
        }
    }

    public static void main(String[] args) {

        int n = 7; // total servers

        Map<Integer, List<Integer>> network = new HashMap<>();

        // Server connections
        network.put(0, Arrays.asList(1));
        network.put(1, Arrays.asList(0, 2));
        network.put(2, Arrays.asList(1));

        network.put(3, Arrays.asList(4));
        network.put(4, Arrays.asList(3));

        network.put(5, Arrays.asList(6));
        network.put(6, Arrays.asList(5));

        int segments = countNetworkSegments(network, n);

        System.out.println(
                "Network Segments: " + segments);

        if (segments == 1) {

            System.out.println(
                    "Network is fully connected");

        } else {

            System.out.println(
                    "Network has isolated segments");
        }
    }
}