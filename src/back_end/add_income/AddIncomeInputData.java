package back_end.add_income;

/**
 * represents one instace of new income added
 */
public class AddIncomeInputData {
    final private String incomeSource;
    final private double amount;

    /**
     * constructs an instace of input data for income
     * @param incomeSource String
     * @param amount double
     */
    public AddIncomeInputData(String incomeSource, double amount) {
        this.incomeSource = incomeSource;
        this.amount = amount;
    }

    /**
     * @return a string that refers to the income source
     */
    public String getIncomeSource() {
        return incomeSource;
    }

    /**
     * @return a double that refers to the amount of money from this instance of income
     */
    public double getAmount(){
        return amount;
    }
}
