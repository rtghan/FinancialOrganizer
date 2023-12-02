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
    public void addIncome(Income income){
        incomeList.add(income);
    }

    public double totalExpenses(){
        double expensesTotal = 0.0;
        for (Expense expense : expensesList) {
            expensesTotal += expense.getAmount();
        }
        return expensesTotal;
    }

    public double totalIncome(){
        double incomeTotal = 0.0;
        for (Income income : incomeList){
            incomeTotal += income.getAmount();
        }
        return incomeTotal;
    }

    // income minus expenses
    public double getRemaining() {

        double expensesTotal = totalExpenses();
        double incomeTotal = totalIncome();

        return incomeTotal - expensesTotal;
    }
}