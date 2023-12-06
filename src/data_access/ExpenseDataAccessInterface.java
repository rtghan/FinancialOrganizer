package data_access;

import entity.Expense;
import java.time.Month;

/**
 * interface for accessing expense data
 */
public interface ExpenseDataAccessInterface {

    /**
     * gets the expense by the specified month
     * @param month     month
     * @return          Expense for month
     */
    Expense getExpensesByMonth(Month month);
}
