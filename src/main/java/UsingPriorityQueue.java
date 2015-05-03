import java.util.PriorityQueue;

/**
 * Created by sky on 5/2/15.
 */
public class UsingPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(8);
        p.add(1);
        p.add(7);
        p.add(9);

        p.remove();

        for (Integer i: p)
            System.out.println(i);
    }
}
