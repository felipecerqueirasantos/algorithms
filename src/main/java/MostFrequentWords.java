import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sky on 21/04/15.
 */
public class MostFrequentWords {
    private static final class Counter {
        private String word;
        private int counter;

        public Counter(String word, int initial) {
            this.word = word;
            this.counter = initial;
        }

        public void increment() {
            counter++;
        }

        @Override
        public String toString() {
            return "[" + word + ", " + counter + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        Reader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        Map<String, Counter> freq = new HashMap<>();

        int N = 1;


        PriorityQueue<Counter> priorityQueue = new PriorityQueue<>(N + 1, new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return o1.counter - o2.counter;
            }
        });

        String line;
        while((line = br.readLine()) != null) {
            Counter counter = freq.get(line);

            if (counter == null) {
                counter = new Counter(line, 1);
                freq.put(line, counter);
                priorityQueue.add(counter);
            } else {
                counter.increment();
                priorityQueue.add(counter);
            }

            if (priorityQueue.size() > N)
                priorityQueue.remove();
        }

        br.close();
        in.close();

        while (!priorityQueue.isEmpty()) {
            Counter max = priorityQueue.remove();
            System.out.println(max);
        }

    }
}
