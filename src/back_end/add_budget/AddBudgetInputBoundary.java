package back_end.add_budget;

public interface AddBudgetInputBoundary {
    void execute(AddBudgetInputData addBudgetInputData);
    void cancel();
}
