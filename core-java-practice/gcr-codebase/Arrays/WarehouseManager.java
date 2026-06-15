import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WarehouseManager {

    
    public static void processStock(int[] stock) {
        if (stock == null || stock.length == 0) return;

        int max = stock[0];
        int min = stock[0];
        int totalStock = 0;
        boolean hasDuplicates = false;
        Set<Integer> seenItems = new HashSet<>();

        for (int item : stock) {
            
            if (item > max) max = item;
            if (item < min) min = item;
            
            
            totalStock += item;

            
            if (!seenItems.add(item)) {
                hasDuplicates = true;
            }
        }

        System.out.println("--- Warehouse Stock Stats ---");
        System.out.println("Max Quantity: " + max);
        System.out.println("Min Quantity: " + min);
        System.out.println("Total Stock: " + totalStock);
        System.out.println("Contains Duplicates: " + hasDuplicates);
    }

    
    public static void rotateStock(int[] stock, int k) {
        if (stock == null || stock.length == 0) return;

        
        k = k % stock.length;
        if (k < 0) k = k + stock.length; 

        reverse(stock, 0, stock.length - 1);
        reverse(stock, 0, k - 1);
        reverse(stock, k, stock.length - 1);
    }

    
    private static void reverse(int[] stock, int start, int end) {
        while (start < end) {
            int temp = stock[start];
            stock[start] = stock[end];
            stock[end] = temp;
            start++;
            end--;
        }
    }

    
    public static int[][] transposeGrid(int[][] grid) {
        if (grid == null || grid.length == 0) return new int[0][0];

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = grid[i][j];
            }
        }
        return transposed;
    }

    
    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        
        int[] stock = {15, 42, 89, 15, 30};
        
        
        processStock(stock);

        
        int k = 2; 
        rotateStock(stock, k);
        System.out.println("\nStock after " + k + " position shift: " + Arrays.toString(stock));

        
        int[][] shelfGrid = {
            {10, 20, 30},
            {40, 50, 60}
        };
        
        System.out.println("\nOriginal 2D Shelf Grid:");
        printGrid(shelfGrid);

        int[][] transposedGrid = transposeGrid(shelfGrid);
        System.out.println("\nTransposed 2D Shelf Grid:");
        printGrid(transposedGrid);
    }
}