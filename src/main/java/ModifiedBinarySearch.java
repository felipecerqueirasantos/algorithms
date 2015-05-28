/**
 * Created by sky on 5/27/15.
 */
public class ModifiedBinarySearch {

    public static int modifiedBinarySearch(int[] arr, int needed) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = midPoint(left, right);
            if (arr[mid] == needed)
                return mid;


            if (arr[left] <= arr[mid]) {
                // Left to mid in increasing order
                if (arr[left] <= needed && needed < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                // Left to mid in decreasing order
                if (arr[mid] < needed && needed <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    private static int midPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(modifiedBinarySearch(arr, 3));
        System.out.println(modifiedBinarySearch(arr, 4));
        System.out.println(modifiedBinarySearch(arr, 2));
        System.out.println(modifiedBinarySearch(arr, 0));
    }
}
