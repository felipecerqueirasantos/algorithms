/**
 * Created by sky on 5/28/15.
 */
public class IsPrimeOptimized {
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        int limit = (int) Math.sqrt(n);

        for (int i = 2; i < limit; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static boolean isPrime2(int n) {
        if (n < 2)
            return false;

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i < limit; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(Integer.MAX_VALUE ));
    }
}
