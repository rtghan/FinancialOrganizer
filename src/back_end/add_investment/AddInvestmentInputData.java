package back_end.add_investment;
import java.time.LocalDate;
public class AddInvestmentInputData {
    final private String stockName;
    final private double qty;
    final private LocalDate date;

    public AddInvestmentInputData(String stockName, double qty, LocalDate date) {
        this.stockName = stockName;
        this.qty = qty;
        this.date = date;
    }
    public String getStockName() {
        return stockName;
    }

    public double getQty() {
        return qty;
    }

    public LocalDate getDate() {
        return date;
    }
}
