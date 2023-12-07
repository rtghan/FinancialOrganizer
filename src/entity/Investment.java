package entity;
import java.time.LocalDateTime;
public class Investment {
    private String stockName;
    private double qty;
    private LocalDateTime time;
    public Investment(String stockName, double qty, LocalDateTime time) {
        this.stockName = stockName;
        this.qty = qty;
        this.time = time;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
