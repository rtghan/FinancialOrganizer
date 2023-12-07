package entity;
import java.time.LocalDate;

/**
 * A class representing an investment by the user, in terms of stocks. Takes in a stock name, quantity of the purchase,
 * as well as the day that it was purchased.
 */
public class Investment {
    private String stockName;
    private double qty;
    private LocalDate date;

    /**
     * Constructor for a new investment object. Represents the purchasing of a single type of stock, though multiple
     * may be bought.
     * @param stockName     The name of the stock that was bought.
     * @param qty           The amount of stocks bought.
     * @param date          The date on which the stock was bought
     */
    public Investment(String stockName, double qty, LocalDate date) {
        this.stockName = stockName;
        this.qty = qty;
        this.date = date;
    }

    /**
     * Getter for the name of the purchased stock
     * @return
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * Setter for the name of the purchased stock
     * @param stockName     New name of the purchased stock
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * Getter for the quantity of purchased stocks
     * @return
     */
    public double getQty() {
        return qty;
    }

    /**
     * Setter for the quantity of purchase stocks
     * @param qty       The amount of stocks purchased to be set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }

    /**
     * Getter for the date of purchase of the stock
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setter for the date of purchase of the stock
     * @param date      The new date the stock is meant to hve been purchased on
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
