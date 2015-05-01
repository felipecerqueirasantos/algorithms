import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by sky on 5/1/15.
 */
public class FindKNearest {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Use: <filename>");
            System.exit(1);
        }

        PriorityQueue<Double> queue = new PriorityQueue<>(6, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                Double distance = Double.parseDouble(line);
                queue.add(distance);
                if (queue.size() == 6)
                    System.out.println("Removing: " + queue.remove());
            }

            while (!queue.isEmpty())
                System.out.println(queue.remove());

        }
    }
}
