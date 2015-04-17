import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sky on 4/7/15.
 */
public class MaxRangeSum {
    public static int maxSumRange(int[] arr, int N) {
        int max = 0;

        int b, e;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            b = i;
            e = i + N;

            if (e > arr.length)
                break;

            if (b == 0) {
                for (int j = b; j < e; j++) {
                    sum += arr[j];
                }
                max = sum;
            } else {
                sum -= arr[b - 1];
                sum += arr[e - 1];

                max = Math.max(sum, max);
            }

        }

        return max;
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
            String[] tmp = line.split("[ ;]");

            int N = Integer.parseInt(tmp[0]);
            int[] arr = new int[tmp.length];

            for (int i = 1; i < tmp.length; i++)
                arr[i] = Integer.parseInt(tmp[i]);

            int maxSum = maxSumRange(arr, N);
            if (maxSum < 0)
                System.out.println("0");
            else
                System.out.println(maxSum);
        }

        br.close();
        in.close();
    }
}
