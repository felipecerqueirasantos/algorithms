/**
 * Created by sky on 6/2/15.
 */
public class RotateLeft {

    public static void rotate(int[] arr, int n) {
        int amount = n % arr.length;
        if (n == 0 || amount == 0)
            return;

        reverse(arr, 0, amount);
        reverse(arr, amount, arr.length);
        reverse(arr, 0, arr.length);

    }

    private static void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            end--;
            int tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        print(arr);
        rotate(arr, 5);
        print(arr);
    }
}
