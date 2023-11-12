package add_budget.back_end;
import entity.Budget;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
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
        Month creationMonth = LocalDateTime.now().getMonth();
        String monthName = creationMonth.getDisplayName(TextStyle.FULL, Locale.CANADA);

        // create and save the budget using the DAO
        Budget newBudget = new Budget(
                inputData.getSavingAmt(), inputData.getInvestmentAmt(), inputData.getSpendingAmt(), creationMonth
        );
        addDAO.save(monthName, newBudget);



        // prepare the output data
        AddBudgetOutputData outputData = new AddBudgetOutputData(
                monthName, inputData.getSavingAmt(), inputData.getInvestmentAmt(), inputData.getSpendingAmt()
        );

        // tell the presenter to show that a new budget has been made, and we can go to the management screen now
        addPresenter.prepareSuccessView(outputData);
    }
}
