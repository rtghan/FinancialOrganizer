package back_end.add_investment;
import java.time.LocalDateTime;
public class AddInvestmentInputData {
    final private String stockName;
    final private double qty;
    final private LocalDateTime time;

    public AddInvestmentInputData(String stockName, double qty, LocalDateTime time) {
        this.stockName = stockName;
        this.qty = qty;
        this.time = time;
    }
    public String getStockName() {
        return stockName;
    }

    public double getQty() {
        return qty;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
