package data_access;

import entity.Budget;
import entity.Expense;
import entity.Income;

import java.util.HashMap;
import java.util.Map;
import java.time.Month;

public class MapBudgetDataAccess implements BudgetDataAccessInterface {

    private final Map<Month, Budget> budgetMap;
    public MapBudgetDataAccess() {
        this.budgetMap = new HashMap<>();
    }

    @Override
    public Budget getBudgetByMonth(Month month) {
        return budgetMap.get(month);
    }

}