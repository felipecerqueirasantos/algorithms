import java.util.*;

/**
 * Created by sky on 4/19/15.
 */
public class FirstNonRepeatedCharacter {
    private static class Counter {
        private int counter;

        public Counter(int initial) {
            this.counter = initial;
        }

        public void increment() {
            this.counter++;
        }

        @Override
        public String toString() {
            return "[" + this.counter + "]";
        }
    }

    public static void main(String[] args) {
        String s = "abcdeabc";
        Map<Character, Counter> freq = new HashMap<>();
        Set<Character> nonRepeated = new LinkedHashSet<>();

        for (int i = 0; i  < s.length(); i++) {
            Character chr = s.charAt(i);
            Counter c = freq.get(chr);
            if (c != null) {
                c.increment();
                if (c.counter == 2) {
                    nonRepeated.remove(chr);
                }
            } else {
                freq.put(chr, new Counter(1));
                nonRepeated.add(chr);
            }
        }


        Iterator it = nonRepeated.iterator();
        if (it.hasNext())
            System.out.println("First non repeated: " + it.next());
    }
}
