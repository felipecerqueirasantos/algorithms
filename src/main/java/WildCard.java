/**
 * Created by sky on 08/05/15.
 */
public class WildCard {
    public static void printWildCard(String s) {
        printWildCard(s, "");
    }

    public static void printWildCard(String s, String prefix) {
        if (s.length() == 0) {
            System.out.println(prefix);
            return;
        }

        String first = s.substring(0, 1);
        String sub = s.substring(1);

        if (first.compareTo("?") == 0) {
            printWildCard(sub, prefix + "1");
            printWildCard(sub, prefix + "0");
        } else {
            printWildCard(sub, prefix + first);
        }
    }

    public static void main(String[] args) {
        printWildCard("01?0?");
    }
}