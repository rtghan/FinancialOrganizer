package back_end.investment_value;

/**
 * An interface specifying what the back end requires of the front end in order to show to the viewer the computed
 * values of their investment portfolio at differing points in time.
 */
public interface InvestmentValueOutputBoundary {
    /**
     * An implementing class must be able to display the calculated investment values
     * @param outputData    An output data class which wraps all the different investment values with
     *                      their associated times
     */
    public void displayPortfolio(InvestmentValueOutputData outputData);

    /**
     * An implementing class must let the user be able to return to the homescreen if they desire
     */
    public void returnHome();
}
