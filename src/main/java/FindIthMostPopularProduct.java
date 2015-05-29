import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sky on 5/28/15.
 */
public class FindIthMostPopularProduct {
    public static final class Item {
        private String itemId;
        private int quantitySold;

        public Item(String itemId, int quantitySold) {
            this.itemId = itemId;
            this.quantitySold = quantitySold;
        }

        public String toString() {
            return "[" + "itemId: " + itemId + ", " + "quantitySold: " + quantitySold + "]";
        }
    }

    /**
     * Find i-th most popular item sold
     */
    public static String find(List<Item> items, int i) {
        PriorityQueue<Item> minHeap = new PriorityQueue<Item>((o1, o2) -> (o1.quantitySold - o2.quantitySold));

        for (Item item: items) {
            minHeap.add(item);

            if (minHeap.size() > i) {
                // Del min
                minHeap.remove();
            }
        }

        Iterator<Item> it = minHeap.iterator();
        if (it.hasNext()) {
            Item item = it.next();
            return item.itemId;
        }

        return null;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Mobile phone", 100));
        items.add(new Item("Chair", 10));
        items.add(new Item("TV", 3));
        items.add(new Item("Sofa", 2));

        String secondMostPopular = find(items, 2);
        if (secondMostPopular != null)
            System.out.println(secondMostPopular); // Chair

    }
}
