package add_budget.back_end;

public class AddBudgetOutputData {
    private final String budgetMonth;
    private final double savAmt;
    private final double invAmt;
    private final double spdAmt;

    public AddBudgetOutputData(String budgetMonth, double savAmt, double invAmt, double spdAmt) {
        this.budgetMonth = budgetMonth;
        this.savAmt = savAmt;
        this.invAmt = invAmt;
        this.spdAmt = spdAmt;
    }

    public String getBudgetMonth() {
        return budgetMonth;
    }

    public double getSavAmt() {
        return savAmt;
    }

    public double getInvAmt() {
        return invAmt;
    }

    public double getSpdAmt() {
        return spdAmt;
    }
}
