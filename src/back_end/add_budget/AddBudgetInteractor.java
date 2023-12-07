package back_end.add_budget;
import entity.Budget;

import java.time.Month;

/**
 * Carries out the actual creation and saving of a new Budget with respect to an AddBudgetInputData object
 */
public class AddBudgetInteractor implements AddBudgetInputBoundary{
    final private AddBudgetDataAccessInterface addDAO;
    final private AddBudgetOutputBoundary addPresenter;

    /**
     * Constructor for a new AddBudgetInteractor, which requires the data access object, as well as the outputBoundary
     * @param addDAO        A data access object so that the Budget can be saved
     * @param addPresenter  A class implementing the AddBudgetOutputBoundary so that the interactor has a guarantee that
     *                      it can do what it needs it to do, front-end wise
     */
    public AddBudgetInteractor(AddBudgetDataAccessInterface addDAO, AddBudgetOutputBoundary addPresenter) {
        this.addDAO = addDAO;
        this.addPresenter = addPresenter;
    }

    /**
     * The implementation of the AddBudgetInputBoundary that allows the front end to call on the behaviour that
     * generates a new Budget, with the appropriate specifications.
     * @param inputData     An input data object containing all the defining traits of a Budget
     */
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

    /**
     * Method to call when the user wants to return to the home screen.
     */
    @Override
    public void cancel() {
        addPresenter.cancel();
    }
}
