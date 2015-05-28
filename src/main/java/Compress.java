/**
 * Created by sky on 5/5/15.
 */
public class Compress {
    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();

        Character prev = s.charAt(0);
        int count = 1;

        sb.append(prev);

        for (int i = 1; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current == prev) {
                prev = current;
                count++;
                continue;
            }

            sb.append(count);
            sb.append(current);
            prev = current;
            count = 1;
        }

        sb.append(count);

        String compressed = sb.toString();
        if (compressed.length() > s.length())
            return s;

        return compressed;
    }

    public static void main(String[] args) {
        String s = "aaabbaa";
        String compressed = compress(s);
        System.out.println(compressed);
    }
}