package interface_adapter.investment_value;

import back_end.investment_value.InvestmentValueInputBoundary;
import back_end.investment_value.InvestmentValueInputData;

import java.time.LocalDate;

/**
 * Class that manipulates the back end to compute the value of the user's investments when prompted to do so by
 * the view.
 */
public class InvestmentValueController {
    private final InvestmentValueInputBoundary invValInteractor;

    /**
     * Constructor for a new InvestmentValueController
     * @param invValInteractor  The class that the controller manipulates to cause the backend to carry out the
     *                          computation of the value of the user's investments
     */
    public InvestmentValueController(InvestmentValueInputBoundary invValInteractor) {
        this.invValInteractor = invValInteractor;
    }

    /**
     * Calls the backend to compute the value of the user's investments at different points in time. How many different
     * points in time is specified by granularity, while the point in time at which these values are checked begins at
     * the beginDate, and then is spaced as evenly as possible to the current day.
     * @param beginDate     The earliest date from which to begin calculating the value of the user's investment portfolio
     * @param granularity   How many different dates to query the value of the user's portfolio
     */
    public void getValueOverTime(LocalDate beginDate, int granularity) {
        InvestmentValueInputData inputData = new InvestmentValueInputData(beginDate, granularity);
        invValInteractor.getValueOverTime(inputData);
    }

    /**
     * Returns the user to the home page
     */
    public void returnHome() {
        invValInteractor.returnHome();
    }
}
