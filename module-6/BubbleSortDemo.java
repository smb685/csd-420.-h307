import java.util.Comparator;

/**
 * Module 6 Programming Assignment
 * Generic Bubble Sort using Comparable and Comparator
 *
 * Author: Sylvester Brandon
 * Course: Module 6
 *
 * This program demonstrates two bubble sort methods:
 * 1. bubbleSort(E[] list) uses the Comparable interface.
 * 2. bubbleSort(E[] list, Comparator<? super E> comparator) uses a Comparator.
 *
 * Test code is included in main() to validate both approaches.
 */
public class BubbleSortDemo {

    public static void main(String[] args) {

        // Test 1: Comparable bubble sort
        Integer[] nums = {5, 3, 8, 1, 4, 0, 9};
        System.out.println("Original (Comparable):");
        printArray(nums);

        bubbleSort(nums);
        System.out.println("Sorted (Comparable):");
        printArray(nums);

        // Test 2: Comparator bubble sort (descending order)
        String[] words = {"banana", "apple", "pear", "kiwi", "orange"};

        System.out.println("\nOriginal (Comparator – descending):");
        printArray(words);

        bubbleSort(words, (a, b) -> b.compareTo(a));
        System.out.println("Sorted (Comparator – descending):");
        printArray(words);
    }

    /**
     * Bubble sort using the Comparable interface.
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapMade;
        for (int i = 0; i < list.length - 1; i++) {
            swapMade = false;
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapMade = true;
                }
            }
            if (!swapMade) break;
        }
    }

    /**
     * Bubble sort using a Comparator.
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapMade;
        for (int i = 0; i < list.length - 1; i++) {
            swapMade = false;
            for (int j = 0; j < list.length - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapMade = true;
                }
            }
            if (!swapMade) break;
        }
    }

    /**
     * Utility method for printing arrays.
     */
    public static <E> void printArray(E[] arr) {
        System.out.print("[ ");
        for (E e : arr) {
            System.out.print(e + " ");
        }
        System.out.println("]");
    }
}
