package back_end.investment_value;

import java.time.LocalDate;

public class InvestmentValueInputData {
    private LocalDate beginDate;
    private int granularity;

    public InvestmentValueInputData(LocalDate beginDate, int granularity) {
        this.beginDate = beginDate;
        this.granularity = granularity;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public int getGranularity() {
        return granularity;
    }
}
