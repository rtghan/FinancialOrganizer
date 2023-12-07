package back_end.add_budget;
import java.time.Month;

/**
 * The relevant information for a Budget entity is the month it was defined for,
 * the saving amount, and the spending amount.
 */
public class AddBudgetInputData {
    final private Month selectedMonth;
    final private double savingAmt;
    final private double spendingAmt;

    /**
     * Creates a new input data object for the AddBudget use case, consisting of the selected month, saving amount, and
     * target spending amount.
     * @param selectedMonth     The month that the user has selected to define a Budget for
     * @param savingAmt         The amount that the user has set as a goal to save
     * @param spendingAmt       The amount that that user has allotted themselves to spend
     */
    public AddBudgetInputData(Month selectedMonth, double savingAmt, double spendingAmt) {
        this.selectedMonth = selectedMonth;
        this.savingAmt = savingAmt;
        this.spendingAmt = spendingAmt;
    }

    /**
     * Retrieve the selected month that the Budget is defined for.
     * @return
     */
    public Month getSelectedMonth() {
        return selectedMonth;
    }

    /**
     * Retrieve the saving amount that the Budget allocates.
     * @return
     */
    public double getSavingAmt() {
        return savingAmt;
    }

    /**
     * Retrieve the spending amount that the Budget allocates.
     * @return
     */
    public double getSpendingAmt() {
        return spendingAmt;
    }
}
