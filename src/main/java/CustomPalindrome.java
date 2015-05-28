/**
 * Created by sky on 5/4/15.
 */

public class CustomPalindrome {
    public static boolean checkCustomPalindrome(String s) {
        String copy = s.toUpperCase();
        int b = 0;
        int e = s.length() - 1;
        boolean ret = true;

        while (b < e) {
            // I dont know if isAlpha exists, so, I will create my own
            if (!isValid(copy.charAt(b))) {
                b++;
                continue;
            }

            if (!isValid(copy.charAt(e))) {
                e--;
                continue;
            }

            if (copy.charAt(b) != copy.charAt(e)) {
                ret = false;
                break;
            }

            b++;
            e--;
        }

        return ret;
    }

    private static boolean isValid(Character chr) {
        if (chr >= 'a' && chr <= 'z')
            return true;

        if (chr >= 'A' && chr <= 'Z')
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkCustomPalindrome("A man, a plan, a canal, Panama!"));

    }

}