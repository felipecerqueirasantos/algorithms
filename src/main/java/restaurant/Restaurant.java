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

    // Just two types (lunch and dinner)
    private final Map<Date, Availability> availabilityMapForLunch = new HashMap<>();
    private final Map<Date, Availability> availabilityMapForDinner = new HashMap<>();

    private final List<Reservation> reservationList = new ArrayList<>();

    public Restaurant(String name, RestaurantResources restaurantResources) {
        this.name = name;
        this.restaurantResources = restaurantResources;
    }

    public Reservation checkAvailability(Employee employee, Party party) throws RestaurantException {
        if (employee.getEmployeeType() != Employee.EmployeeType.ATTENDANT)
            throw new RestaurantException("You do not have access to checkAvailability");

        Availability availability = checkAvailability(party);

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

    private Availability checkAvailability(Party party) {
        Availability availability = null;

        if (party.getPartyType() == Party.PartyType.LUNCH) {
            availability = availabilityMapForLunch.get(party.getDate());
            if (availability == null) {
                availability = new Availability(restaurantResources.getTableList());
                availabilityMapForLunch.put(party.getDate(), availability);
            }
        } else if (party.getPartyType() == Party.PartyType.DINNER) {
            availability = availabilityMapForDinner.get(party.getDate());
            if (availability == null) {
                availability = new Availability(restaurantResources.getTableList());
                availabilityMapForDinner.put(party.getDate(), availability);
            }
        }

        return availability;
    }

    public String getName() {
        return name;
    }

    public RestaurantResources getRestaurantResources() {
        return restaurantResources;
    }
}
