package entity;
import java.time.LocalDateTime;

/**
 * Entity that represents income
 */
public class Income {
    private String incomeSource;
    private double amount;
    private LocalDateTime date;

    /**
     * construct entity income with specified:
     * @param incomeSource  income source
     * @param amount        income amount
     * @param date          date income
     */
    public Income(String incomeSource, double amount, LocalDateTime date) {
        this.incomeSource = incomeSource;
        this.amount = amount;
        this.date = date;
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
    public LocalDateTime getDate() {
        return date;
    }
}
