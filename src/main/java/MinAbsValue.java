import java.util.Arrays;

/**
 * Created by sky on 5/2/15.
 */
public class MinAbsValue {

    public int solution(int[] A) {
        int[] sumArray = new int[A.length];
        sumArray[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            sumArray[i] = sumArray[i] - sumArray[i - 1];
        }

        Arrays.sort(sumArray);

        int minDiff = Math.abs(sumArray[0]);

        for (int i = 1; i < sumArray.length; i++) {
            minDiff = Math.min(minDiff, Math.abs(sumArray[i] - sumArray[i - 1]));
            minDiff = Math.min(minDiff, Math.abs(sumArray[i]));
        }

        return minDiff;
    }

    public void run() {
        System.out.println(solution(new int[]{20, -40, 60, 3, 90, 1}));
    }

    public static void main(String[] args) {
        new MinAbsValue().run();
    }
}
