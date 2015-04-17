/**
 * Created by sky on 4/6/15.
 */

//        Sparse number is an integer if there are no adjacent 1 in it's binary representation.
//        Like: 5 -> 101 (no adjacent 1)
//        9 -> 1001 (no adjacent 1)
//        while 6-> 110 is not sparse number.
//        Now you are given an integer find the NEXT BIGGER sparse number.Please mind 'it is next bigger'.
// URL: http://www.careercup.com/question?id=5186975457869824

public class Ideone3 {
    public static boolean isSparse(int value) {
        StringBuilder sb = new StringBuilder(128);
        int mask = 1;

        while (mask <= value) {
            if ((value & mask) != 0)
                sb.append("1");
            else
                sb.append("0");

            mask = mask << 1;
        }

        boolean ret = true;

        for (int i = 1; i < sb.length(); i += 2) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                ret = false;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int given = 200;

        for (int i = given + 1; i < Integer.MAX_VALUE; i++) {
            if (isSparse(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
