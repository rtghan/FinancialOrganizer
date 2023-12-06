package data_access;

import entity.Income;
import java.time.Month;

/**
 * interface for accessing income data
 */
public interface IncomeDataAccessInterface {
    /**
     * gets the income by the specified month
     * @param month     month
     * @return          Income by month
     */
    Income getIncomeByMonth(Month month);
}