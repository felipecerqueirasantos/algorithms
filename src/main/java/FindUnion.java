import java.util.HashSet;
import java.util.Set;

/**
 * Created by sky on 08/05/15.
 */
public class FindUnion {

    public static void main(String[] args) {
        int [] arr1 = new int[] {7, 1, 5, 2, 3, 6};
        int [] arr2 = new int[] {3, 8, 6, 20, 7};

        int [] biggest;
        int [] smaller;

        if (arr1.length > arr2.length) {
            biggest = arr1;
            smaller = arr2;
        } else {
            biggest = arr2;
            smaller = arr1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < biggest.length; i++) {
            set.add(biggest[i]);
        }

        int found = 0;
        for (int i = 0; i < smaller.length; i++) {
            if (set.contains(smaller[i])) {
                if (found == 0) System.out.print("{");
                if (found > 0) System.out.print(",");
                System.out.print(smaller[i]);
                found++;
            }
        }

        if (found > 0) System.out.println("}");
    }
}