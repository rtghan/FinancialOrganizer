package back_end.add_investment;

/**
 * An interface specifying requirements for the back end in order to properly add investments/support the front end
 */
public interface AddInvestmentInputBoundary {
    /**
     * An implementing class must be able to take the investmentData and save it into the Investments entity
     * @param addInvestmentInputData    An input data object with the relevant parameters to define an Investment entity
     */
    void execute(AddInvestmentInputData addInvestmentInputData);

    /**
     * An implementing class must be able to cause the user to return to the home screen.
     */
    void cancel();
}
