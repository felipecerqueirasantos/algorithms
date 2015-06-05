/**
 * Created by sky on 6/2/15.
 */
public class Retry1 {
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    /*
        rotate left
        1 2 3 4 5

        rotate(0, n)
        rotate(n, length)
        rotate(0, length)

        rotate right
        1 2 3 4 5

        rotate(0, length - n)
        rotate(length - n, length)
        rotate(0, length)
     */

    public static void rotateLeft(int[] arr, int n) {
        int amount = n % arr.length;

        if (amount == 0 || n <= 0)
            return;

        reverse(arr, 0, amount);
        reverse(arr, amount, arr.length);
        reverse(arr, 0, arr.length);
    }

    public static void rotateRight(int[] arr, int n) {
        int amount = n % arr.length;

        if (amount == 0 || n <= 0)
            return;

        reverse(arr, 0, arr.length - n);
        reverse(arr, arr.length - n, arr.length);
        reverse(arr, 0, arr.length);
    }

    public static void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            end--;
            int t = arr[begin];
            arr[begin] = arr[end];
            arr[end] = t;
            begin++;
        }
    }

    public static int fibonnaci(int n) {
        if (n < 2) return n;
        return fibonnaci(n - 1) + fibonnaci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonnaci(10));
    }
}
