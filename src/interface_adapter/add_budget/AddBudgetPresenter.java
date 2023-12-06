package interface_adapter.add_budget;

import back_end.add_budget.AddBudgetOutputBoundary;
import back_end.add_budget.AddBudgetOutputData;
import interface_adapter.ViewManagerModel;

import interface_adapter.home_screen.HomeScreenState;
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

        // update values on the home screen
        homeScreenVM.update();

        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void cancel() {
        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
