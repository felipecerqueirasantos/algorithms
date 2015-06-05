package restaurant;

import java.util.List;

/**
 * Created by sky on 05/06/15.
 */
public class RestaurantResources {
    private final List<Table> tableList;

    public RestaurantResources(List<Table> tableList) {
        this.tableList = tableList;
    }

    public List<Table> getTableList() {
        return tableList;
    }
}
