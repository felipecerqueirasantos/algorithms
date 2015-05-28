import java.util.Arrays;

/**
 * Created by sky on 5/10/15.
 */
public class SumArrayOfChar {
    public static char[] sumArrays(char[] A, char[] B) {
        char[] TA = transformArray(A);
        char[] TB = transformArray(B);
        char[] R = new char[Math.max(TA.length, TB.length) + 1];

        dumpArray(TA);
        dumpArray(TB);

        int idxTA = TA.length - 1;
        int idxTB = TB.length - 1;
        int idxR = R.length - 1;
        int rest = 0;

        for (int i = 0; i < 2; i++) {
            int t = TA[idxTA] + TB[idxTB] + rest;
            rest = t / 10;
            if (rest > 0) t = t % 10;

            R[idxR] = (char) t;

            idxR--;
            idxTA--;
            idxTB--;
        }

        idxTA--;
        idxTB--;
        idxR--;

        R[R.length - 3] = '.';

        while (idxTA >= 0 && idxTB >= 0) {
            int t = TA[idxTA] + TB[idxTB] + rest;
            rest = t / 10;
            if (rest > 0) t = t % 10;

            R[idxR] = (char) t;

            idxR--;
            idxTA--;
            idxTB--;
        }

        while (idxTA >= 0) {
            int t = TA[idxTA] + rest;
            rest = t / 10;
            if (rest > 0) t = t % 10;

            R[idxR] = (char) t;

            idxR--;
            idxTA--;
        }

        while (idxTB >= 0) {
            int t = TB[idxTB] + rest;
            rest = t / 10;
            if (rest > 0) t = t % 10;

            R[idxR] = (char) t;

            idxR--;
            idxTB--;
        }

        dumpArray(R);

        // Retornando o resultado
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R.length; i++) {
            if (R[i] == 0) continue;
            if (R[i] == '.') sb.append(".");
            else sb.append((int) R[i]);
        }

        return sb.toString().toCharArray();
    }

    public static void dumpArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //if (i > 0) System.out.print("");
            if (arr[i] != '.') System.out.print((int)arr[i]);
            else System.out.print(arr[i]);
        }
        System.out.println();
    }

    // Transform '0' to 0 and add fractionary part: 1.2 = 1.20 / 1 = 1.00
    private static char[] transformArray(char[] arr) {
        int idxDot = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '.') {
                idxDot = i;
                continue;
            }

            arr[i] -= '0';
        }

        if (idxDot != -1 && arr.length - idxDot == 3) {
            return Arrays.copyOf(arr, arr.length);
        }

        char[] T = null;

        if (idxDot == -1) {
            T = Arrays.copyOf(arr, arr.length + 3);
            T[arr.length - 3] = '.';

        } else if (arr.length - idxDot < 3) {
            T = Arrays.copyOf(arr, arr.length + 1);
        }

        return T;
    }

    public static void main(String[] args) {
        char[] a = new char[] {'4', '3', '.', '9', '9'};
        char[] b = new char[] {'1', '1', '.', '2', '2'};

        char[] r = sumArrays(a, b);
        for (int i = 0; i < r.length; i++)
            System.out.print(r[i]);
        System.out.println();
    }
}
