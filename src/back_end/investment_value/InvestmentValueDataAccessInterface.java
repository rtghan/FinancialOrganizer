package back_end.investment_value;

import java.time.LocalDate;

/**
 * Specifies the data storage needs of the getting Investment Value use case. In particular, it specifies that for this
 * use case to function, there needs to be the capability to get the price of a stock, given its name, and date of
 * purchase.
 */
public interface InvestmentValueDataAccessInterface {
    /**
     * Classes implementing this interface will be able to take in a stock name and time of purchase, then return the
     * value of the stock at that time.
     * @param stockName     The name of the stock whose value will be queried
     * @param purchaseDate  The date of the stock whose value will be queried
     * @return
     */
    Double getPrice(String stockName, LocalDate purchaseDate);
}
