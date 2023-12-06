package data_access;

import entity.Expense;
import java.time.Month;
import java.util.Map;

/**
 * implements ExpenseDataAccessInterface and accesses Expense data
 */
public class ExpenseDataAccessObject implements ExpenseDataAccessInterface {

    private final Map<Month, Expense> expenseMap;

    /**
     * constructs Expense DAO with a hashmap
     * @param expenseMap
     */
    public ExpenseDataAccessObject(Map<Month, Expense> expenseMap) {
        this.expenseMap = expenseMap;
    }

    /**
     * gets the Expense by the specified month
     * @param month     month
     * @return          Expense for month
     */
    @Override
    public Expense getExpensesByMonth(Month month) {
        return expenseMap.get(month);
    }
}
