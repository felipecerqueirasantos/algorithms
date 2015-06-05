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

        try {
            Date commonDate = new Date();

            Guest guestDiego = new Guest("1234", "Diego", "99999999");
            Party partyForDiego = new Party(commonDate, guestDiego, Party.PartyType.DINNER, 15);

            Reservation reservation1 = restaurant.checkAvailability(attendant, partyForDiego);
            if (reservation1 != null) {
                System.out.println("Your reservation is scheduled");
            } else {
                System.out.println("Date is not available");
            }

            Guest guestXyz = new Guest("454", "XYZ", "77777777");
            Party partyForXyz = new Party(commonDate, guestXyz, Party.PartyType.LUNCH, 15);

            Reservation reservation2 = restaurant.checkAvailability(attendant, partyForXyz);
            if (reservation2 != null) {
                System.out.println("Your reservation is scheduled");
            } else {
                System.out.println("Date is not available");
            }

        } catch (RestaurantException e) {
            System.out.println(e.getMessage());
        }
    }
}
