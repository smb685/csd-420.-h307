import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {

    public static void main(String[] args) {

        System.out.println("===== Testing 50,000 elements =====");
        testTraversal(50000);

        System.out.println("\n===== Testing 500,000 elements =====");
        testTraversal(500000);
    }

    public static void testTraversal(int size) {

        LinkedList<Integer> list = new LinkedList<>();

        // Fill the list
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Test traversal using Iterator
        long startIterator = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endIterator = System.currentTimeMillis();

        // Test traversal using get(index)
        long startGet = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endGet = System.currentTimeMillis();

        // Print results
        System.out.println("Traversal with Iterator: " + (endIterator - startIterator) + " ms");
        System.out.println("Traversal with get(index): " + (endGet - startGet) + " ms");
    }
}
/*
RESULTS EXPLANATION:

Iterator traversal is much faster because LinkedList nodes
are connected by references, and iterators move through the
list sequentially in O(n) time.

However, using get(index) on a LinkedList is slow since
it must start at the beginning each time and move one step
at a time to reach the target index. This makes get(index)
O(n) for every access — resulting in O(n²) performance
overall when looping through the list.

As the size increased from 50,000 to 500,000 elements,
the get(index) method slowed down drastically, while the
iterator remained efficient.

This confirms that LinkedList is not suitable for indexed
access but is optimal for sequential traversal.
*/
