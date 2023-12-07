package entity;
import java.time.LocalDate;
public class Investment {
    private String stockName;
    private double qty;
    private LocalDate date;
    public Investment(String stockName, double qty, LocalDate date) {
        this.stockName = stockName;
        this.qty = qty;
        this.date = date;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
