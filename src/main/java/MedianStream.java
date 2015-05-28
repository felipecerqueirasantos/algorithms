import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sky on 5/14/15.
 */
public class MedianStream {
    private final class Median {
        private static final int DEFAULT_MIN_SIZE = 10;

        private int median = 0;
        private int N = 0;
        private int[] arr;

        public Median() {
            arr = new int[DEFAULT_MIN_SIZE];
        }

        // Process new value and return the updated median
        public int update(int value) {
            ensure_capacity(N + 1);
            arr[N] = value;
            sort(N);
            update_median();
            N++;
            return median;
        }

        private void update_median() {
            if (N % 2 == 0) {
                median = arr[N / 2];
            } else {
                median = arr[N / 2] + arr[N / 2 + 1];
                median /= 2;
            }
        }

        private void sort(int idx) {
            while (idx > 0 && arr[idx] < arr[idx - 1]) {
                exch(idx, idx - 1);
                idx--;
            }
        }

        private void exch(int i, int k) {
            int t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;
        }

        // Amortizing the insertion to contant time
        private void ensure_capacity(int required) {
            if (required > arr.length)
                arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }

    public void run() {
        Median med = new Median();

        String s = "5 15 1 3";
        Scanner sc = new Scanner(s);

        while (sc.hasNextInt()) {
            int v = sc.nextInt();
            System.out.println(med.update(v));
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        new MedianStream().run();
    }
}

