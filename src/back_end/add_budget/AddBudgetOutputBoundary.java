package back_end.add_budget;

/**
 * In order for the front end to support what the back end does, it must be able to prepare a success view, as well as
 * change the view if the user wishes to cancel their operation.
 */
public interface AddBudgetOutputBoundary {
    /**
     * The method that would be called to successfully inform the user that their budget has been created.
     * @param addBudgetOutputData   The data that the user should see upon successful execution (i.e. a
     *                              confirmation that their request went through).
     */
    void prepareSuccessView(AddBudgetOutputData addBudgetOutputData);

    /**
     * Tells the front end that the user wants to switch back to the main screen.
     */
    void cancel();

}
