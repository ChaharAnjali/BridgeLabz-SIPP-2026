package Recursion;

import java.util.*;

public class OnCallSchedule {

    static List<List<String>> generateSchedules(
            String[] engineers) {

        List<List<String>> result = new ArrayList<>();

        boolean[] used = new boolean[engineers.length];

        backtrack(
                engineers,
                used,
                new ArrayList<>(),
                result);

        return result;
    }

    static void backtrack(
            String[] engineers,
            boolean[] used,
            List<String> path,
            List<List<String>> result) {

        // Complete schedule created
        if (path.size() == engineers.length) {

            result.add(
                    new ArrayList<>(path));

            return;
        }

        // Try every engineer
        for (int i = 0; i < engineers.length; i++) {

            // Already assigned
            if (used[i]) {
                continue;
            }

            // Choose engineer
            used[i] = true;

            path.add(engineers[i]);

            // Move to next position
            backtrack(
                    engineers,
                    used,
                    path,
                    result);

            // Backtrack
            path.remove(
                    path.size() - 1);

            used[i] = false;
        }
    }

    public static void main(String[] args) {

        String[] engineers = {
                "Anjali",
                "Rahul",
                "Priya"
        };

        List<List<String>> schedules = generateSchedules(engineers);

        System.out.println(
                "Total Schedules: "
                        + schedules.size());

        for (List<String> schedule : schedules) {

            System.out.println(schedule);
        }
    }
}
