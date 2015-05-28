import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 05/05/15.
 */


public class CheckPermutation {
    private static final class Counter implements Comparable<Counter> {
        private int counter;

        public Counter(int initial) {
            this.counter = initial;
        }

        public Counter() {
            this(0);
        }

        public void increment() {
            counter++;
        }

        @Override
        public int compareTo(Counter c) {
            return counter - c.counter;
        }

        @Override
        public String toString() {
            return "[" + counter + "]";
        }
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        Map<Character, Counter> s1Freq = makeFrequency(s1);
        Map<Character, Counter> s2Freq = makeFrequency(s2);

        boolean ret = true;

        for (Character k: s1Freq.keySet()) {
            Counter c1 = s1Freq.get(k);
            Counter c2 = s2Freq.get(k);

            if (c1 == null || c2 == null) {
                ret = false;
                break;
            }

            if (c1.compareTo(c2) != 0) {
                ret = false;
                break;
            }
        }

        return ret;
    }

    public static Map<Character, Counter> makeFrequency(String s) {
        Map<Character, Counter> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);

            Counter c = freq.get(chr);
            if (c != null) {
                c.increment();
            } else {
                freq.put(chr, new Counter(1));
            }
        }

        return freq;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("felipe", "eflipe"));  // true
        System.out.println(checkPermutation("felipe", "felipe"));  // true
        System.out.println(checkPermutation("felipe", "eflipee")); // false
        System.out.println(checkPermutation("felipe", "eflipeX")); // false

    }
}