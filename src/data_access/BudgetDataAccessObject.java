package data_access;

import back_end.add_budget.AddBudgetDataAccessInterface;
import entity.Budget;

import java.util.HashMap;
import java.util.Map;
import java.time.Month;

/**
 * implements BudgetDataAccessInterface and accesses Budget data
 */
public class BudgetDataAccessObject implements AddBudgetDataAccessInterface {
    private final Map<Month, Budget> budgetMap;

    /**
     * constructs Budget DAO with a hashmap
     */
    public BudgetDataAccessObject() {
        this.budgetMap = new HashMap<>();
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

    @Override
    public void save(Month month, Budget budget) {
        budgetMap.put(month, budget);
    }

}