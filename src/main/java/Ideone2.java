/**
 * Created by sky on 4/6/15.
 */


//amazon-interview-questions
//Given an array of ints, return a string identifying the range of numbers
//Example:
//Input arr - [0 1 2 7 21 22 1098 1099]
//Output - "0-2,7,21-22,1098-1099"

public class Ideone2 {
    public static String getRangeString(int[] arr) {
        if (arr.length == 0)
            return "";

        StringBuilder sb = new StringBuilder(arr.length);
        sb.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] == 1) {
                if (sb.charAt(sb.length() - 1) != '-')
                    sb.append("-");

                continue;
            }

            if (sb.charAt(sb.length() - 1) == '-') {
                sb.append(arr[i - 1]);
            }

            if (sb.charAt(sb.length() - 1) != ',')
                sb.append(",");

            sb.append(arr[i]);
        }

        if (sb.charAt(sb.length() - 1) == '-')
            sb.append(arr[arr.length - 1]);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 7, 21, 22, 1098, 1099};
        String s = getRangeString(arr);
        System.out.println(s);
    }
}
