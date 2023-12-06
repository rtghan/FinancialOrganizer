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
    void save(Month month, Budget budget);
}

