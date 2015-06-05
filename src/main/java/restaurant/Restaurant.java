package restaurant;

import java.util.*;

/**
 * Created by sky on 05/06/15.
 */
public class Restaurant {
    /*
    Restaurant
    Map<Date, Availability> availability
    boolean checkAvailability(Party)
    Reserve createReservation(Party)
    Reservation findReservation(Guest)
    confirm(Employee, Reservation)
    cancel(Employee, Reservation)
     */

    private final String name;
    private final RestaurantResources restaurantResources;
    private final Map<Date, Availability> availabilityMap = new HashMap<>();
    private final List<Reservation> reservationList = new ArrayList<>();

    public Restaurant(String name, RestaurantResources restaurantResources) {
        this.name = name;
        this.restaurantResources = restaurantResources;
    }

    public Reservation checkAvailability(Employee employee, Party party) throws RestaurantException {
        if (employee.getEmployeeType() != Employee.EmployeeType.ATTENDANT)
            throw new RestaurantException("You do not have access to checkAvailability");

        Availability availability = availabilityMap.get(party.getDate());
        if (availability == null) {
            availability = new Availability(restaurantResources.getTableList());
            availabilityMap.put(party.getDate(), availability);
        }

        try {
            List<Table> tables = availability.getTables(party.getTotalOfGuests());
            Date expiration = party.getDate();

            Reservation reservation = new Reservation(expiration, party, tables);
            reservationList.add(reservation);

            return reservation;
        } catch (AvailabilityException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public RestaurantResources getRestaurantResources() {
        return restaurantResources;
    }
}
