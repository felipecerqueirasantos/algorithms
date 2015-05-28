/**
 * Created by sky on 5/18/15.
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 3, 3, 2, 1, 1, 1, 1};
        int[] freq = new int[3];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - 1]++;
        }

        int idx = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < freq[i]; j++) {
                arr[idx++] = i + 1;
            }
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }

}
