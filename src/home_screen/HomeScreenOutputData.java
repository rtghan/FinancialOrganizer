package home_screen;

import entity.Budget;
import entity.Income;
import entity.Expense;

public class HomeScreenOutputData {
    private final double remainingBudget;
    private final double totalIncome;
    private final double totalExpenses;


    public HomeScreenOutputData(double remainingBudget, double totalIncome, double totalExpenses) {
        this.remainingBudget = remainingBudget;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }
    public double getTotalIncome() {
        return totalIncome;
    }
    public double getTotalExpenses() {
        return totalExpenses;
    }

}