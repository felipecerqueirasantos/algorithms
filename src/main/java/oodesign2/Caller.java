package oodesign2;

/**
 * Created by sky on 6/3/15.
 */
public class Caller {
    private String telephoneNumber;

    public Caller(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "[Caller: " + telephoneNumber + "]";
    }
}
