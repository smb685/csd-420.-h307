import java.io.*;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {

        String filename = "SylvesterB_datafile.dat"; // Replace YourName with your name
        Random rand = new Random();

        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println("Random Integers:");
            for (int i = 0; i < 5; i++) {
                out.print(rand.nextInt(100) + " "); // 0–99
            }
            out.println();

            out.println("Random Doubles:");
            for (int i = 0; i < 5; i++) {
                out.print(rand.nextDouble() * 100 + " ");
            }
            out.println("\n");

            System.out.println("Data successfully written/appended to " + filename);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
