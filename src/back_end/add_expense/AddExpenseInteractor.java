package back_end.add_expense;
import entity.Expense;
import entity.Budget;
import java.time.LocalDateTime;

public class AddExpenseInteractor implements AddExpenseInputBoundary{
    final private AddExpenseOutputBoundary presenter;
    final private AddExpenseDataAccessInterface addExpDAO;
    public AddExpenseInteractor(AddExpenseOutputBoundary presenter, AddExpenseDataAccessInterface addExpDAO){
        this.presenter = presenter;
        this.addExpDAO = addExpDAO;
    }
    @Override
    public void execute(AddExpenseInputData iData) {
        LocalDateTime creationTime = LocalDateTime.now();

        // new expense obj creation.
        Expense newExpense = new Expense(iData.getCategory(), iData.getAmount(), creationTime);
        Budget monthBudget = this.addExpDAO.getBudgetByMonth(creationTime.getMonth());
        monthBudget.addExpense(newExpense);

        // out data prep and piping to presenter
        AddExpenseOutputData outputData = new AddExpenseOutputData(iData.getCategory(), iData.getAmount(), creationTime);
        presenter.prepareSuccessView(outputData);

    }
    @Override
    public void cancel(){
        presenter.cancel();
    }
}
