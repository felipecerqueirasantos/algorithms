import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sky on 5/16/15.
 */
public class KthSmallestNumberFromASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{10, 20, 30, 40}, {15, 25, 35, 45}, {24, 29, 37, 48}, {32, 33, 39, 50}};
        int kth = 7;

        PriorityQueue<Integer> queue = new PriorityQueue<>(kth + 1, (o1, o2) -> o2 - o1);

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                queue.add(matrix[l][c]);
                if (queue.size() > kth)
                    queue.remove();
            }
        }

        System.out.println(queue.remove());
    }
}
