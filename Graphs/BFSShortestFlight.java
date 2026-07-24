package Graphs;

import java.util.*;

public class BFSShortestFlight {

    static List<Integer> fewestFlights(
            Map<Integer, List<Integer>> routes,
            int origin,
            int destination) {

        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> visited = new HashSet<>();

        Map<Integer, Integer> parent = new HashMap<>();

        // Start city
        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {

            int city = queue.poll();

            // Destination mil gaya
            if (city == destination) {
                break;
            }

            // Explore neighbors
            for (int next : routes.getOrDefault(
                    city,
                    Collections.emptyList())) {

                if (!visited.contains(next)) {

                    visited.add(next);

                    parent.put(next, city);

                    queue.offer(next);
                }
            }
        }

        // Destination unreachable
        if (!visited.contains(destination)) {
            return Collections.emptyList();
        }

        // Reconstruct path
        LinkedList<Integer> path = new LinkedList<>();

        Integer node = destination;

        while (node != null) {

            path.addFirst(node);

            node = parent.get(node);
        }

        return path;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> routes = new HashMap<>();

        // Flight routes
        routes.put(1, Arrays.asList(2, 3));
        routes.put(2, Arrays.asList(4));
        routes.put(3, Arrays.asList(5));
        routes.put(4, Arrays.asList(6));
        routes.put(5, Arrays.asList(6));

        int origin = 1;
        int destination = 6;

        List<Integer> path = fewestFlights(routes, origin, destination);

        if (path.isEmpty()) {

            System.out.println("No route available");

        } else {

            System.out.println("Shortest Flight Path:");
            System.out.println(path);
        }
    }
}
