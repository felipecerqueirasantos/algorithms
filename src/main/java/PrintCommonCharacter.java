/**
 * Created by sky on 4/9/15.
 */
public class PrintCommonCharacter {
    public static void main(String[] args) {
        String s1 = "bagalore";
        String s2 = "mysore";

        String longerString;
        String shorterString;

        if (s1.length() > s2.length()) {
            longerString = s1;
            shorterString = s2;
        } else {
            longerString = s2;
            shorterString = s1;
        }

        int[] frequency = new int[127];
        for (int i = 0; i < longerString.length(); i++) {
            frequency[longerString.charAt(i)]++;
        }

        for (int i = 0; i < shorterString.length(); i++) {
            if (frequency[shorterString.charAt(i)] != 0)
                System.out.print(shorterString.charAt(i));
        }

        System.out.println();
    }
}
