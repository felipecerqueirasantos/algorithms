import junit.framework.TestCase;

import java.util.PriorityQueue;

/**
 * Created by sky on 5/2/15.
 */
public class MinHeapTest extends TestCase {
    public void testAdd() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(10);
        minHeap.add(10);
        minHeap.add(8);
        minHeap.add(11);
    }

    public void testSize() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(10);
        minHeap.add(10);
        minHeap.add(8);
        minHeap.add(11);
        assertEquals(minHeap.size(), 3);
    }

    public void testIsEmpty() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(10);
        assertEquals(minHeap.isEmpty(), true);
        minHeap.add(10);
        minHeap.add(8);
        minHeap.add(11);
        assertEquals(minHeap.isEmpty(), false);
    }

    public void testDelMin() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(10);
        minHeap.add(10);
        minHeap.add(8);
        minHeap.add(11);

        assertEquals((int) minHeap.delMin(), 8);

        minHeap.add(20);
        minHeap.add(9);

        assertEquals((int) minHeap.delMin(), 9);
    }

    public void testPrint() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(10);
        minHeap.add(10);
        minHeap.add(8);
        minHeap.add(11);
        minHeap.delMin();
        minHeap.add(9);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(2);
        minHeap.print();
    }
}