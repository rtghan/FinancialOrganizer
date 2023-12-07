package interface_adapter.investment_value;

import java.time.LocalDate;
import java.util.Map;

public class InvestmentValueState {
    private Map<LocalDate, Double> investmentValues;
    private LocalDate startDate;
    private int granularity;
    private double initialValue;
    private String errorString;
    public Map<LocalDate, Double> getInvestmentValues() {
        return investmentValues;
    }

    public void setInvestmentValues(Map<LocalDate, Double> investmentValues) {
        this.investmentValues = investmentValues;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getGranularity() {
        return granularity;
    }

    public void setGranularity(int granularity) {
        this.granularity = granularity;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }
    public String getErrorString() {
        return errorString;
    }
    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
