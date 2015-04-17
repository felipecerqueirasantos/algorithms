/**
 * Created by sky on 16/04/15.
 */
public class MyPermutation {
    public static void permutation(String word) {
        permutation("", word);
    }

    public static void permutation(String prefix, String word) {
        int n = word.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        permutation("ab");
    }
}
