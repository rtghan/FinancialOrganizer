package back_end.home_screen;

import entity.Budget;

import java.time.Month;

/**
 * interface for saving data in Home Screen
 */
public interface HomeScreenDataAccessInterface {
    /**
     * gets the budget by the specified month
     * @param month     month
     * @return          Budget for month
     */
    Budget getBudgetByMonth(Month month);
    void save(Month month, Budget budget);
}
