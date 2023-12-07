package back_end.add_investment;
import java.time.LocalDate;

/**
 * A class holding data that will be used on the front end response after a user has tried to add an investment.
 */
public class AddInvestmentOutputData {
    final private String stockName;
    final private double qty;
    final private LocalDate date;

    /**
     * Creates a new instance of the AddInvestmentOutputData object
     * @param stockName     The name of the stock that the user specified they purchased
     * @param qty           The quantity of the stock that the user specified they purchased
     * @param date          The date of purchase of the stock that the user specified
     */
    public AddInvestmentOutputData(String stockName, double qty, LocalDate date) {
        this.stockName = stockName;
        this.qty = qty;
        this.date = date;
    }

    /**
     * Getter for the stock name of the stock the user invested in
     * @return
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * Getter for the amount of stock the user bought
     * @return
     */
    public double getQty() {
        return qty;
    }

    /**
     * Getter for the date on which the user purchased the stock
     * @return
     */
    public LocalDate getDate() {
        return date;
    }
}
