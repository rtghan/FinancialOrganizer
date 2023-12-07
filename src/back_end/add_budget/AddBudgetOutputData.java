package back_end.add_budget;
import java.time.Month;

/**
 * The data that a user should expect to see upon creating their Budget. It has the same attributes as InputData, which
 * was done intentionally, as we would like to use this information to confirm with the user that the Budget created
 * is the right one.
 */
public class AddBudgetOutputData {
    private final Month budgetMonth;
    private final double savAmt;
    private final double spdAmt;

    /**
     * Constructor for an AddBudgetOutputData object
     * @param budgetMonth   The month the Budget entity was defined for
     * @param savAmt        The amount the user specified they will save
     * @param spdAmt        The amount the user specified they can spend
     */
    public AddBudgetOutputData(Month budgetMonth, double savAmt, double spdAmt) {
        this.budgetMonth = budgetMonth;
        this.savAmt = savAmt;
        this.spdAmt = spdAmt;
    }

    /**
     * Getter for the Month of the Budget
     * @return
     */
    public Month getBudgetMonth() {
        return budgetMonth;
    }

    /**
     * Getter for Saving Amount
     * @return
     */
    public double getSavAmt() {
        return savAmt;
    }

    /**
     * Getter for the Spending Amount
     * @return
     */
    public double getSpdAmt() {
        return spdAmt;
    }
}
