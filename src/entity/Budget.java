package entity;
import java.sql.Array;
import java.util.ArrayList;
import java.time.Month;

/**
 * Entity that represents budget
 */
public class Budget {
    private double savingAmt;
    private double spendingAmt;
    private Month creationMonth;
    private final ArrayList<Expense> expensesList;
    private final ArrayList<Income> incomeList;


    /**
     * Construct budget entity with the specified:
     * @param savingAmt         saving amount
     * @param spendingAmt       spending amount
     * @param creationMonth     month
     */
    public Budget(double savingAmt, double spendingAmt, Month creationMonth) {
        this.savingAmt = savingAmt;
        this.spendingAmt = spendingAmt;
        this.creationMonth = creationMonth;

        // per budget, creates list of expenses and income to be added later
        this.expensesList = new ArrayList<Expense>();
        this.incomeList = new ArrayList<Income>();
    }

    /**
     * adds expense object to the list of expenses inside budget
     */
    public void addExpense(Expense expense) {
        expensesList.add(expense);
    }

    /**
     * adds income object to the list of incomes inside budget
     */
    public void addIncome(Income income){
        incomeList.add(income);
    }

    /**
     * calculates the total expenses for the budget
     * @return total expenses
     */
    public double totalExpenses(){
        double expensesTotal = 0.0;
        for (Expense expense : expensesList) {
            expensesTotal += expense.getAmount();
        }
        return expensesTotal;
    }

    /**
     * calculates the total income for the budget
     * @return total income
     */
    public double totalIncome(){
        double incomeTotal = 0.0;
        for (Income income : incomeList){
            incomeTotal += income.getAmount();
        }
        return incomeTotal;
    }

    /**
     * calculates the remaining amount of $ left
     * @return remaining amount
     */
    public double getRemaining() {
//        double incomeTotal = totalIncome();
//        double expensesTotal = totalExpenses();
//        return incomeTotal - expensesTotal;
        // changed remaining amount to be the remaining amount you can spend
        return this.spendingAmt - totalExpenses();
    }

    /**
     * calculates the disposable income left after all expensed
     * @return disposable income
     */
    public double disposableIncome() {
        double incomeTotal = totalIncome();
        double expensesTotal = totalExpenses();
        return incomeTotal - expensesTotal - savingAmt;
    }

    public ArrayList<Expense> getExpensesList(){
        return this.expensesList;
    }
}