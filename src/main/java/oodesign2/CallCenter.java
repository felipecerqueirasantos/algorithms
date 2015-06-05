package oodesign2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sky on 6/3/15.
 */
public class CallCenter {
    private List<Director> directorList = new ArrayList<>();
    private List<Manager> managerList = new ArrayList<>();
    private List<Respondent> respondentList = new ArrayList<>();

    private Queue<Employee> level1 = new ArrayDeque<>();
    private Queue<Employee> level2 = new ArrayDeque<>();
    private Queue<Employee> level3 = new ArrayDeque<>();

    public CallCenter(List<Director> directorList, List<Manager> managerList, List<Respondent> respondentList) {
        this.directorList = directorList;
        this.managerList = managerList;
        this.respondentList = respondentList;

        for (Director director: directorList)
            level3.add(director);

        for (Manager manager: managerList)
            level2.add(manager);

        for (Respondent respondent: respondentList)
            level1.add(respondent);
    }

    public void dispatchCall(Caller caller) throws CallCenterException {
        Employee employee;

        employee = level1.remove();
        if (employee != null) {
            employee.receiveCall(caller);
            level1.add(employee);
            return;
        }

        employee = level2.remove();
        if (employee != null) {
            employee.receiveCall(caller);
            level2.add(employee);
            return;
        }

        employee = level3.remove();
        if (employee != null) {
            employee.receiveCall(caller);
            level3.add(employee);
            return;
        }

        throw new CallCenterException("No respondent available to receive your call");
    }
}
