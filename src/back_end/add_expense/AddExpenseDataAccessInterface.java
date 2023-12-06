package back_end.add_expense;

import entity.Budget;
import java.time.Month;

/**
 * interface for accessing expense data
 */
public interface AddExpenseDataAccessInterface {

    /**
     * Return the corresponding Budget associated with a certain month
     * @param month
     * @return
     */
    Budget getBudgetByMonth(Month month);
}
