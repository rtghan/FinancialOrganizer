package back_end.add_expense;
import entity.Expense;
import java.time.LocalDateTime;

public class AddExpenseInteractor implements AddExpenseInputBoundary{
    final private AddExpenseOutputBoundry presenter;
    public AddExpenseInteractor(AddExpenseOutputBoundry presenter){
        this.presenter = presenter;
    }
    @Override
    public void execute(AddExpenseInputData iData) {
        LocalDateTime creationTime = LocalDateTime.now();

        // new expense obj creation.
        Expense newExpense = new Expense(iData.getCategory(), iData.getAmount(), creationTime);
        // uhhh gotta save this but i'll figure it out lated :3

        // out data prep and piping to presenter
        AddExpenseOutputData outputData = new AddExpenseOutputData(iData.getCategory(), iData.getAmount(), creationTime);

        presenter.prepareSuccessView(outputData);

    }
}
