/**
 * Created by sky on 5/23/15.
 */
public class MultiplyAllExceptIndexes {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        for (int i = 0; i < arr.length; i++) {
            int acc = 0;

            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    // Skip index
                    continue;
                }

                if (acc == 0) {
                    acc = arr[j];
                    continue;
                }

                acc *= arr[j];
            }

            System.out.println(acc);
        }
    }
}
