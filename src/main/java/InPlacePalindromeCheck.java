/**
 * Created by sky on 16/04/15.
 */
public class InPlacePalindromeCheck {
    public static void main(String[] args) {
        String word = "A man, a plan, a canal, Panama";
        System.out.println(isPalindrome(word));
    }

    private static boolean isPalindrome(String word) {
        boolean ret = true;

        int i = 0;
        int j = word.length() -1;

        while (j > i) {
            if (!Character.isDigit(word.charAt(j))) {
                j--;
                continue;
            }

            if (!Character.isDigit(word.charAt(i))) {
                i++;
                continue;
            }

            if (word.charAt(i) != word.charAt(j)) {
                ret = false;
                break;
            }
            j--;
            i++;
        }

        return ret;
    }
}
