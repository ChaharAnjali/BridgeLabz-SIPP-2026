public class MultipleCatchBlocks {

    public static void main(String[] args) {

        int[] arr = null;   // you can also test by initializing like: int[] arr = {10, 20, 30};

        int index = 2;      // change index to test

        try {

            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid index!");

        } catch (NullPointerException e) {

            System.out.println("Array is not initialized!");

        }

    }
}