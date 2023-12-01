package interface_adapter.add_budget;
import java.time.LocalDateTime;
import java.time.Month;
public class AddBudgetState {
    private String monthSelection = "";
    private Month month;
    private double saveAmt = 0;
    private double invAmt = 0;
    private double spendAmt = 0;
    private boolean creationSuccess = false;

    public AddBudgetState(AddBudgetState copy) {
        monthSelection = copy.monthSelection;
        saveAmt = copy.saveAmt;
        invAmt = copy.invAmt;
        spendAmt = copy.spendAmt;
    }

    public AddBudgetState() {
        this.month = LocalDateTime.now().getMonth();
    }

    public String getMonthSelection() {
        return this.monthSelection;
    }

    public Month getMonth() {
        return month;
    }

    public double getSaveAmt() {
        return saveAmt;
    }

    public double getInvAmt() {
        return invAmt;
    }

    public double getSpendAmt() {
        return spendAmt;
    }

    public void setMonthSelection(String monthSelection) {
        this.monthSelection = monthSelection;
        if (this.monthSelection.equals("Current Month")) {
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(this.monthSelection.toUpperCase());
        }
    }

    public boolean isCreationSuccess() {
        return creationSuccess;
    }

    public void setCreationSuccess(boolean creationSuccess) {
        this.creationSuccess = creationSuccess;
    }
    public void setSaveAmt(double saveAmt) {
        this.saveAmt = saveAmt;
    }

    public void setInvAmt(double invAmt) {
        this.invAmt = invAmt;
    }

    public void setSpendAmt(double spendAmt) {
        this.spendAmt = spendAmt;
    }
}
