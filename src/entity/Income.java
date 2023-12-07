package entity;
import java.time.Month;

/**
 * Entity that represents income
 */
public class Income {
    private String incomeSource;
    private double amount;
    private Month month;

    /**
     * construct entity income with specified:
     * @param incomeSource  income source
     * @param amount        income amount
     * @param month          date income
     */
    public Income(String incomeSource, double amount, Month month) {
        this.incomeSource = incomeSource;
        this.amount = amount;
        this.month = month;
    }

    /**
     * gets the source of the income
     * @return income source
     */
    public String getIncomeSource() {
        return incomeSource;
    }

    /**
     * gets the amount of the income
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * gets the date
     * @return date
     */
    public Month getMonthmonth() {
        return month;
    }
}
