import java.io.*;

public class FileReadExample {
    public static void main(String[] args) {

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("data.txt");
            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("Error reading file");

        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}