/**
 * Created by sky on 5/27/15.
 */
public class BSearch {
    public static int bSearch(int[] arr, int needed) {
        int left = 0;
        int right = arr.length - 1;
        int found = -1;

        /*
             1, 2, 3, 4, 5, 6, 7, 8, 9
             left = 0;
             right = 8
             mid = 4

             left = 0
             right = 3
         */
        while (left <= right) {
            int mid = mid(left, right);

            if (arr[mid] == needed) {
                found = mid;
                break;
            }

            if (needed > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return found;
    }

    private static int mid(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(bSearch(arr, 1));
        System.out.println(bSearch(arr, 0));
        System.out.println(bSearch(arr, 9));
        System.out.println(bSearch(arr, 6));
    }
}
