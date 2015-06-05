package restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 05/06/15.
 */
public final class Availability {
    private final List<Table> tableList;
    private int totalOfChairs;

    public Availability(List<Table> tableList) {
        this.tableList = tableList;
        updateTotalOfChairs();
    }

    public List<Table> getTables(int totalOfGuests) throws AvailabilityException {
        if (totalOfGuests > totalOfChairs)
            throw new AvailabilityException("Not enough chairs available");

        List<Table> tables = new ArrayList<>();
        int tot = 0;

        for (int i = tableList.size() - 1; i >= 0; i--) {
            Table t = tableList.remove(i);
            tables.add(t);
            tot += t.getChairs();

            if (tot >= totalOfGuests)
                break;
        }

        if (tot < totalOfGuests) {
            // Returning tables
            tableList.addAll(tables);
            throw new AvailabilityException("Illegal state exception: missing chairs");
        }

        updateTotalOfChairs();
        return tables;
    }

    private void updateTotalOfChairs() {
        totalOfChairs = 0;
        for (Table t: tableList) {
            totalOfChairs += t.getChairs();
        }
    }
}
