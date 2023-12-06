package back_end.add_budget;

public interface AddBudgetOutputBoundary {
    void prepareSuccessView(AddBudgetOutputData addBudgetOutputData);
    void cancel();

}
