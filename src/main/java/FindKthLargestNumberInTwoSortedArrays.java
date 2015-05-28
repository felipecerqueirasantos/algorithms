import java.util.*;

/**
 * Created by sky on 5/19/15.
 */
public class FindKthLargestNumberInTwoSortedArrays {
    public static int findKthLargerst(int[] sortedA, int[] sortedB, int k) {
        return Math.max(findKthLargerst(sortedA, k), findKthLargerst(sortedB, k));
    }

    public static int findKthLargerst(int[] sorted, int k) {
        // Creating a queue with k + 1 to avoid array resizing
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k + 1);
        int saved = sorted[sorted.length - 1];
        minQueue.add(saved);

        for (int i = sorted.length -2 ; i > -1; i--) {
            if (sorted[i] == saved) {
                // Skipping repeated values
                continue;
            }

            saved = sorted[i];

            minQueue.add(sorted[i]);
            if (minQueue.size() > k) {
                minQueue.remove();
            }
        }

        Iterator<Integer> it = minQueue.iterator();
        int maxKth = Integer.MIN_VALUE;
        if (it.hasNext())
            maxKth = it.next();

        return maxKth;
    }

    public static void main(String[] args) {
        int[] sortedA = new int[] {1, 2, 3, 4, 5};
        int[] sortedB = new int[] {5, 6, 7, 8, 8};
        int k = 2;

        // Expected result: 7
        System.out.println(findKthLargerst(sortedA, sortedB, 2));
    }
}