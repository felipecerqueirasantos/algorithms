/**
 * Created by sky on 5/18/15.
 */
/*
eg. -2 3 4 5 -1 -6 7 9 1
result – 3 -2 4 -1 5 -6 7 9 1.
*/

public class ReArrangeArrayPositiveAndNegative {
    public static void main(String[] args) {
        int arr[] = new int[] {-2, 3, 4, 5, -1, -6, 7, 9, 1};

        // I need to know how many positive and negative numbers O(n)
        int totNegative = 0;
        int totPositive = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                totNegative++;
            else
                totPositive++;
        }

        // totNegative = 3
        // totPositive = 6

        int negativeIdx = 0;
        int positiveIdx = totNegative;

        // Second loop in O(n)
        while (negativeIdx < positiveIdx && positiveIdx < arr.length) {
            if (arr[negativeIdx] < 0) {
                negativeIdx++;
                continue;
            }

            if (arr[positiveIdx] > 0) {
                positiveIdx++;
                continue;
            }

            if (arr[negativeIdx] > 0 && arr[positiveIdx] < 0) {
                exch(arr, negativeIdx, positiveIdx);
                negativeIdx++;
                positiveIdx++;
            }
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }

    // Exchange arr[i] and arr[k] elements
    private static void exch(int[] arr, int i, int k) {
        int t = arr[i];
        arr[i] = arr[k];
        arr[k] = t;
    }
}