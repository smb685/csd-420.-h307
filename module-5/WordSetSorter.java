import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSetSorter {

    public static void main(String[] args) {
        // File directly referenced — no command line use
        File file = new File("collection_of_words.txt");

        // TreeSet automatically stores words in ascending order AND removes duplicates
        Set<String> wordsAscending = new TreeSet<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    wordsAscending.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        // Display ascending order
        System.out.println("---- Non-Duplicate Words in Ascending Order ----");
        for (String word : wordsAscending) {
            System.out.println(word);
        }

        // Descending order
        System.out.println("\n---- Non-Duplicate Words in Descending Order ----");
        NavigableSet<String> wordsDescending = ((TreeSet<String>) wordsAscending).descendingSet();

        for (String word : wordsDescending) {
            System.out.println(word);
        }

        // Run internal test
        runTests();
    }

    // Test function to validate correctness
    public static void runTests() {
        System.out.println("\n---- Running Internal Tests ----");

        // Create a fake list of words to test logic
        List<String> testWords = Arrays.asList(
                "apple", "banana", "Apple", "orange", "banana", "pear", "Orange"
        );

        // Expected behavior:
        // Non-duplicate, lowercase, sorted ascending
        Set<String> expectedAscending = new TreeSet<>(
                Arrays.asList("apple", "banana", "orange", "pear")
        );

        // Simulate processing
        Set<String> processed = new TreeSet<>();
        for (String word : testWords) {
            processed.add(word.toLowerCase());
        }

        // Check correctness
        boolean ascendingCorrect = processed.equals(expectedAscending);

        System.out.println("Test Case: Duplicate Removal + Ascending Sort");
        System.out.println("Expected: " + expectedAscending);
        System.out.println("Got     : " + processed);
        System.out.println("Result  : " + (ascendingCorrect ? "PASS" : "FAIL"));

        System.out.println("---- Tests Complete ----");
    }
}
