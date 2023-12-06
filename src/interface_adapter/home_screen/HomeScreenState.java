package interface_adapter.home_screen;

import java.time.LocalDateTime;
import java.time.Month;

public class HomeScreenState {

    private Boolean creationSuccess = false;
    private String selectedMonthStr = "";
    private Month month;
    private double remainingBudget;
    private double totalIncome;
    private double totalExpenses;

    public HomeScreenState() {
        this.month = LocalDateTime.now().getMonth();
    }

    public HomeScreenState(HomeScreenState copy) {
        selectedMonthStr = copy.selectedMonthStr;
    }

    public Month getMonth() {
        return this.month;
    }

    public String getMonthSelectionStr() {
        return this.selectedMonthStr;
    }

    public void setMonthSelection(String monthSelectionStr) {
        this.selectedMonthStr = monthSelectionStr;
        if (this.selectedMonthStr.equals("Current Month")) {
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(this.selectedMonthStr.toUpperCase());
        }
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public boolean isCreationSuccess() {
        return creationSuccess;
    }

    public void setCreationSuccess(boolean creationSuccess) {
        this.creationSuccess = creationSuccess;
    }

}
