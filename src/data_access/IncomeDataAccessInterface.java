package data_access;

import entity.Income;
import java.time.Month;

public interface IncomeDataAccessInterface {
    Income getIncomeByMonth(Month month);
}