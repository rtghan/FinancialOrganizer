package back_end.add_income;

/**
 * interface to prevent the interactor from directly depending on the presenter
 */
public interface AddIncomeOutputBoundary {
    /**
     * presents a successful view informing the user of the new income they have entered
     * @param addIncomeOutputData AddIncomeOutputData
     */
    void prepareSuccessView(AddIncomeOutputData addIncomeOutputData);

    /**
     * used when the user wants to cancel
     */
    void cancel();

    /**
     * used when there is no budget that corresponds to the particular month
     */
    void noBudget();
}
