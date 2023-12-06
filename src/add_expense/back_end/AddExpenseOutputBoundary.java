package add_expense.back_end;

public interface AddExpenseOutputBoundary {
    void prepareSuccessView(AddExpenseOutputData addBudgetOutputData);
    void cancel();
}
