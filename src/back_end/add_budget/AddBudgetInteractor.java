package back_end.add_budget;
import entity.Budget;

import java.time.Month;

public class AddBudgetInteractor implements AddBudgetInputBoundary{
    final private AddBudgetDataAccessInterface addDAO;
    final private AddBudgetOutputBoundary addPresenter;
    public AddBudgetInteractor(AddBudgetDataAccessInterface addDAO, AddBudgetOutputBoundary addPresenter) {
        this.addDAO = addDAO;
        this.addPresenter = addPresenter;
    }
    @Override
    public void execute(AddBudgetInputData inputData) {
        // get the month this budget was created for
        Month creationMonth = inputData.getSelectedMonth();

        // create and save the budget using the DAO
        Budget newBudget = new Budget(
                inputData.getSavingAmt(), inputData.getSpendingAmt(), creationMonth
        );
        addDAO.save(creationMonth, newBudget);

        // prepare the output data
        AddBudgetOutputData outputData = new AddBudgetOutputData(
                creationMonth, inputData.getSavingAmt(), inputData.getSpendingAmt()
        );

        // tell the presenter to show that a new budget has been made, and we can go to the management screen now
        addPresenter.prepareSuccessView(outputData);
    }
    @Override
    public void cancel() {
        addPresenter.cancel();
    }
}
