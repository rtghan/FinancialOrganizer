package back_end.add_investment;
import java.time.LocalDate;

/**
 * A class to store the relevant information required to properly add more investments. This requires the time the stock
 * was purchased, the name of the stock (company), as well as the quantity in which it was purchased.
 */
public class AddInvestmentInputData {
    final private String stockName;
    final private double qty;
    final private LocalDate date;

    /**
     * Constructs a new instance of AddInvestmentInputData
     * @param stockName     Determines which company the stock is for
     * @param qty           Determines how many stocks the user bought
     * @param date          Determines at what date (and what price) the user bought the stock(s)
     */
    public AddInvestmentInputData(String stockName, double qty, LocalDate date) {
        this.stockName = stockName;
        this.qty = qty;
        this.date = date;
    }

    /**
     * Getter for the name (company) of the stock
     * @return
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * Getter for the quantity purchased of the stock
     * @return
     */
    public double getQty() {
        return qty;
    }

    /**
     * Getter for the date the stock was purchased
     * @return
     */
    public LocalDate getDate() {
        return date;
    }
}
