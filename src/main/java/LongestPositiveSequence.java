/**
 * Created by sky on 5/2/15.
 */
public class LongestPositiveSequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 2, 3, 4, -3, -6, 1, 2, 3, 4, 5, 6, -8, 5, 6};

        int prev = arr[0] - 1;
        int idx = 0;
        int count = 0;

        int max = 0;
        int maxId = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - prev < 0) {
                if (count > max) {
                    max = count;
                    maxId = idx;
                }

                idx = i + 1;
                count = 0;
            } else {
                count++;
            }
        }

        System.out.println(max + ", " + maxId);
    }
}
