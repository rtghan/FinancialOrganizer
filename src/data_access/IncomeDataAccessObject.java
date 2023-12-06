package data_access;

import entity.Income;
import java.util.HashMap;
import java.util.Map;
import java.time.Month;

/**
 * implements IncomeDataAccessInterface and accesses Income data
 */
public class IncomeDataAccessObject implements IncomeDataAccessInterface {
    private final Map<Month, Income> incomeMap;

    /**
     * constructs Income DAO with a hashmap
     */
    public IncomeDataAccessObject() {
        this.incomeMap = new HashMap<>();
    }

    /**
     * gets the Income by the specified month
     * @param month     month
     * @return          Income for month
     */
    @Override
    public Income getIncomeByMonth(Month month) {
        return incomeMap.get(month);
    }


}