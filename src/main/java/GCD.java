/**
 * Created by sky on 5/28/15.
 */
public class GCD {
    // Return -1 when there is no gcd
    public static int gcd(int a, int b) {
        int ret = -1;

        for (int i = 2; i < Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                ret = i;
            }
        }

        return ret;
    }

    public static int gcdImproved(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(3, 5));
        System.out.println(gcd(15, 25));
        System.out.println(gcd(384972392, 23483292));
        System.out.println(gcdImproved(12, 8));
    }
}
