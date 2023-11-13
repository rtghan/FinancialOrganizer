package add_budget.back_end;

public class AddBudgetInputData {
    final private double savingAmt;
    final private double investmentAmt;
    final private double spendingAmt;

    public AddBudgetInputData(double savingAmt, double investmentAmt, double spendingAmt) {
        this.savingAmt = savingAmt;
        this.investmentAmt = investmentAmt;
        this.spendingAmt = spendingAmt;
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
