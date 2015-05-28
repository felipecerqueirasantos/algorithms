
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by sky on 5/17/15.
 */
public class RailWayBusStation {
    private static final class StringToDateComparator implements Comparator<String> {
        private final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");

        @Override
        public int compare(String o1, String o2) {
            try {
                Date d1 = fmt.parse(o1);
                Date d2 = fmt.parse(o2);
                return d1.compareTo(d2);
            } catch (ParseException e) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        String[] arrival = new String[] {"9:00",  "9:40", "9:50",  "11:00", "15:00", "18:00"};
        String[] depertures = new String[] {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"};

        Arrays.sort(arrival, new StringToDateComparator());
        Arrays.sort(depertures, new StringToDateComparator());

        for (String s: arrival)
            System.out.println(s);

    }
}
