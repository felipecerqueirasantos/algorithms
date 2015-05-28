/**
 * Created by sky on 5/11/15.
 */
public class CountOnesInBinary {
    public static  int countOnes(int value) {
        int mask = 1;
        int counter = 0;

        for (int i = 0; i < 31; i++) {
            if ((value & mask) > 0)
                counter++;

            mask = mask << 1;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countOnes(1));
        System.out.println(countOnes(2));
        System.out.println(countOnes(3));
    }
}
