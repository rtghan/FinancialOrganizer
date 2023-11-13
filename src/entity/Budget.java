package entity;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Month;
public class Budget {
    private double savingAmt;
    private double investmentAmt;
    private double spendingAmt;

    private Month creationMonth;
    private ArrayList<Expense> expensesList;
    private ArrayList<Income> incomeList;

    public Budget(double savingAmt, double investmentAmt, double spendingAmt, Month creationMonth) {
        this.savingAmt = savingAmt;
        this.investmentAmt = investmentAmt;
        this.spendingAmt = spendingAmt;
        this.creationMonth = creationMonth;
        this.expensesList = new ArrayList<Expense>();
        this.incomeList = new ArrayList<Income>();
    }

    public void addExpense(Expense expense) {
        expensesList.add(expense);
    }
    public void addIncome(Income income){incomeList.add(income);}

    public double getRemaining() {
        double expensesTotal = 0.0;

        for (Expense expense : expensesList) {
            expensesTotal += expense.getAmount();
        }

        double totalBudget = savingAmt + investmentAmt + spendingAmt;
        return totalBudget - expensesTotal;
    }
}