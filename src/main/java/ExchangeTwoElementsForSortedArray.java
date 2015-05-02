/**
 * Created by sky on 5/1/15.
 */
public class ExchangeTwoElementsForSortedArray {
    public static boolean solution(int[] arr) {
        if (arr.length <= 1) {
            System.out.println("Not enough element to swap");
            return true;
        }
        boolean flag = true;
        int first = -1;
        int second = -1;

        for (int i = 1; i < arr.length; i++) {
            if (flag) {
                if (arr[i - 1] > arr[i]) {
                    first = i - 1;
                    flag = false;
                }
            } else {
                if (arr[first] <= arr[i]) {
                    second = i - 1;
                }
            }

            if (second != -1) {
                break;
            }
        }
        if (second == -1) {
            second = arr.length - 1;
        }
        if (first == -1) {
            return false;
        }
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 2, 2, 5}));
        System.out.println(solution(new int[]{4, 2, 2, 2, 3}));
        System.out.println(solution(new int[]{3, 2, 2, 2, 3, 3, 4, 4, 4}));
        System.out.println(solution(new int[]{3, 2}));
        System.out.println(solution(new int[]{3, 2, 2}));
        System.out.println(solution(new int[]{3, 2, 4}));
        System.out.println(solution(new int[]{8, 2, 2, 4}));
        System.out.println(solution(new int[]{8}));
    }
}
