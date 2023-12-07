package interface_adapter.add_investment;
import back_end.add_investment.AddInvestmentOutputBoundary;
import back_end.add_investment.AddInvestmentOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddInvestmentView;

/**
 * A class controlled by the back end to update the front end whenever the back end has finished its job.
 */
public class AddInvestmentPresenter implements AddInvestmentOutputBoundary {
    private final ViewManagerModel viewMM;
    private final AddInvestmentViewModel addInvVM;

    private final HomeScreenViewModel homeScreenVM;

    /**
     * Creates a new AddInvestmentPresenter
     * @param viewMM    The view model manager which allows the presenter to carry out "switch view" commands (e.g. back
     *                  to the homescreen).
     * @param andInvVM  The view model which the presenter manipulates to control the front end
     * @param homeScreenVM  The view model which the AddInvestment view is linked to (home screen)
     */
    public AddInvestmentPresenter(ViewManagerModel viewMM, AddInvestmentViewModel andInvVM, HomeScreenViewModel homeScreenVM) {
        this.viewMM = viewMM;
        this.addInvVM = andInvVM;
        this.homeScreenVM = homeScreenVM;
    }

    /**
     * On successful saving of an investment by the backend, this method will be executed, and will inform the user of
     * success, as well as bringing them back to the home screen.
     * @param outputData    Output data object that contains information for the user on whether they successfully
     *                      were able to create a new investment.
     */
    @Override
    public void prepareSuccessView(AddInvestmentOutputData outputData) {
        AddInvestmentState state = addInvVM.getState();
        state.setError(null);
        this.addInvVM.setState(state);
        this.addInvVM.firePropertyChanged();

        homeScreenVM.update();

        this.viewMM.setActiveView(homeScreenVM.getViewName());
        this.viewMM.firePropertyChanged();
    }

    /**
     * Brings the user back to the home screen.
     */
    @Override
    public void cancel() {
        this.viewMM.setActiveView(homeScreenVM.getViewName());
        this.viewMM.firePropertyChanged();
    }
}
