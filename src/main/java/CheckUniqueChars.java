import java.util.Arrays;

/**
 * Created by sky on 05/05/15.
 */
public class CheckUniqueChars {
    public static boolean checkUniqueChars(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        boolean ret = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                ret = false;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(checkUniqueChars("abcdefgh"));
        System.out.println(checkUniqueChars("abcdefgha"));
    }
}
