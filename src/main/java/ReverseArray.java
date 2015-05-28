/**
 * Created by sky on 08/05/15.
 */
public class ReverseArray {
    public static void reverseArray(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += k) {

            int e = i + k - 1;
            int b = i;

            if (e >= arr.length)
                break;

            while (b < e) {
                exch(arr, b, e);
                b++;
                e--;
            }

        }

    }

    public static void exch(int arr[], int b, int e) {
        int tmp = arr[b];
        arr[b] = arr[e];
        arr[e] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        reverseArray(arr, 5);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }

    }
}