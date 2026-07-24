package Recursion;

public class WordSearch {

    static boolean exists(char[][] grid, String word) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (backtrack(
                        grid,
                        word,
                        0,
                        r,
                        c,
                        visited)) {

                    return true;
                }
            }
        }

        return false;
    }

    static boolean backtrack(
            char[][] grid,
            String word,
            int idx,
            int r,
            int c,
            boolean[][] visited) {

        // Entire word matched
        if (idx == word.length()) {

            return true;
        }

        // Out of boundary
        if (r < 0 ||
                r >= grid.length ||
                c < 0 ||
                c >= grid[0].length) {

            return false;
        }

        // Already visited or character mismatch
        if (visited[r][c] ||
                grid[r][c] != word.charAt(idx)) {

            return false;
        }

        // Mark current cell
        visited[r][c] = true;

        // Explore four directions
        boolean found = backtrack(grid, word, idx + 1,
                r + 1, c, visited)

                ||

                backtrack(grid, word, idx + 1,
                        r - 1, c, visited)

                ||

                backtrack(grid, word, idx + 1,
                        r, c + 1, visited)

                ||

                backtrack(grid, word, idx + 1,
                        r, c - 1, visited);

        // Backtrack
        visited[r][c] = false;

        return found;
    }

    public static void main(String[] args) {

        char[][] grid = {

                { 'E', 'R', 'R', 'O' },
                { 'A', 'C', 'D', 'E' },
                { 'L', 'O', 'G', 'X' },
                { 'T', 'E', 'S', 'T' }
        };

        String word = "ERROR";

        boolean result = exists(grid, word);

        if (result) {

            System.out.println(
                    "Word exists in grid");

        } else {

            System.out.println(
                    "Word not found");
        }
    }
}