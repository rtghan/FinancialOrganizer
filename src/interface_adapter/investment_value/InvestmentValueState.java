package interface_adapter.investment_value;

import java.time.LocalDate;
import java.util.Map;

/**
 * Holds the current state of the InvestmentValue view (e.g. any user input), including the selected starting date,
 * granularity, as well as values that will later be given by the back end, like the initial value of the user's
 * investment portfolio.
 */
public class InvestmentValueState {
    private Map<LocalDate, Double> investmentValues;
    private LocalDate startDate;
    private int granularity;
    private double initialValue;
    private String errorString;

    /**
     * Getter for the date - investmentValues mapping
     * @return
     */
    public Map<LocalDate, Double> getInvestmentValues() {
        return investmentValues;
    }

    /**
     * Setter for the date - investmentValues mapping
     * @param investmentValues  The new mapping between date and investmentValues to be saved in state
     */
    public void setInvestmentValues(Map<LocalDate, Double> investmentValues) {
        this.investmentValues = investmentValues;
    }

    /**
     * Getter for the start date currently reflected in the view (that the back end may use to begin their queries from)
     * @return
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Setter for the start date reflected on the view
     * @param startDate     The new value of the start date that will be reflected on the view
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter for the granularity currently reflected on the view
     * @return
     */
    public int getGranularity() {
        return granularity;
    }

    /**
     * Setter for the granularity reflected on the view
     * @param granularity   The new value of granularity that will be shown on the view
     */
    public void setGranularity(int granularity) {
        this.granularity = granularity;
    }

    /**
     * Get the initial cost of the user's investment portfolio, if it has been set by the backend
     * @return
     */
    public double getInitialValue() {
        return initialValue;
    }

    /**
     * Allows for setting of the cost of the user's investment portfolio
     * @param initialValue  This is the value that the user's investment portfolio cost will be set to
     */
    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    /**
     * Getter for the string which reports the status of any mishaps the backend may have run into while computing
     * the user's portfolio values
     * @return
     */
    public String getErrorString() {
        return errorString;
    }

    /**
     * Sets the string which reports the status of backend mishaps
     * @param errorString   The new value that the errorString will hold
     */
    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
