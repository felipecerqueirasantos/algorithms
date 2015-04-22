/**
 * Created by sky on 21/04/15.
 */
public class SumBinary {
    public static int binaryStringToInteger(String binary) {
        int a = 0;
        int mul = 1;

        for (int i = binary.length() - 1; i >= 0; i--) {
            Character chr = binary.charAt(i);
            int bit = chr == '1' ? 1 : 0;
            a += bit * mul;
            mul <<= 1;
        }
        return a;
    }

    public static String integerToBinaryString(int v) {
        int mask = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            if ((v & mask) > 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }

            mask <<= 1;
        }

        String bin = sb.reverse().toString();
        int idx = bin.indexOf('1');
        return bin.substring(idx);
    }

    public static String sumBinary(String binary1, String binary2) {
        int a = 0;
        int b = 0;
        a = binaryStringToInteger(binary1);
        b = binaryStringToInteger(binary2);

        int res = a + b;
        return integerToBinaryString(res);
    }

    public static void main(String[] args) {
        System.out.println(sumBinary("0111101", "1101"));
    }
}
