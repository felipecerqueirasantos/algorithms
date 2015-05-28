/**
 * Created by sky on 5/26/15.
 */
/*
Example : [2,1,3,4,7,9,24,98]
Answer : 1,2,3,4,7,24,9,98
 */

public class OrganizeEvenAndOdd {

    public static void organizeEvenAndOdd(int[] arr) {
        for (int i = 0; i < arr.length - 2; i += 2) {
            if (!(arr[i] % 2 != 0)) {
                exch(arr, i, i + 1);
            }
        }

        for (int i = 1; i < arr.length - 2; i += 2) {
            if ((arr[i] % 2 != 0)) {
                exch(arr, i, i + 1);
            }
        }
    }

    public static void exch(int[] arr, int s, int d) {
        int t = arr[s];
        arr[s] = arr[d];
        arr[d] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,1,3,4,7,9,24,98};
        organizeEvenAndOdd(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
    }
}