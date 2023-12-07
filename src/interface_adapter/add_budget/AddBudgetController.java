package interface_adapter.add_budget;
import back_end.add_budget.AddBudgetInputBoundary;
import back_end.add_budget.AddBudgetInputData;

import java.time.Month;
public class AddBudgetController {
    final AddBudgetInputBoundary addBudgetInteractor;

    public AddBudgetController(AddBudgetInputBoundary interactor) {
        this.addBudgetInteractor = interactor;
    }
    public void execute(Month selectionMonth, double saveAmt, double spendAmt){
        AddBudgetInputData inputData = new AddBudgetInputData(selectionMonth, saveAmt, spendAmt);
        addBudgetInteractor.execute(inputData);
    }

    public void cancel(){
        addBudgetInteractor.cancel();
    }
}
