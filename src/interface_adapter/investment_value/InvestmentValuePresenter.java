package interface_adapter.investment_value;

import back_end.investment_value.InvestmentValueOutputBoundary;
import back_end.investment_value.InvestmentValueOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenViewModel;

/**
 * A class that is manipulated by the back end to modify the front end when the back end has completed all of its
 * computations/duties.
 */
public class InvestmentValuePresenter implements InvestmentValueOutputBoundary {
    private final ViewManagerModel viewMM;
    private final InvestmentValueViewModel invValVM;
    private final HomeScreenViewModel homeScreenVM;

    /**
     * Constructor for a new InvestmentValuePresenter
     * @param viewMM    The viewModelManager that the presenter will use to switch views (e.g. back to the homescreen)
     * @param invValVM  The view model that the presenter will be manipulating in order to control the front end
     * @param homeScreenVM  The view model that the presenter links to in order to return to the home screen
     */
    public InvestmentValuePresenter(ViewManagerModel viewMM, InvestmentValueViewModel invValVM, HomeScreenViewModel homeScreenVM) {
        this.viewMM = viewMM;
        this.invValVM = invValVM;
        this.homeScreenVM = homeScreenVM;
    }

    /**
     * When called, takes the outputData which should contain the value of the user's investment portfolio at different
     * times, and saves it into the state, so that the front end can reflect it to the user.
     * @param outputData    An output data class which wraps all the different investment values with
     *                      their associated times
     */
    @Override
    public void displayPortfolio(InvestmentValueOutputData outputData) {
        // update state
        InvestmentValueState state = invValVM.getState();
        state.setErrorString(outputData.getError());
        state.setInvestmentValues(outputData.getInvestmentValues());
        state.setInitialValue(outputData.getInitialValue());
        this.invValVM.setState(state);
        this.invValVM.firePropertyChanged();
    }

    /**
     * Returns the user to the homescreen
     */
    @Override
    public void returnHome() {
        this.viewMM.setActiveView(homeScreenVM.getViewName());
        this.viewMM.firePropertyChanged();
    }
}
