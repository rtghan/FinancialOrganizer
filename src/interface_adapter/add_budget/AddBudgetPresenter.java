package interface_adapter.add_budget;

import add_budget.back_end.AddBudgetOutputBoundary;
import add_budget.back_end.AddBudgetOutputData;
import interface_adapter.ViewManagerModel;

// TODO: replace this with the visualization screen
import interface_adapter.home_screen.HomeScreenViewModel;

public class AddBudgetPresenter implements AddBudgetOutputBoundary{
    private final AddBudgetViewModel addBudVM;
    private ViewManagerModel viewManagerModel;
    private HomeScreenViewModel homeScreenVM;

    public AddBudgetPresenter(AddBudgetViewModel addBudVM, ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenVM) {
        this.addBudVM = addBudVM;
        this.viewManagerModel = viewManagerModel;
        this.homeScreenVM = homeScreenVM;
    }
    @Override
    public void prepareSuccessView(AddBudgetOutputData outputData) {
        AddBudgetState state = addBudVM.getState();
        state.setCreationSuccess(true);
        this.addBudVM.setState(state);
        addBudVM.firePropertyChanged();

        // TODO: on success, switch to the view stats panel
        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
