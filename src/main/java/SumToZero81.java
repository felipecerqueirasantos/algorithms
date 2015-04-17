import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sky on 4/6/15.
 */
public class SumToZero81 {
    public static int sumToZero(int[] numbers) {
        int[] tmp = new int[numbers.length];
        tmp[0] = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            tmp[i] = tmp[i - 1] + numbers[i];
        }

        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(tmp[i]);

            if (set.contains(tmp[i])) {
                count++;
                continue;
            }
            set.add(tmp[i]);
        }
        System.out.println();
        return count;
    }

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
            System.err.println(line);
            String[] arr = line.split(",");
            int[] numbers = new int[arr.length];

            for (int i = 0; i < arr.length; i++)
                numbers[i] = Integer.parseInt(arr[i]);

            System.out.println(sumToZero(numbers));
        }

        br.close();
        in.close();

    }
}
