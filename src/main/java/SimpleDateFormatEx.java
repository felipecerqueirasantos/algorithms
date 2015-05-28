import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sky on 5/19/15.
 */
public class SimpleDateFormatEx {

    public static void main(String[] args) {
        List<Date> l = new ArrayList<>();
        String[] dates = new String[] {"09:10", "09:09"};

        try {
            SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");

            for (String s: dates)
                l.add(fmt.parse(s));

            Collections.sort(l);

            for (Date d: l)
                System.out.println(d);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
