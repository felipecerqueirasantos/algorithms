import java.util.TreeSet;

/**
 * Created by sky on 5/27/15.
 */
public class UsingTreeSet {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 7, 8, 10, 99};
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i: arr) {
            treeSet.add(i);
        }

        System.out.println(treeSet.floor(80)); // 10
        System.out.println(treeSet.ceiling(12)); // 99

        for (Integer i: treeSet.headSet(9)) {
            System.out.println(i); // 1, 4, 6, 7, 8
        }

        for (Integer i: treeSet.tailSet(8, false)) {
            System.out.println(i); // 10, 99
        }
    }
}
