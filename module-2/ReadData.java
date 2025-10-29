import java.io.*;

public class ReadData {
    public static void main(String[] args) {

        String filename = "SylvesterB_datafile.dat"; // Same file name as above

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            System.out.println("Reading data from file:\n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! Run WriteData first.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
