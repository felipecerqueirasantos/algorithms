/**
 * Created by sky on 5/7/15.
 */
public class MaxMultiplicationThreeNumbers {
    public static void main(String[] args) {
        // max = 4, 5, 6
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};

        int max_ending_here = 1;
        int min_ending_here = 1;
        int max_so_far = 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                max_ending_here *= arr[i];
                min_ending_here = Math.min(min_ending_here * arr[i], i);
            } else if (arr[i] == 0) {
                max_ending_here = 0;
                min_ending_here = 0;
            } else {
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
        }

        if (max_so_far < max_ending_here)
            max_so_far = max_ending_here;

        System.out.println(max_so_far);
    }
}
