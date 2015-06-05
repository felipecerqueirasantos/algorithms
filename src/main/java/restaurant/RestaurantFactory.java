package restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 05/06/15.
 */
public class RestaurantFactory {
    public static Restaurant makeRestaurant(String name) {
        Restaurant restaurant;

        switch(name) {
            case "Bistro Felipe":
                List<Table> tableList = new ArrayList<>();
                // 10 tables with two chairs each
                for (int i = 0; i < 10; i++)
                    tableList.add(new Table(i + 1, 2));

                RestaurantResources restaurantResources = new RestaurantResources(tableList);
                restaurant = new Restaurant(name, restaurantResources);
                break;
            default:
                restaurant = null;
                break;
        }

        return restaurant;
    }
}
