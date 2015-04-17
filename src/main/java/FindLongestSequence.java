/**
 * Created by sky on 16/04/15.
 */
public class FindLongestSequence {
    public static void main(String[] args) {
        //int[] arr = {1, 2, -3, 2, 3, 4, -6, 1, 2, 3, 4, 5, -8, 5, 6};
        //int[] arr = {1, 2, 3, 1, 2, 3, 4};
        int[] arr = {1, 2, 3, 4};
        int[] tmp = new int[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            tmp[i - 1] = arr[i] - arr[i - 1];
            System.out.print(tmp[i - 1] + " ");
        }
        System.out.println();

        int i = 0;
        int maxRepeated = 0;
        int repeated;
        int idx = 0;

        while (i < tmp.length) {
            int j = i + 1;

            repeated = 2;
            while (j < tmp.length && tmp[j] == tmp[i]) {
                j++;
                repeated++;
            }

            if (repeated > maxRepeated) {
                idx = i;
                maxRepeated = repeated;
            }

            i = j;
        }

        idx += 1;

        System.out.println(idx + " " + maxRepeated);

    }
}
