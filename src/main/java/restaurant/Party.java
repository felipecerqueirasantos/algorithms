package restaurant;

import java.util.Date;

/**
 * Created by sky on 05/06/15.
 */
public final class Party implements Comparable<Party> {
    public enum PartyType {
        LUNCH,
        DINNER;
    }

    private final Date date;
    private final Guest guest;
    private final PartyType partyType;
    private final int totalOfGuests;

    public Party(Date date, Guest guest, PartyType partyType, int totalOfGuests) {
        this.date = date;
        this.guest = guest;
        this.partyType = partyType;
        this.totalOfGuests = totalOfGuests;
    }

    @Override
    public int compareTo(Party o) {
        int cmp;

        cmp = date.compareTo(o.date);
        if (cmp != 0)
            return cmp;

        cmp = guest.compareTo(o.guest);
        if (cmp != 0)
            return cmp;

        return totalOfGuests - o.totalOfGuests;
    }

    public Date getDate() {
        return date;
    }

    public Guest getGuest() {
        return guest;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    public int getTotalOfGuests() {
        return totalOfGuests;
    }
}
