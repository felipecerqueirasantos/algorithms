package oodesign2;

/**
 * Created by sky on 6/3/15.
 */
public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    abstract void receiveCall(Caller caller);
}
