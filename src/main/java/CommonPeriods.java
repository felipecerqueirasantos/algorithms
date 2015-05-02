import java.util.*;

/**
 * Created by sky on 5/1/15.
 */
public class CommonPeriods {
    public final static class DiscountPeriod<T extends Comparable<T>> implements Comparable<DiscountPeriod<T>> {
        private T begin;
        private T end;
        private int discount;

        public DiscountPeriod(T begin, T end, int discount) {
            this.begin = begin;
            this.end = end;
            this.discount = discount;
        }

        @Override
        public int compareTo(DiscountPeriod<T> o) {
            if (o.begin.compareTo(end) > 0)
                return -1;

            if (o.end.compareTo(begin) < 0)
                return 1;

            return 0;
        }

        public DiscountPeriod<T> getIntersection(DiscountPeriod<T> o) {
            T b = null;
            T e = null;

            if (o.begin.compareTo(begin) > 0)
                b = o.begin;
            else
                b = begin;

            if (o.end.compareTo(end) > 0)
                e = end;
            else
                e = o.end;

            return new DiscountPeriod<>(b, e, discount + o.discount);
        }

        @Override
        public String toString() {
            return "[" + begin + "-" + end + ", discount: " + discount + "]";
        }
    }

    public static void main(String[] args) {
        DiscountPeriod<Integer> p1 = new DiscountPeriod<>(1, 5, 10);
        DiscountPeriod<Integer> p2 = new DiscountPeriod<>(2, 8, 5);
        DiscountPeriod<Integer> p3 = new DiscountPeriod<>(4, 6, 20);
        DiscountPeriod<Integer> p4 = new DiscountPeriod<>(20, 30, 10);

        List<DiscountPeriod<Integer>> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        List<DiscountPeriod<Integer>> outList = new ArrayList<>();
        DiscountPeriod<Integer> tmp = null;

        for (DiscountPeriod p: list) {
            if (tmp == null) {
                tmp = p;
                continue;
            }

            if (p.compareTo(tmp) == 0) {
                tmp = p.getIntersection(tmp);
            } else {
                outList.add(tmp);
                tmp = p;
            }
        }
        outList.add(tmp);

        // Reverse order
        Collections.sort(outList, new Comparator<DiscountPeriod<Integer>>() {
            @Override
            public int compare(DiscountPeriod<Integer> p1, DiscountPeriod<Integer> p2) {
                return p2.discount - p1.discount;
            }
        });

        Iterator it = outList.iterator();
        System.out.println(it.next());
    }
}
