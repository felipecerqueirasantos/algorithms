import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sky on 5/9/15.
 */
class FindNearestStars {
    public static void main(String[] args) throws Exception {
        int k = 2;
        PriorityQueue<Double> queue = new PriorityQueue<>(k + 1, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o2 - o1);
            }
        });

        try (Reader in = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(in) ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty())
                    break;

                double distance = Double.parseDouble(line);
                queue.add(distance);

                if (queue.size() > k) {
                    // Remove the biggest
                    queue.remove();
                }

            }

            while (!queue.isEmpty()) {
                System.out.println(queue.remove());
            }
        }
    }

}