import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Create an ArrayList and fill it with 50 random values from 1 to 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();
        
        // Fill the ArrayList with 50 random values between 1 and 20
        for (int i = 0; i < 50; i++) {
            int randomValue = random.nextInt(20) + 1; // Generates numbers 1-20
            originalList.add(randomValue);
        }
        
        // Display the original list
        System.out.println("Original ArrayList (50 random values from 1-20):");
        System.out.println(originalList);
        System.out.println("Original list size: " + originalList.size());
        
        // Remove duplicates using the removeDuplicates method
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        
        // Display the list without duplicates
        System.out.println("\nArrayList after removing duplicates:");
        System.out.println(uniqueList);
        System.out.println("Unique list size: " + uniqueList.size());
    }
    
    /**
     * Removes duplicates from an ArrayList
     * @param <E> the type of elements in the list
     * @param list the original ArrayList
     * @return a new ArrayList containing only unique elements
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        
        return result;
    }
}