/**
 * Created by sky on 5/16/15.
 */
public class FindTheUnsortedElement {
    /*
    You are given an array as an input. The array is organized in such a way that its element are arranged in increasing
    order up till a certain index and in decreasing order after that. Write an algorithm to search an element
    in such a array.
     */

    // midPoint that avoids integer overflow
    public static int midPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    public static boolean checkInOrder(int[] arr, int idx) {
        int l = idx - 1;
        if (l < 0) l++;

        if (arr[idx] < arr[l])
            return false;

        // It is in order
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 10, 9, 8, 7, 6};
        int left = 0;
        int right = arr.length - 1;

        boolean foundOutOfOrder = false;
        int savedIdxOutOfOrder = 0;

        while (right >= left) {
            int midPoint = midPoint(left, right);
            if (checkInOrder(arr, midPoint)) {
                left = midPoint + 1;
                continue;
            }

            foundOutOfOrder = true;
            savedIdxOutOfOrder = midPoint;
            right = midPoint - 1;
        }

        if (foundOutOfOrder) {
            while (!checkInOrder(arr, savedIdxOutOfOrder))
                savedIdxOutOfOrder--;

            savedIdxOutOfOrder++;
        }

        System.out.println(arr[savedIdxOutOfOrder]);
    }
}
