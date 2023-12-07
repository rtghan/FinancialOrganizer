package back_end.add_income;
import entity.Budget;

import java.time.Month;

/**
 * Interface that allows classes to interact with data storage
 */
public interface AddIncomeDataAccessInterface {
    /**
     * takes in a datetime month and returns the budget that corresponds to that month
     * @param month Month
     * @return Budget
     */
    public Budget getBudgetByMonth(Month month);
}
