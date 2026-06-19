import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void main(String[] args) {

        int lineCount = 0;

        try {
            FileReader fr = new FileReader("bill.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("Bill Contents:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            br.close();

            System.out.println("Total Number of Lines = " + lineCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
