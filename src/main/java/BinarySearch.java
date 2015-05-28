import java.util.Arrays;

/**
 * Created by sky on 5/6/15.
 */
public class BinarySearch {
    public static void binarySearch(int[] arr, int left, int right) {
        if (right < left) return;

        int mid = midPoint(left, right);
        System.out.println(arr[mid]);

        binarySearch(arr, mid + 1, right);
        binarySearch(arr, left, mid - 1);
    }

    private static int midPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        Arrays.sort(arr);

        binarySearch(arr, 0, arr.length - 1);

        int idx = Arrays.binarySearch(arr, 4);
        if (idx != 0)
            System.out.println(idx + " -> " + arr[idx]);

    }
}
