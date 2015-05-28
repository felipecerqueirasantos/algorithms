import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sky on 5/25/15.
 */
public class ItineraryInOrder {
    public static final class Ticket {
        private String from;
        private String to;

        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "[from: " + from + ", to: " + to + "]";
        }
    }

    public static void main(String[] args) {
        List<Ticket> itinerary = new ArrayList<>();
        itinerary.add(new Ticket("MUC", "LHR"));
        itinerary.add(new Ticket("CDG", "MUC"));
        itinerary.add(new Ticket("SFO", "SJC"));
        itinerary.add(new Ticket("LHR", "SFO"));

        Collections.sort(itinerary, (t1, t2) -> {
            int cmp = t1.from.compareTo(t2.to);
            return cmp;
        });

        for (Ticket t: itinerary)
            System.out.println(t);
    }
}
