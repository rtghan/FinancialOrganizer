package interface_adapter.add_investment;

import java.time.LocalDate;

/**
 * Holds the relevant state information (e.g. user input, backend information) regarding the add investment use case.
 */
public class AddInvestmentState {
    private String stockName;
    private double qty;
    private LocalDate date = LocalDate.now();
    private String error = null;

    /**
     * Getter for the stock name that is in the view
     * @return
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * Setter for the stock name that is in the view
     * @param stockName     The new stock name to be set
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * Getter for the quantity of stocks purchased currently in the view
     * @return
     */
    public double getQty() {
        return qty;
    }

    /**
     * Setter for the quantity of stocks purchased
     * @param qty   The new amount of stocks purchased that will be shown in the view
     */
    public void setQty(double qty) {
        this.qty = qty;
    }

    /**
     * Getter for the date on which the stocks were purchased
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setter for the the stocks were purchased.
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for any errors that the back end may notify the front end of
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     * Change the state of whether or not there has been an error
     * @param error     The new value of error
     */
    public void setError(String error) {
        this.error = error;
    }
}
