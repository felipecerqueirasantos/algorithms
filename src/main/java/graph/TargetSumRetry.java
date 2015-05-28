package graph;

/**
 * Created by sky on 5/9/15.
 */
public class TargetSumRetry {
    public static void targetSum(int[] arr, int targetSum) {
        targetSum(arr, targetSum, "");
    }


    private static void targetSum(int[] arr, int leftToZero, String combination) {
        if (leftToZero == 0) {
            System.out.println(combination);
            return;
        }

        if (leftToZero < 0)
            return;

        for (int i = 0; i < arr.length; i++) {
            targetSum(arr, leftToZero - arr[i], combination + arr[i]);
        }
    }

    public static void main(String[] args) {
        targetSum(new int[]{2, 3, 5}, 10);
    }
}
