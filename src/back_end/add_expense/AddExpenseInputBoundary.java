package back_end.add_expense;

public interface AddExpenseInputBoundary {
    void execute(AddExpenseInputData addExpenseInputData);
    void cancel();
}
