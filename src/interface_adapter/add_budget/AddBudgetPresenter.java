package interface_adapter.add_budget;

import back_end.add_budget.AddBudgetOutputBoundary;
import back_end.add_budget.AddBudgetOutputData;
import interface_adapter.ViewManagerModel;

import interface_adapter.home_screen.HomeScreenState;
import interface_adapter.home_screen.HomeScreenViewModel;

/**
 * Manipulates the ViewModel so that when any changes are made from the backend, the front end will react accordingly
 * and update itself for the user.
 */
public class AddBudgetPresenter implements AddBudgetOutputBoundary{
    private final AddBudgetViewModel addBudVM;
    private ViewManagerModel viewManagerModel;
    private HomeScreenViewModel homeScreenVM;

    /**
     * Constructor to build a new AddBudgetPresenter
     * @param addBudVM      The ViewModel that the Presenter manipulates when it is told to by the back end
     * @param viewManagerModel  The object that allows the Presenter to specify when it should change between views
     * @param homeScreenVM  The ViewModel tht the Presenter needs a connection to in order to be linked to the
     *                      home screen.
     */
    public AddBudgetPresenter(AddBudgetViewModel addBudVM, ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenVM) {
        this.addBudVM = addBudVM;
        this.viewManagerModel = viewManagerModel;
        this.homeScreenVM = homeScreenVM;
    }

    /**
     * This method is ran when the backend has succesfully managed to save a Budget as specified by the user. It should
     * updte the user accordingly (e.g. by popup).
     * @param outputData   The data that the user should see upon successful execution (i.e. a
     *                              confirmation that their request went through).
     */
    @Override
    public void prepareSuccessView(AddBudgetOutputData outputData) {
        AddBudgetState state = addBudVM.getState();
        state.setCreationSuccess(true);
        this.addBudVM.setState(state);
        addBudVM.firePropertyChanged();

        // update values on the home screen
        homeScreenVM.update();

        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Helps the user return back to the main screen.
     */
    @Override
    public void cancel() {
        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
