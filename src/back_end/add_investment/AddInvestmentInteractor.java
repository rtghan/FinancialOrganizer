package back_end.add_investment;
import java.time.Month;
import entity.Investment;
import entity.Investments;

/**
 * A class that implments the AddInvestmentInputBoundary, allowing users to properly save their investments into
 * memory/other data interactors.
 */
public class AddInvestmentInteractor implements AddInvestmentInputBoundary {
    final private AddInvestmentDataAccessInterface addDAO;
    final private AddInvestmentOutputBoundary addPresenter;

    /**
     * Creates a new interactor capable of handling the addInvestment use case. Depends on the OutputBoundary to reflect
     * changes in the front end.
     * @param addDAO        A data access object that allows the interactor to save the user's investments
     * @param addPresenter  A class implementing the OutputBoundary that allows the back end to depend on it to ensure
     *                      the front end works as desired.
     */
    public AddInvestmentInteractor(AddInvestmentDataAccessInterface addDAO, AddInvestmentOutputBoundary addPresenter) {
        this.addDAO = addDAO;
        this.addPresenter = addPresenter;
    }

    /**
     * Adds the investment specified by the user to the Investments entity, then saves it away into memory so that
     * it can be referenced in the future/used for other purposes.
     * @param inputData     An input data object that contains the important information to create a new investment.
     *                      Namely, stock name, stock quantity, and stock purchase date.
     */
    @Override
    public void execute(AddInvestmentInputData inputData) {
        Investments currentInvestments = addDAO.getInvestments();

        // create investment
        Investment newInvestment = new Investment(inputData.getStockName(), inputData.getQty(), inputData.getDate());
        currentInvestments.investments.add(newInvestment);

        // save Budget
        addDAO.save(currentInvestments);

        // prepare output data
        AddInvestmentOutputData outputData = new AddInvestmentOutputData(inputData.getStockName(), inputData.getQty(), inputData.getDate());

        // tell the presenter to show that a new investment has been added
        addPresenter.prepareSuccessView(outputData);
    }

    /**
     * Method to move the user back to the main screen.
     */
    @Override
    public void cancel() {
        addPresenter.cancel();
    }
}
