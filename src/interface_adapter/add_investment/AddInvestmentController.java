package interface_adapter.add_investment;
import back_end.add_investment.AddInvestmentInputData;
import back_end.add_investment.AddInvestmentInputBoundary;
import java.time.LocalDate;

/**
 * Class that controls the back end when given commands by the front end to add and save investments made by user.
 */
public class AddInvestmentController {
    private final AddInvestmentInputBoundary addInvInteractor;

    /**
     * Constructor for a new AddInvestmentController
     * @param addInvInteractor      The class that is part of the back end that the controller manipulates to carry out
     *                              adding and saving investments.
     */
    public AddInvestmentController(AddInvestmentInputBoundary addInvInteractor) {
        this.addInvInteractor = addInvInteractor;
    }

    /**
     * Tells the backend to add/save an investment, in accordance with these parameters.
     * @param stockName     The name of the stock to be saved
     * @param qty           The quantity of stocks purchased to be saved
     * @param date          The date of purchase of the stock to be saved
     */
    public void execute(String stockName, double qty, LocalDate date) {
        AddInvestmentInputData inputData = new AddInvestmentInputData(stockName, qty, date);
        addInvInteractor.execute(inputData);
    }

    /**
     * Lets the user go back to the home view
     */
    public void cancel() {
        addInvInteractor.cancel();
    }
}
