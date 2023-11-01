package entity
import java.util.ArrayList;
public class Budget {
    private double savingAmt;
    private double investmentAmt;
    private double spendingAmt;
    private ArrayList<Expense> expensesList;

    public Budget(double savingAmt, double investmentAmt, double spendingAmt) {
        this.savingAmt = savingAmt;
        this.investmentAmt = investmentAmt;
        this.spendingAmt = spendingAmt;
        this.expensesList = new ArrayList<>(Expense);
    }

    public void addExpense(Expense expense) {
        expensesList.add(expense);
    }

    public double getRemaining() {
        double expensesTotal = 0.0;

        for (Expense expense : expensesList) {
            expensesTotal += expense.getAmount();
        }

        totalBudget = savingAmt + investmentAmt + spendingAmt;
        return totalBudget - expensesTotal;
    }
}