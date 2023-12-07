package back_end.add_investment;
import java.time.Month;
import entity.Investment;
import entity.Investments;

public class AddInvestmentInteractor implements AddInvestmentInputBoundary {
    final private AddInvestmentDataAccessInterface addDAO;
    final private AddInvestmentOutputBoundary addPresenter;
    public AddInvestmentInteractor(AddInvestmentDataAccessInterface addDAO, AddInvestmentOutputBoundary addPresenter) {
        this.addDAO = addDAO;
        this.addPresenter = addPresenter;
    }

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

    @Override
    public void cancel() {
        addPresenter.cancel();
    }
}
