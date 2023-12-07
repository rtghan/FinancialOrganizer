package back_end.investment_value;

import java.time.LocalDate;

/**
 * A class specifying the data required to check the investment value of the user's portfolio over time, given a
 * certain starting date, and amount of times they want to be checked (granularity).
 */
public class InvestmentValueInputData {
    private LocalDate beginDate;
    private int granularity;

    /**
     * Constructor method for an InvestmentValueInputData instance
     * @param beginDate     The date at which the user wishes to begin seeing the value of their portfolio
     * @param granularity   How many "snapshots" of your portfolio value between then and now do you want us to show you
     */
    public InvestmentValueInputData(LocalDate beginDate, int granularity) {
        this.beginDate = beginDate;
        this.granularity = granularity;
    }

    /**
     * Getter for the beginning date of the user's query
     * @return
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }

    /**
     * Getter for the granularity of a user's quarry
     * @return
     */
    public int getGranularity() {
        return granularity;
    }
}
