package Graphs;

import java.util.*;

public class DFSAllRoutes {

    static void allRoutes(
            Map<Integer, List<Integer>> roads,
            int current,
            int target,
            List<Integer> path,
            Set<Integer> visited,
            List<List<Integer>> allRoutes) {

        // Add current location
        path.add(current);
        visited.add(current);

        // Destination reached
        if (current == target) {

            allRoutes.add(new ArrayList<>(path));

        }

        else {

            // Explore next locations
            for (int next : roads.getOrDefault(
                    current,
                    Collections.emptyList())) {

                if (!visited.contains(next)) {

                    allRoutes(
                            roads,
                            next,
                            target,
                            path,
                            visited,
                            allRoutes);
                }
            }
        }

        // Backtracking
        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> roads = new HashMap<>();

        // Road network
        roads.put(1, Arrays.asList(2, 3));
        roads.put(2, Arrays.asList(4, 5));
        roads.put(3, Arrays.asList(5));
        roads.put(4, Arrays.asList(6));
        roads.put(5, Arrays.asList(6));

        int warehouse = 1;
        int store = 6;

        List<List<Integer>> routes = new ArrayList<>();

        allRoutes(
                roads,
                warehouse,
                store,
                new ArrayList<>(),
                new HashSet<>(),
                routes);

        System.out.println("All Possible Routes:");

        for (List<Integer> route : routes) {

            System.out.println(route);
        }
    }
}