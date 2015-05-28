/**
 * Created by sky on 5/7/15.
 */
public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 1, 3, 2, 2};
        int acc = 0;

        for (int i = 0; i < arr.length; i++)
            acc += arr[i];

        int rightSum = 0;
        int leftSum = acc;

        boolean found = false;
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            leftSum -= arr[i];


            if (leftSum == rightSum) {
                found = true;
                idx = i;
                break;
            }

            rightSum += arr[i];
        }

        if (found)
            System.out.println("Found: " + idx);

    }
}
