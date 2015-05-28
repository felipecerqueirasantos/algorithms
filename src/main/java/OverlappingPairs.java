import java.util.*;

/**
 * Created by sky on 5/13/15.
 */
public class OverlappingPairs {
    public static final class Pair implements Comparable<Pair> {
        private int begin;
        private int end;

        public Pair(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public Pair mergePair(Pair o) {
            int b = Math.min(begin, o.begin);
            int e = Math.max(end, o.end);

            return new Pair(b, e);
        }

        public boolean checkOverlapping(Pair o) {
            if (o.begin > end)
                return false;

            if (o.end < begin)
                return false;

            return true;
        }

        // 0,7.compareTo(1,4) < 0
        // 1,4.compareTo(0,7) > 0
        // 1,4.compareTo(1,3) > 0
        @Override
        public int compareTo(Pair o) {
            int ret = begin - o.begin;
            if (ret == 0) {
                return end - o.end;
            }
            return ret;
        }

        @Override
        public String toString() {
            return "[" + begin + "," + end + "]";
        }
    }

    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, 2));
        pairs.add(new Pair(5, 6));
        pairs.add(new Pair(1, 5));
        pairs.add(new Pair(7, 8));
        pairs.add(new Pair(1, 6));


        Map<Pair, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            Pair p = pairs.get(i);
            indexMap.put(p, i);
        }

        Collections.sort(pairs);
        for (Pair p: pairs) {
            System.out.println("-> " + p);
        }

        Pair previous = null;
        Pair current = null;
        List<Integer> mergedIndexes = new ArrayList<>();

        Iterator<Pair> it = pairs.iterator();

        while (it.hasNext()) {
            if (previous == null) {
                previous = it.next();
                continue;
            }

            current = it.next();

            if (previous.checkOverlapping(current)) {
                Pair t = previous.mergePair(current);
                System.out.println(previous + " merge " + current + " --> " + t);
                Integer idx;
                idx = indexMap.get(previous);
                if (idx != null) {
                    System.out.println("idx: " + idx);
                }
                idx = indexMap.get(current);
                if (idx != null) {
                    System.out.println("idx: " + idx);
                }

                previous = t;
                continue;
            }

            previous = current;
        }

        for (Pair p: pairs) {
            System.out.println(p);
        }
    }
}
