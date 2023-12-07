package back_end.investment_value;
import java.util.Map;
import java.time.LocalDate;

/**
 * A class wrapping the information that the user should see upon requesting to see their portfolio value over time
 */
public class InvestmentValueOutputData {
    private final Map<LocalDate, Double> investmentValues;
    private final String error;
    private final double initialValue;

    /**
     * Constructor for an instance of an output data object
     * @param investmentValues      A mapping from dates to the associated value of the user's portfolio
     * @param error                 An error message, which may arise from the API calls to retrieve stock prices
     * @param initialValue          The value of the user's portfolio when they initially bought the stocks -
     *                              essentially how much the user paid for their portfolio.
     */
    public InvestmentValueOutputData(Map<LocalDate, Double> investmentValues, String error, double initialValue) {
        this.investmentValues = investmentValues;
        this.error = error;
        this.initialValue = initialValue;
    }

    /**
     * Getter for the date-portfolio value mapping
     * @return
     */
    public Map<LocalDate, Double> getInvestmentValues() {
        return investmentValues;
    }

    /**
     * Getter to check for the error message
     * @return
     */
    public String getError() {return this.error;}

    /**
     * Getter to retrieve the cost of the user's investment portfolio
     * @return
     */
    public double getInitialValue() {return this.initialValue;}
}
