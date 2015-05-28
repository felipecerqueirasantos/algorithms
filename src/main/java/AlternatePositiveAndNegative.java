/**
 * Created by sky on 5/18/15.
 */
public class AlternatePositiveAndNegative {
    public static void main(String[] args) {
        int[] arr = new int[] {-2, 3, 4, 5, -1, -6, 7, 9, 1};

        int posIdx = -1;
        int negIdx = -1;

        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] < 0)
                exch(arr, i, (i + 1) % arr.length);
        }

        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] > 0)
                exch(arr, i, (i + 1) % arr.length);
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void exch(int[] arr, int s, int d) {
        int t = arr[s];
        arr[s] = arr[d];
        arr[d] = t;
    }

}