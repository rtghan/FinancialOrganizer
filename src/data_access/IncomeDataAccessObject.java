package data_access;

import entity.Income;

import java.util.HashMap;
import java.util.Map;
import java.time.Month;

public class IncomeDataAccessObject implements IncomeDataAccessInterface {
    private final Map<Month, Income> incomeMap;
    public IncomeDataAccessObject() {
        this.incomeMap = new HashMap<>();
    }

    @Override
    public Income getIncomeByMonth(Month month) {
        return incomeMap.get(month);
    }


}