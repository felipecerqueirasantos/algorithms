/**
 * Created by sky on 6/2/15.
 */
public class RotateLeftRetry {
    public static void rotateLeft(int[] arr, int n) {
        int amount = n % arr.length;

        if (amount == 0 || n == 0)
            return;

        reverse(arr, 0, amount);
        reverse(arr, amount, arr.length);
        reverse(arr, 0, arr.length);
    }

    private static void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            end--;
            int t = arr[begin];
            arr[begin] = arr[end];
            arr[end] = t;
            begin++;
        }
    }


}
