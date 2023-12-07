package interface_adapter.investment_value;

import back_end.investment_value.InvestmentValueInputBoundary;
import back_end.investment_value.InvestmentValueInputData;

import java.time.LocalDate;

public class InvestmentValueController {
    private final InvestmentValueInputBoundary invValInteractor;

    public InvestmentValueController(InvestmentValueInputBoundary invValInteractor) {
        this.invValInteractor = invValInteractor;
    }

    public void getValueOverTime(LocalDate beginDate, int granularity) {
        InvestmentValueInputData inputData = new InvestmentValueInputData(beginDate, granularity);
        invValInteractor.getValueOverTime(inputData);
    }

    public void returnHome() {
        invValInteractor.returnHome();
    }
}
