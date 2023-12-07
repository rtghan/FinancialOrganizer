package back_end.add_budget;

/**
 * A class that specifies what is required for the backend to do, for the addBudget use case
 */
public interface AddBudgetInputBoundary {
    /**
     * Takes the information from the front end and saves a budget with those properties
     * @param addBudgetInputData    input data object containing the relevant properties defining a budget
     */
    void execute(AddBudgetInputData addBudgetInputData);

    /**
     * Moves the user back to the home screen.
     */
    void cancel();
}
