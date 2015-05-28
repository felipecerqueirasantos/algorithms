/**
 * Created by sky on 5/24/15.
 */
public class FindLargesSumFromUnsortedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {12, 34, 10, 6, 40};
//        int[] arr = new int[] {1, 1, 1, 1, 1};

        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > biggest) {
                secondBiggest = biggest;
                biggest = arr[i];
            } else if (arr[i] > secondBiggest && arr[i] != biggest) {
                secondBiggest = arr[i];
            }
        }

        if (biggest != Integer.MIN_VALUE && secondBiggest != Integer.MIN_VALUE)
            System.out.println(biggest + secondBiggest);
    }
}
