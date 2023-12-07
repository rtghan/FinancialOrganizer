package back_end.add_budget;
import java.time.Month;
public class AddBudgetOutputData {
    private final Month budgetMonth;
    private final double savAmt;
    private final double spdAmt;

    public AddBudgetOutputData(Month budgetMonth, double savAmt, double spdAmt) {
        this.budgetMonth = budgetMonth;
        this.savAmt = savAmt;
        this.spdAmt = spdAmt;
    }

    public Month getBudgetMonth() {
        return budgetMonth;
    }

    public double getSavAmt() {
        return savAmt;
    }

    public double getSpdAmt() {
        return spdAmt;
    }
}
