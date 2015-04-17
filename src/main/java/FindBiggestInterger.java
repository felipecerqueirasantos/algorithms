/**
 * Created by sky on 4/8/15.
 */
/* Counting sort */
public class FindBiggestInterger {
    public static void main(String[] args) {
        int value = 3876554;

        int[]countSort = new int[10];

        // O(n) solution instead of n Log n (quick sort))
        while(value > 0) {
            int res = value % 10;
            countSort[res]++;
            value = value / 10;
        }

        for(int i = countSort.length - 1; i > 0; i--) {
            for (int j = 0; j < countSort[i]; j++) {
                System.out.print(i);
            }
        }

    }
}
