package interface_adapter.home_screen;

import java.time.LocalDateTime;
import java.time.Month;
import java.awt.image.BufferedImage;

/**
 * represents the home screen state
 */
public class HomeScreenState {

    private Boolean budgetNull = false;
    private String selectedMonthStr = "";
    private Month month;
    private double remainingBudget;
    private double totalIncome;
    private double totalExpenses;
    private BufferedImage statGraph;
    private BufferedImage expenseGraph;
    private String popup;

    /**
     * default state constructor that makes the month the current month
     */
    public HomeScreenState() {
        this.month = LocalDateTime.now().getMonth();
    }

    /**
     * state constructor - copies the specified state
     * @param copy  home screen state
     */
    public HomeScreenState(HomeScreenState copy) {
        selectedMonthStr = copy.selectedMonthStr;
    }

    /**
     * gets the current month
     * @return
     */
    public Month getMonth() {
        return this.month;
    }

    /**
     * gets the selected month in string
     * @return
     */
    public String getMonthSelectionStr() {
        return this.selectedMonthStr;
    }

    /**
     * sets the selected month as Month based on specified (String) month
     * if not selected/current month, sets the month to the current month
     * @param monthSelectionStr
     */
    public void setMonthSelection(String monthSelectionStr) {
        this.selectedMonthStr = monthSelectionStr;
        if (this.selectedMonthStr.equals("Current Month")) {
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(this.selectedMonthStr.toUpperCase());
        }
    }

    /**
     * gets the remaining budget
     * @return
     */
    public double getRemainingBudget() {
        return remainingBudget;
    }

    /**
     * sets the remaining budget
     * @param remainingBudget
     */
    public void setRemainingBudget(double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    /**
     * gets the total income
     * @return
     */
    public double getTotalIncome() {
        return totalIncome;
    }

    /**
     * sets the total income
     * @param totalIncome
     */
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * gets the total expenses
     * @return
     */
    public double getTotalExpenses() {
        return totalExpenses;
    }

    /**
     * sets the total expenses
     * @param totalExpenses
     */
    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    /**
     * check if the budget has not been created yet
     * @return False if budget exists
     */
    public boolean isBudgetNull() {
        return budgetNull;
    }

    /**
     * sets the budget null status
     * @param budgetNull
     */
    public void setBudgetNull(boolean budgetNull) {
        this.budgetNull = budgetNull;
    }

    /**
     * sets the main stats graph image
     * @param newGraph
     */
    public void setStatGraph(BufferedImage newGraph) {
        this.statGraph = newGraph;
    }

    /**
     * sets the expenses graph image
     * @param newGraph
     */
    public void setExpenseGraph(BufferedImage newGraph) {
        this.expenseGraph = newGraph;
    }

    /**
     * gets the main stats graph image
     * @return
     */
    public BufferedImage getStatGraph() {
        return this.statGraph;
    }

    /**
     * gets the expense graph image
     * @return
     */
    public BufferedImage getExpenseGraph() {
        return this.expenseGraph;
    }

}
