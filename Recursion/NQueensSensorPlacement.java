package Recursion;

import java.util.*;

public class NQueensSensorPlacement {

    static List<List<String>> placeSensors(int n) {

        List<List<String>> result = new ArrayList<>();

        int[] sensorCol = new int[n];

        backtrack(
                n,
                0,
                sensorCol,
                result);

        return result;
    }

    static void backtrack(
            int n,
            int row,
            int[] sensorCol,
            List<List<String>> result) {

        // All rows filled
        if (row == n) {

            result.add(
                    buildGrid(n, sensorCol));

            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, sensorCol)) {

                // Place sensor
                sensorCol[row] = col;

                // Move to next row
                backtrack(
                        n,
                        row + 1,
                        sensorCol,
                        result);
            }
        }
    }

    static boolean isSafe(
            int row,
            int col,
            int[] sensorCol) {

        for (int r = 0; r < row; r++) {

            // Same column conflict
            if (sensorCol[r] == col) {

                return false;
            }

            // Diagonal conflict
            if (Math.abs(sensorCol[r] - col) == Math.abs(r - row)) {

                return false;
            }
        }

        return true;
    }

    static List<String> buildGrid(
            int n,
            int[] sensorCol) {

        List<String> grid = new ArrayList<>();

        for (int r = 0; r < n; r++) {

            char[] row = new char[n];

            Arrays.fill(row, '.');

            row[sensorCol[r]] = 'S';

            grid.add(
                    new String(row));
        }

        return grid;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<String>> solutions = placeSensors(n);

        System.out.println(
                "Total Placements: "
                        + solutions.size());

        for (List<String> grid : solutions) {

            for (String row : grid) {

                System.out.println(row);
            }

            System.out.println();
        }
    }
}