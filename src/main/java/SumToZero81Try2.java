import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sky on 4/6/15.
 */
public class SumToZero81Try2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        Reader in;

        if (args.length == 2) {
            in = new FileReader(args[1]);
        } else {
            in = new InputStreamReader(System.in);
        }
        br = new BufferedReader(in);

        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            int[] numbers = new int[arr.length];

            for (int i = 0; i < arr.length; i++)
                numbers[i] = Integer.parseInt(arr[i]);

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }

            int count = 0;
            for (int i = 2; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int needle = (numbers[i] + numbers[j]) * -1;
                    if (set.contains(needle)) ++count;
                }
            }

            System.out.println(count);
        }

        br.close();
        in.close();
    }
}
