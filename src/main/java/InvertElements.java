/**
 * Created by sky on 5/26/15.
 */
public class InvertElements {
    // Inverting the arrays elements in groups of factor elements
    public static void inPlaceInvertElements(int[] arr, int factor) {
        if (arr.length < factor)
            return;

        for (int i = 0; i < arr.length; i += factor) {
            int e = i + factor - 1;

            if (e >= arr.length)
                break;

            inPlaceInvertElements(arr, factor, i, e);
        }
    }

    // Inverting the segment
    private static void inPlaceInvertElements(int[] arr, int factor, int begin, int end) {
        while (begin < end) {
            exch(arr, begin, end);
            begin++;
            end--;
        }
    }


    // Exchange the elements from indexes s and d
    private static void exch(int[] arr, int s, int d) {
        int t = arr[s];
        arr[s] = arr[d];
        arr[d] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
        inPlaceInvertElements(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
    }
}