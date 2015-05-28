import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sky on 5/9/15.
 */
public class FindAllTriangles {
    public static void findAllTriangles(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                Integer sum = arr[i] + arr[k];

                int idx = arr.length - 1;
                while (idx > -1 && arr[idx] < sum) {
                    System.out.println(arr[i] + ", " + arr[k] + ", " + arr[idx]);
                    idx--;
                }
            }
        }
    }

    public static void main(String[] args) {
        findAllTriangles(new Integer[] {1, 2, 4, 5, 6});
    }
}
