package add_expense.back_end;

public interface AddExpenseInputBoundary {
    void execute(AddExpenseInputData addExpenseInputData);
    void cancel();
}
