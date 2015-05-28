/**
 * Created by sky on 5/27/15.
 */
public class Combine {
    public static void combine(String s) {
        combine("", s);
    }

    private static void combine(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < n; i++)
            combine(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
    }

    public static void main(String[] args) {
        combine("felipe");
    }
}
