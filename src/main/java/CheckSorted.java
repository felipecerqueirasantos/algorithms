/**
 * Created by sky on 4/30/15.
 */

/* Description:
 * Given an array with elements check if just by exchanging two elements of the array we get a sorted array.
 */
public class CheckSorted {
    public static int countOutOfOrderElements(int[] arr) {
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                count++;
        }
        return count;
    }

    public static boolean checkAlmostSorted(int[] arr) {
        if (countOutOfOrderElements(arr) == 2)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1};
        System.out.println(checkAlmostSorted(arr));
    }
}
