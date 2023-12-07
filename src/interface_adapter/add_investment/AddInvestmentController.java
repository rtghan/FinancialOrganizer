package interface_adapter.add_investment;
import back_end.add_investment.AddInvestmentInputData;
import back_end.add_investment.AddInvestmentInputBoundary;
import java.time.LocalDate;

public class AddInvestmentController {
    private final AddInvestmentInputBoundary addInvInteractor;
    public AddInvestmentController(AddInvestmentInputBoundary addInvInteractor) {
        this.addInvInteractor = addInvInteractor;
    }

    public void execute(String stockName, double qty, LocalDate date) {
        AddInvestmentInputData inputData = new AddInvestmentInputData(stockName, qty, date);
        addInvInteractor.execute(inputData);
    }

    public void cancel() {
        addInvInteractor.cancel();
    }
}
