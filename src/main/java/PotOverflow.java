import java.util.Arrays;

/**
 * Created by sky on 05/05/15.
 */


public class PotOverflow {
    public static class WorstCaseOverflow {
        // Number of stones
        private int counter;
        private int [] arr;
        private final int k;

        public WorstCaseOverflow(int[] arr, int k) {
            this.arr = arr;
            this.k = k;
            tryOverflow();
        }

        // Greedy solution
        private void tryOverflow() {
            int overflow = 0;
            while (overflow != k) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        // Checking for pots that did not overflow yet
                        counter++;
                        if (--arr[i] == 0)
                            overflow++;
                    }
                }
            }
        }

        public int worstCase() {
            return counter;
        }

    }

    // Linear time
    public static int trySmart(int[]arr, int k) {
        Arrays.sort(arr);

        int kth = arr[k - 1];
        int acc = kth * arr.length;

        for (int i = 0; i < k; i++)
            acc -= kth - arr[i];

        return acc;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 4, 5, 6};
        WorstCaseOverflow worstCaseOverflow = new WorstCaseOverflow(Arrays.copyOf(arr, arr.length), 4);
        System.out.println(worstCaseOverflow.worstCase());
        System.out.println(trySmart(Arrays.copyOf(arr, arr.length), 4));
    }
}