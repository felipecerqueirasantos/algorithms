/**
 * Created by sky on 5/9/15.
 */
// trying O(n)
public class FindCLosestSumRetry {
    // k = 10  sortedArr = 1, 2, 3, 4, 5
    public static void findClosestSum(int[] sortedArr, int k) {
        int maxDiff = Integer.MAX_VALUE;
        int a = -1;
        int b = -1;

        int begin = 0;
        int end = sortedArr.length - 1;

        // begin = 0, end = 4
        //   diff = (1 + 5) - 10
        //   maxDiff = 4
        // begin = 1, end = 4
        //   diff = (2 + 5) - 10
        //   maxDiff = 3
        // begin = 2 end = 4
        //   diff = 2
        //   maxDiff = 2
        // begin = 3 end = 4
        //   diff = 1
        //   maxDiff = 1

        while (begin < end) {
            int diff = Math.abs((sortedArr[begin] + sortedArr[end]) - k);

            // Is it closer?
            if (diff < maxDiff) {
                maxDiff = diff;
                a = begin;
                b = end;
            }

            int sum = sortedArr[begin] + sortedArr[end];
            if (sum == k) {
                // K found
                break;
            }

            // Should I go from begin to end or the opposite?
            if (sum > k) {
                end--;
            } else {
                begin++;
            }

        }

        System.out.println(sortedArr[a] + ", " + sortedArr[b]);

    }

    public static void main(String[] args) {
        int[] sortedArr = new int[] {1, 2, 3, 4, 5};
        int k = 10;
        findClosestSum(sortedArr, k);
    }
}