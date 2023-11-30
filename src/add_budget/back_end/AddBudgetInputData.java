package add_budget.back_end;
import java.time.Month;
public class AddBudgetInputData {
    final private Month selectedMonth;
    final private double savingAmt;
    final private double investmentAmt;
    final private double spendingAmt;

    public AddBudgetInputData(Month selectedMonth, double savingAmt, double investmentAmt, double spendingAmt) {
        this.selectedMonth = selectedMonth;
        this.savingAmt = savingAmt;
        this.investmentAmt = investmentAmt;
        this.spendingAmt = spendingAmt;
    }
    public Month getSelectedMonth() {
        return selectedMonth;
    }
    public double getSavingAmt() {
        return savingAmt;
    }

    public double getInvestmentAmt() {
        return investmentAmt;
    }

    public double getSpendingAmt() {
        return spendingAmt;
    }
}
