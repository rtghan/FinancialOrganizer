package data_access;

import entity.Budget;

import java.util.HashMap;
import java.util.Map;
import java.time.Month;

public class BudgetDataAccessObject implements BudgetDataAccessInterface {

    private final Map<Month, Budget> budgetMap;
    public BudgetDataAccessObject() {
        this.budgetMap = new HashMap<>();
    }

    @Override
    public Budget getBudgetByMonth(Month month) {
        //System.out.println(budgetMap.get(month));
        return budgetMap.get(month);
    }

}