import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sky on 4/9/15.
 */
public class SortedByFrequency {

    // Nested class to hold value and its frequency
    private static class ValueAndFrequencyPair {
        private int value;
        private int frequency;

        public ValueAndFrequencyPair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "[" + value + " " + frequency + "]";
        }
    }

    public static void main(String[] args) {
        int N = 2;
        int[] arr = {0, 0, 100, 3, 5, 4, 6, 4, 2, 100, 2, 100};
        Map<Integer, Integer> frequency = new HashMap<>();

        PriorityQueue<ValueAndFrequencyPair> queue =
                new PriorityQueue<>(N + 1, new Comparator<ValueAndFrequencyPair>() {
                    @Override
                    public int compare(ValueAndFrequencyPair o1, ValueAndFrequencyPair o2) {
                        return o1.frequency - o2.frequency;
                    }
                });

        for (int i = 0; i < arr.length; i++) {
            Integer freq;
            if ((freq = frequency.get(arr[i])) == null) {
                frequency.put(arr[i], 1);
                queue.add(new ValueAndFrequencyPair(arr[i], 1));

                if (queue.size() > N)
                    queue.remove();
            } else {
                freq++;
                frequency.put(arr[i], freq);
                queue.add(new ValueAndFrequencyPair(arr[i], freq));

                if (queue.size() > N)
                    queue.remove();
            }
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
