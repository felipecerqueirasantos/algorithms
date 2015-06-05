import java.util.Arrays;

/**
 * Created by sky on 01/06/15.
 */
public class CrackThePassword {
    private int[] arr = new int[6];
    private int N = arr.length - 1;
    private int[] password = new int[] {7, 3, 5, 1, 9};

    public boolean pressKey(int k) {
        arr[N--] = k;

        if (N < 0) {
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }

            N = 0;
        }

        if (N == 0)
            return comparePassword();

        return false;
    }

    private boolean comparePassword() {
//        for (int i = 1; i < arr.length; i++) {
//            if (i > 1) System.out.print(", ");
//            System.out.print(arr[i]);
//        }
//        System.out.println();

        int[] t = new int[5];
        for (int i = 0; i < 5; i++)
            t[i] = arr[i];

//        System.out.println(t.length + ", " + password.length);
        return Arrays.equals(t, password);
    }

    private void run() {
        while (true) {
            for (int i = 0; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    if (pressKey(j))
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new CrackThePassword().run();
    }
}
