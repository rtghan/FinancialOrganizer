package data_access;
import back_end.add_budget.AddBudgetDataAccessInterface;
import back_end.add_income.AddIncomeDataAccessInterface;
import back_end.add_expense.AddExpenseDataAccessInterface;
import entity.Budget;
import entity.Expense;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class MemoryDAO implements AddBudgetDataAccessInterface, AddIncomeDataAccessInterface, AddExpenseDataAccessInterface{
    private final Map<Month, Budget> budgetMap;
    private final Map<Month, Expense> expenseMap;
    /**
     * constructs memory-based DAO with a hashmap
     */
    public MemoryDAO() {
        this.budgetMap = new HashMap<>();
        this.expenseMap = new HashMap<>();
    }

    /**
     * gets the budget by the specified month
     * @param month     month
     * @return          budget for month
     */
    @Override
    public Budget getBudgetByMonth(Month month) {
        //System.out.println(budgetMap.get(month));
        return budgetMap.get(month);
    }

    /**
     * Saves a given budget to the specified month
     * @param month
     * @param budget
     */
    @Override
    public void save(Month month, Budget budget) {
        budgetMap.put(month, budget);
    }

    /**
     * Retrieves the expenses for a given month
     * @param month     month
     * @return
     */
    @Override
    public Expense getExpensesByMonth(Month month) {
        return expenseMap.get(month);
    }
}
