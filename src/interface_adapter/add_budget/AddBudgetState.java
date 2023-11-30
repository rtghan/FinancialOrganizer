package interface_adapter.add_budget;
import java.time.LocalDateTime;
import java.time.Month;
public class AddBudgetState {
    private String monthSelection = "";
    private double saveAmt = 0;
    private double invAmt = 0;
    private double spendAmt = 0;

    public AddBudgetState(AddBudgetState copy) {
        monthSelection = copy.monthSelection;
        saveAmt = copy.saveAmt;
        invAmt = copy.invAmt;
        spendAmt = copy.spendAmt;
    }

    public AddBudgetState() {}

    public String getMonthSelection() {
        return this.monthSelection;
    }

    public Month getMonth() {
        if (this.monthSelection.equals("Current Month")) {
            return LocalDateTime.now().getMonth();
        }
        else {
            return Month.valueOf(this.monthSelection.toUpperCase());
        }
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
}
