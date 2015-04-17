import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 17/04/15.
 */
public class FindEvenRepeatedNumber {
    private static final class Counter {
        private int counter;

        public Counter(int counter) {
            this.counter = counter;
        }

        public int increment() {
            return ++this.counter;
        }

        @Override
        public String toString() {
            return "[" + String.valueOf(counter) + "]";
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 2, 5, 3, 5, 7, 7, 3, 4, 5, 5};
        int x = 0;

        for (int i = 0; i < arr.length; i++)
            x ^= arr[i];

        System.out.println(x);

        Map<Integer, Counter> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Counter count = freq.get(arr[i]);
            if (count == null) {
                freq.put(arr[i], new Counter(1));
            } else {
                count.increment();
            }
        }

        for (Integer k: freq.keySet()) {
            System.out.println(k + " " + freq.get(k));
        }
    }
}
