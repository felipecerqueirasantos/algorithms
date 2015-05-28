/**
 * Created by sky on 5/9/15.
 */
public class FindClosestSum {

    // Solution in N log N
    public static void findClosestSumTo(int[] sortedArr, int k) {
        int maxDiff = Integer.MAX_VALUE;
        int savedA = -1;
        int savedB = -1;

        for (int i = 0; i < sortedArr.length; i++) {

            int begin = 0;
            int end = sortedArr.length - 1;

            while (begin < end) {
                int midPoint = midPoint(begin, end);

                // diff = 5 /  arr[]=1, 2, 3, 4, 5    k = 10
                int diff = Math.abs((sortedArr[i] + sortedArr[midPoint]) - k);

                // Is it closer?
                if (diff < maxDiff) {
                    maxDiff = diff;
                    savedA = i;
                    savedB = midPoint;
                }

                // Should I go left or right now?
                if (sortedArr[i] + sortedArr[midPoint] > k) {
                    end = midPoint;
                } else {
                    begin = midPoint + 1;
                }
            }
        }

        System.out.println(sortedArr[savedA] + ", " + sortedArr[savedB]);
    }

    // midPoint (0, 10) 5? ok
    // midPoint (6, 10) 8? ok
    public static int midPoint(int begin, int end) {
        //begin + end might throw an integer overflow
        return (begin + (end - begin) / 2);
    }

    public static void main(String[] args) {
        int[] sortedArr = new int[]{1, 2, 3, 4, 5};
        int k = 10;
        findClosestSumTo(sortedArr, k);
    }
}