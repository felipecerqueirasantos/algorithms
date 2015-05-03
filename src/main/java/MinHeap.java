import java.util.*;
import java.lang.*;

/**
 * Created by sky on 5/2/15.
 */
public class MinHeap <T extends Comparable<T>> {
    private Object[] arr;
    private int size;

    public MinHeap(int size) {
        arr = new Object[size + 1];
    }

    public void add(T val) {
        arr[++size] = val;
        swim(size, val);
    }

    public T delMin() {
        Object e = arr[1];
        exch(1, size--);
        arr[size + 1] = null;
        sink(1);
        return (T) e;
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) j++;
            if (!less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k, T val) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private boolean less(int i, int j) {
        Comparable<? super T> key = (T)arr[i];
        return key.compareTo((T) arr[j]) < 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private final class Itr implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
