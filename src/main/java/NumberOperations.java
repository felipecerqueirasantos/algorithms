import java.io.*;

/**
 * Created by sky on 07/04/15.
 */
public class NumberOperations {
    public static boolean arithmeticRearrange(int[] values, int acc, int idx) {

        if (idx == values.length) {
            System.out.println(acc);

            if (acc == 42)
                return true;

            return false;
        } else {
            return arithmeticRearrange(values, acc + values[idx], idx + 1) ||
                    arithmeticRearrange(values, acc - values[idx], idx + 1) ||
                    arithmeticRearrange(values, acc * values[idx], idx + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        Reader in = null;
        BufferedReader br = null;

        if (args.length == 2) {
            in = new FileReader(args[1]);
        } else {
            in = new InputStreamReader(System.in);
        }

        br = new BufferedReader(in);
        String line;

        while ((line = br.readLine()) != null) {
            String[] arr = line.split(" ");
            int[] values = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                values[i] = Integer.parseInt(arr[i]);
            }

            if (arithmeticRearrange(values, values[0] + values[1], 2) ||
                    arithmeticRearrange(values, values[0] - values[1], 2) ||
                    arithmeticRearrange(values, values[0] * values[1], 2))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        br.close();
        in.close();
    }
}
