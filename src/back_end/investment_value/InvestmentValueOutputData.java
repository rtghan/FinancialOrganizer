package back_end.investment_value;
import java.util.Map;
import java.time.LocalDate;

public class InvestmentValueOutputData {
    private final Map<LocalDate, Double> investmentValues;
    private final String error;
    private final double initialValue;
    public InvestmentValueOutputData(Map<LocalDate, Double> investmentValues, String error, double initialValue) {
        this.investmentValues = investmentValues;
        this.error = error;
        this.initialValue = initialValue;
    }

    public Map<LocalDate, Double> getInvestmentValues() {
        return investmentValues;
    }
}
