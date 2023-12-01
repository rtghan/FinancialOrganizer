package data_access;

import entity.Expense;

import java.time.Month;
import java.util.Map;

public class ExpenseDataAccessObject implements ExpenseDataAccessInterface {

    private final Map<Month, Expense> expenseMap;

    public ExpenseDataAccessObject(Map<Month, Expense> expenseMap) {
        this.expenseMap = expenseMap;
    }

    @Override
    public Expense getExpensesByMonth(Month month) {
        return expenseMap.get(month);
    }
}
