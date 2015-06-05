package restaurant;

/**
 * Created by sky on 05/06/15.
 */
public final class Table {
    private final int tableNumber;
    private final int chairs;

    public Table(int tableNumber, int chairs) {
        this.tableNumber = tableNumber;
        this.chairs = chairs;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getChairs() {
        return chairs;
    }
}
