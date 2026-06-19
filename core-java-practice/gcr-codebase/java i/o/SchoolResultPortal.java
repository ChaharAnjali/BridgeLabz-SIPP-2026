import java.io.*;
import java.util.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        String inputFile = "students.txt";
        String outputFile = "reportcards.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(outputFile, true)) // true = append mode
        ) {

            String line;

            writer.write("\n========== NEW REPORT ==========\n");

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];
                int total = 0;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = (double) total / (data.length - 1);

                writer.write("Student: " + name + "\n");
                writer.write("Average Marks: " +
                        String.format("%.2f", average) + "\n");

                if (average >= 90)
                    writer.write("Grade: A\n");
                else if (average >= 75)
                    writer.write("Grade: B\n");
                else
                    writer.write("Grade: C\n");

                writer.write("--------------------------\n");
            }

            System.out.println("Report cards generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error while reading/writing files: "
                    + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid mark format in file.");
        }
    }
}