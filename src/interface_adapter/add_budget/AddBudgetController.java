package interface_adapter.add_budget;
import back_end.add_budget.AddBudgetInputBoundary;
import back_end.add_budget.AddBudgetInputData;

import java.time.Month;

/**
 * A class that commands the back end of the application to add a new Budget upon being notified to do so by the view.
 */
public class AddBudgetController {
    final AddBudgetInputBoundary addBudgetInteractor;

    /**
     * Constructor for a new AddBudgetController class
     * @param interactor    The class that the controller manipulates in order to send commands to the back end
     */
    public AddBudgetController(AddBudgetInputBoundary interactor) {
        this.addBudgetInteractor = interactor;
    }

    /**
     * On running, will notify the back end to create and save a Budget reflecting what the user specified
     * in the front end.
     * @param selectionMonth    The month for the budget selected by the user.
     * @param saveAmt           The goal for savings that the user specified.
     * @param spendAmt          The limit for savings that the user specified.
     */
    public void execute(Month selectionMonth, double saveAmt, double spendAmt){
        AddBudgetInputData inputData = new AddBudgetInputData(selectionMonth, saveAmt, spendAmt);
        addBudgetInteractor.execute(inputData);
    }

    /**
     * On running, will notify the back end to trigger front elements to move so that the user may return back to the
     * home screen.
     */
    public void cancel(){
        addBudgetInteractor.cancel();
    }
}
