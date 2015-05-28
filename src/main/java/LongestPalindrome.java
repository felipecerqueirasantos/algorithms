import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 5/13/15.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";

        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();

            int j = s.length() - 1;
            for (int k = 0; k <= i; k++)
                sb.append(s.charAt(j--));

            if (sb.length() > 0) {
                String t = sb.reverse().toString();
                System.out.println(t);
                subs.add(t);
            }
        }

        for (String t: subs) {
            if (t.compareTo(s) == 0) {

            }
        }
    }
}
