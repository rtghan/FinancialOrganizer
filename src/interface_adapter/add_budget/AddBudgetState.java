package interface_adapter.add_budget;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * A class that the view draws on to know what to display. Contains information regarding what the user has done in
 * this view: the state of the view.
 */
public class AddBudgetState {
    private String monthSelection = "";
    private Month month;
    private double saveAmt = 0;
    private double spendAmt = 0;
    private boolean creationSuccess = false;

    /**
     * Constructs an AddBudgetState from another instance of an AddBudgetState
     * @param copy  Another instance of an AddBudgetState that we want to copy
     */
    public AddBudgetState(AddBudgetState copy) {
        monthSelection = copy.monthSelection;
        saveAmt = copy.saveAmt;
        spendAmt = copy.spendAmt;
    }

    /**
     * The default constructor for the AddBudget state, which is also the state that the view is in before any user
     * interaction occurs.
     */
    public AddBudgetState() {
        this.month = LocalDateTime.now().getMonth();
    }

    /**
     * Getter for the month currently reflected by the view
     * @return
     */
    public Month getMonth() {
        return month;
    }

    /**
     * Getter for the savings amount currently reflected by the view
     * @return
     */
    public double getSaveAmt() {
        return saveAmt;
    }

    /**
     * Getter for the spending amount currently reflected by the view
     * @return
     */
    public double getSpendAmt() {
        return spendAmt;
    }

    /**
     * Setter for the month selection, which also updates the Month object when appropriate
     * @param monthSelection    A string representing what month should be switched to
     */
    public void setMonthSelection(String monthSelection) {
        this.monthSelection = monthSelection;
        if (this.monthSelection.equals("Current Month")) {
            this.month = LocalDateTime.now().getMonth();
        }
        else {
            this.month = Month.valueOf(this.monthSelection.toUpperCase());
        }
    }

    /**
     * Getter to see whether or not the creation of a new Budget succeeded
     * @return
     */
    public boolean isCreationSuccess() {
        return creationSuccess;
    }

    /**
     * Setter to tell the front end whether the creation of a new Budget succeeded.
     * @param creationSuccess   A boolean corresponding to whether or not the creation succeeded
     */
    public void setCreationSuccess(boolean creationSuccess) {
        this.creationSuccess = creationSuccess;
    }

    /**
     * Setter to update the save amount reflected in the view
     * @param saveAmt   The new save amount to be shown in the view
     */
    public void setSaveAmt(double saveAmt) {
        this.saveAmt = saveAmt;
    }

    /**
     * Setter to update the spending amount reflected in the view
     * @param spendAmt  The new spending amount to be shown in the view
     */
    public void setSpendAmt(double spendAmt) {
        this.spendAmt = spendAmt;
    }
}
