package restaurant;

import java.util.Date;
import java.util.List;

/**
 * Created by sky on 05/06/15.
 */
public class Reservation {
    private final Date expiration;
    private final Party party;
    private final List<Table> tableList;

    public Reservation(Date expiration, Party party, List<Table> tableList) {
        this.expiration = expiration;
        this.party = party;
        this.tableList = tableList;
    }

    public Date getExpiration() {
        return expiration;
    }

    public Party getParty() {
        return party;
    }

    public List<Table> getTableList() {
        return tableList;
    }
}
