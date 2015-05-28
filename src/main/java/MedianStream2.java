import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by sky on 5/14/15.
 */
public class MedianStream2 {
    public final class Median {
        private int median;

        // delMin
        private PriorityQueue<Integer> minQueue;

        private PriorityQueue<Integer> maxQueue;

        public Median() {
            median = 0;
            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        }

        public int update(int value) {
            minQueue.add(value);
            maxQueue.add(value);

            System.out.println("minQueue.peek(): " + minQueue.peek() + "\n" +
            "maxQueue.peek(): " + maxQueue.peek());

            return median;
        }
    }

    public void run() {
        Median med = new Median();

        String s = "5 15 1 3";
        // 5 -> 5
        // 5 15 -> 10
        // 1 5 15 -> 5

        Scanner sc = new Scanner(s);

        while (sc.hasNextInt()) {
            int v = sc.nextInt();
            System.out.println(med.update(v));
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        new MedianStream2().run();
    }
}
