import java.util.*;

/**
 * Created by sky on 5/17/15.
 */
public class RunningIntegersMedian {
    // DelMin (default)
    private PriorityQueue<Integer> minHeap;

    // DelMax (custom comparator needed)
    private PriorityQueue<Integer> maxHeap;

    private int currentMedian = 0;

    public RunningIntegersMedian() {
        // Default minHeap
        minHeap = new PriorityQueue<>();

        // Using lambda comparator to create a maxHeap
        maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    }

    // Insert a new value and return the median
    public int update(int value) {
        insert(value);
        updateMedian();
        return currentMedian;
    }

    private void insert(int value) {
        if (value > currentMedian)
            minHeap.add(value);
        else
            maxHeap.add(value);

        int cmp = maxHeap.size() - minHeap.size();

        // Balancing minHeap and maxHeap by size
        if (cmp > 1) {
            minHeap.add(maxHeap.remove());
        } else if (cmp < -1) {
            maxHeap.add(minHeap.remove());
        }
    }

    private void updateMedian() {
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();

        if (leftSize > rightSize) {
            currentMedian = maxHeap.peek();
        }
        else if (rightSize > leftSize) {
            currentMedian = minHeap.peek();
        }
        else {
            currentMedian = avg(maxHeap.peek(), minHeap.peek());
        }
    }

    private int avg(Integer left, Integer right) {
        return left + (right - left) / 2;
    }

    public void run() {
        List<Integer> list = Arrays.asList(5, 15, 1, 3);
        for (Integer i : list)
            System.out.println("Median: " + update(i));

    }

    public static void main(String[] args) {
        new RunningIntegersMedian().run();
    }
}
