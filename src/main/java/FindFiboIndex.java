/**
 * Created by sky on 5/28/15.
 */
public class FindFiboIndex {

    // Return -1 for invalid inputs
    public static int find(int n) {
        int fibo = 1;
        int prev = 0;
        int idx = 0;

        if (n <= 0)
            return -1;

        while (fibo != n) {
            int t = fibo;
            fibo += prev;

            if (fibo > n)
                break;

            System.out.println(fibo);
            prev = t;
            idx++;
        }

        return idx;
    }

    public static void main(String[] args) {
        System.out.println(find(21));

        int i = Integer.MAX_VALUE / 2;
        int j = Integer.MAX_VALUE / 2;
        int k = i + j + 1;
    }
}