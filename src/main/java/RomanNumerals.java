/**
 * Created by sky on 17/04/15.
 */
public class RomanNumerals {
    public static void main(String[] args) {
        int n = 159;
        int div = 10;

        String s = "";

        while (n > 0) {
            int d = n % div;

            System.out.println(d);

            if (d > 7 && d < 10) {

            }
            n -= d;
            div *= 10;
        }
    }
}
