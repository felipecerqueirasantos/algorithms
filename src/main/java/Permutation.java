/**
 * Created by sky on 16/04/15.
 */
public class Permutation {
    private static int count = 0;
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(++count + " " + prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void main(String[] args) {
        String s = "tree";
        permutation(s);
    }
}
