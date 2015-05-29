/**
 * Created by sky on 5/28/15.
 */
public class LCM {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(72, 21));
        System.out.println(gcd(72, 21));
    }
}
