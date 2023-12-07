package back_end.add_income;

import java.time.Month;

/**
 * representation of what data needs to be outputted back to the user
 */
public class AddIncomeOutputData {
    final private String incomeSource;
    final private double amount;
    final private Month month;

    /**
     * constructor for the class
     * @param incomeSource String
     * @param amount double
     * @param date LocalDateTime
     */
    public AddIncomeOutputData(String incomeSource, double amount, Month month) {
        this.incomeSource = incomeSource;
        this.amount = amount;
        this.month = month;
    }

    /**
     * @return a string referring to the name of the income source
     */
    public String getIncomeSource() {
        return incomeSource;
    }

    /**
     * @return a double referring to the amount gained from this income source
     */
    public double getAmount(){
        return amount;
    }


    /**
     * @return the date on which this income was saved
     */
    public Month getMonth() {
        return month;
    }
}
