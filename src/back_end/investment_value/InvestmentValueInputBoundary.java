package back_end.investment_value;

/**
 * An interface specifying what the back end needs to be capable of doing in order to support the user checking the
 * investment value from the front end.
 */
public interface InvestmentValueInputBoundary {
    /**
     * A method that allows the user to get the value of their portfolio over time, given that they pass in an input data
     * object of type InvestmentValueInputData
     * @param inputData
     */
    void getValueOverTime(InvestmentValueInputData inputData);

    /**
     * When called, switches the views so that the user has the ability to return to the main application screen.
     */
    void returnHome();
}
