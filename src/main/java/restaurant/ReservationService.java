package restaurant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sky on 05/06/15.
 */
public class ReservationService {
    public static void main(String[] args) {
        Restaurant restaurant = RestaurantFactory.makeRestaurant("Bistro Felipe");
        Employee host = new Employee("Breno", Employee.EmployeeType.HOST);
        Employee attendant = new Employee("Larissa", Employee.EmployeeType.ATTENDANT);

        Guest guest = new Guest("1234", "Diego", "99999999");
        Party party = new Party(new Date(), guest, Party.PartyType.DINNER, 15);

        try {
            Reservation reservation1 = restaurant.checkAvailability(attendant, party);
            if (reservation1 != null) {
                System.out.println("Your reservation is scheduled");
            }

            Reservation reservation2 = restaurant.checkAvailability(attendant, party);
            if (reservation2 == null) {
                System.out.println("Date is not available");
            }

        } catch (RestaurantException e) {
            System.out.println(e.getMessage());
        }
    }
}
