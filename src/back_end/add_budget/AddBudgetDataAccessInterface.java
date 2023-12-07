package back_end.add_budget;

import entity.Budget;
import java.time.Month;

/**
 * interface for accessing budget data
 */
public interface AddBudgetDataAccessInterface {
    /**
     * gets the budget by the specified month
     * @param month     month
     * @return          Budget for month
     */
    Budget getBudgetByMonth(Month month);

    /**
     * Saves a budget with its corresponding month
     * @param month     the month to be saved
     * @param budget    the budget object to be saved corresponding to the month
     */
    void save(Month month, Budget budget);
}

