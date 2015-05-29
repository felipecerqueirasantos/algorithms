import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by sky on 5/28/15.
 */
public class TreeMapMultipleSort {
    public static class Item {
        private int id;
        private int time;
        private int favorite;

        public Item(int id, int time, int favorite) {
            this.id = id;
            this.time = time;
            this.favorite = favorite;
        }
    }

    public static void main(String[] args) {
        TreeSet<Item> set = new TreeSet<>((o1, o2) -> {
            int cmp = o1.time - o2.time;
            if (cmp == 0)
                return o2.favorite - o1.favorite;

            return cmp;
        });


    }


}
