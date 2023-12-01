package home_screen;

import entity.Budget;
import entity.Income;

public class HomeScreenOutputData {
    private final double remainingBudget;
    private final Income currentIncome;


    public HomeScreenOutputData(double remainingBudget, Income currentlIncome) {
        this.remainingBudget = remainingBudget;
        this.currentIncome = currentlIncome;
    }
}