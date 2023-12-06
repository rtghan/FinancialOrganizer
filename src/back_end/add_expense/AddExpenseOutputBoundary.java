package back_end.add_expense;
public interface AddExpenseOutputBoundary {
    void prepareSuccessView(AddExpenseOutputData addBudgetOutputData);
    void cancel();
}
