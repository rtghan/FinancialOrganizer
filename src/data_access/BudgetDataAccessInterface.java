package data_access;

import entity.Budget;
import java.time.Month;

/**
 * interface for accessing budget data
 */
public interface BudgetDataAccessInterface {
    /**
     * gets the budget by the specified month
     * @param month     month
     * @return          Budget for month
     */
    Budget getBudgetByMonth(Month month);
}

