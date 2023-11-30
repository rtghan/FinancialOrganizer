package add_expense.back_end;
import entity.Expense;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.Month;
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
