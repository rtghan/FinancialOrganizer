package data_access;

import entity.Income;

import java.util.HashMap;
import java.util.Map;
import java.time.Month;

public class MapIncomeDataAccess implements IncomeDataAccessInterface {
    private final Map<Month, Income> incomeMapMap;
    public MapIncomeDataAccessDataAccess() {
        this.incomeMapMapMap = new HashMap<>();
    }

    @Override
    public Income getIncomeByMonth(Month month) {
        return incomeMap.get(month);
    }
}