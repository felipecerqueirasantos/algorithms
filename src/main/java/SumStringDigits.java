/**
 * Created by sky on 4/8/15.
 */
public class SumStringDigits {
    public static void main(String[] args) {
        String s = "asdf12bgt3bh5j";
        StringBuilder sb = new StringBuilder();
        int acc = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (sb.length() > 0) {
                acc += Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
        }

        System.out.println(acc);
    }
}
