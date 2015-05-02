/**
 * Created by sky on 5/1/15.
 */
public class SumPermutation {
    public static void allSumPermutations(int[] arr, int sum) {
        allSumPermutations(arr, sum, "");
    }

    private static void allSumPermutations(int[] arr, int rest, String acc) {
        if (rest == 0) {
            System.out.println(acc);
            return;
        }

        if (rest < 0)
            return;

        for (int i = 0; i < arr.length; i++)
            allSumPermutations(arr, rest - arr[i], acc + arr[i]);
    }

    public static void main(String[] args) {
        allSumPermutations(new int[] {2, 3, 5}, 10);
    }
}
