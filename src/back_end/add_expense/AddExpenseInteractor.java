package back_end.add_expense;
import entity.Expense;
import entity.Budget;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Class implementation for AddExpenseInputBoundary
 * For interation between front and back end
 */
public class AddExpenseInteractor implements AddExpenseInputBoundary{
    final private AddExpenseOutputBoundary presenter;
    final private AddExpenseDataAccessInterface addExpDAO;

    /**
     * Constructs AddExpenseInteractor Instance
     * @param presenter AddExpenseOutputBoundary
     * @param addExpDAO AddExpenseDataAccessInterface
     */
    public AddExpenseInteractor(AddExpenseOutputBoundary presenter, AddExpenseDataAccessInterface addExpDAO){
        this.presenter = presenter;
        this.addExpDAO = addExpDAO;
    }

    /**
     * Takes Input Data and prepares popup for success and failure
     * @param iData AddExpenseInputData
     */
    @Override
    public void execute(AddExpenseInputData iData) {

        // new expense obj creation.
        Expense newExpense = new Expense(iData.getCategory(), iData.getAmount(), iData.month);
        Budget monthBudget = this.addExpDAO.getBudgetByMonth(iData.month);
        System.out.println(iData.month);

        // see if there is a valid budget for this month
        if (monthBudget != null){
            monthBudget.addExpense(newExpense);

            // out data prep and piping to presenter
            AddExpenseOutputData outputData = new AddExpenseOutputData(iData.getCategory(), iData.getAmount(), iData.month);
            presenter.prepareSuccessView(outputData);
        }
        // use the error popup
        else {
            System.out.println("Error! No budget was found to add this expense to.");
            presenter.noBudget();
        }
    }

    /**
     * Cancels input and returns to homescreen
     */
    @Override
    public void cancel(){
        presenter.cancel();
    }
}
