/**
 * Created by sky on 5/26/15.
 */
public class PermuteIt {

    public static void permutation(String s) {
        permutation("", s);
    }

    private static void permutation(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < n; i++) {
            permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        permutation(s);
    }
}
