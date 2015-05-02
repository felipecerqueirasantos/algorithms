import java.util.Arrays;

/**
 * Created by sky on 5/2/15.
 */
public class MinAbsValue {
    public static void main(String[] args) {
        int[] arr = {2, -4, 6, 3, 9};
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(Math.abs(arr[i] - arr[i - 1]), min);
        }

        System.out.println(min);
    }
}
