package home_screen;

/**
 * represents output data (remaining budget, total income & expenses)
 * for the home screen
 */
public class HomeScreenOutputData {
    private final double remainingBudget;
    private final double totalIncome;
    private final double totalExpenses;

    /**
     * constructs output data object for home screen
     * @param remainingBudget   remaining budget amount
     * @param totalIncome       total income amount
     * @param totalExpenses     total expenses amount
     */
    public HomeScreenOutputData(double remainingBudget, double totalIncome, double totalExpenses) {
        this.remainingBudget = remainingBudget;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    /**
     * gets the remaining budget
     * @return remaining budget amount
     */
    public double getRemainingBudget() {
        return remainingBudget;
    }

    /**
     * gets the total income
     * @return total income amount
     */
    public double getTotalIncome() {
        return totalIncome;
    }

    /**
     * gets the total expenses
     * @return total expenses amount
     */
    public double getTotalExpenses() {
        return totalExpenses;
    }

}