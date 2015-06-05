package restaurant;

/**
 * Created by sky on 05/06/15.
 */
public final class Guest implements Comparable<Guest> {
    private String id;
    private String name;
    private String phoneNumber;

    public Guest(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Guest o) {
        return id.compareTo(o.id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
