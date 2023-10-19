package entity;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double savingAmt;
    private double investmentAmt;
    private double spendingAmt;
    private List<Expense> expenses = new ArrayList<Expense>();

    public Budget(double savingAmt, double investmentAmt, double spendingAmt){
        this.savingAmt = savingAmt;
        this.investmentAmt = investmentAmt;
        this.spendingAmt = spendingAmt;
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

    public int removeExpense(String name){
        for(int i = 0; i < this.expenses.size(); i++){
            if(expenses.get(i).getCategory().equals(name)){
                this.expenses.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public double getRemaining(){
        double expenseSum = 0;
        for(Expense expense : this.expenses){
            expenseSum += expense.getAmount();
        }
        return this.spendingAmt - expenseSum;
    }

}