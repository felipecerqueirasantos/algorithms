import java.util.*;

/**
 * Created by sky on 4/7/15.
 */
public class StringConcat {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1};

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        List<Integer> list = new ArrayList<>();

        for (Integer i: arr) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            Integer a = queue.remove();

            if (!queue.isEmpty()) {
                Integer b = queue.remove();

                Integer res = a + b;
                list.add(res);
                queue.add(res);
            } else {
                break;
            }
        }

        int acc = 0;
        for (Integer i: list) {
            acc += i;
        }

        System.out.println(acc);
    }
}
