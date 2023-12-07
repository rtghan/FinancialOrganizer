package back_end.add_investment;

/**
 * An interface specifying what the front end must be capable of in order for it to be able to support the back end of
 * the add investment use case.
 */
public interface AddInvestmentOutputBoundary {
    /**
     * An implementing class must be able to prepare a success view along with some data to effectively communicate to
     * the user that their investment has been noted and stored.
     * @param outputData    Output data object that contains information for the user on whether they successfully
     *                      were able to create a new investment.
     */
    void prepareSuccessView(AddInvestmentOutputData outputData);

    /**
     * An implementing class must be able to handle the user wanting to go back to the main screen
     */
    void cancel();
}
