import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by sky on 15/05/15.
 */
public class TreeMapLowerBound {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 7, 4, 1, 2, 0};
        int k = 5;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);

        for (int i = 0; i < arr.length; i++) {
            int diff = k - arr[i];
            NavigableSet<Integer> nav = set.headSet(diff, true);
            Iterator<Integer> it = nav.iterator();

            while (it.hasNext()) {
                int value = it.next();
                int res = arr[i] + value;
                System.out.println(arr[i] + " + " + value + " = " + res);
            }
        }
    }
}
