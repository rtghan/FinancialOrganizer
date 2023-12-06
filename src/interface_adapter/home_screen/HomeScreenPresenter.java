package interface_adapter.home_screen;

import back_end.home_screen.HomeScreenOutputBoundary;
import back_end.home_screen.HomeScreenOutputData;
import interface_adapter.ViewManagerModel;

public class HomeScreenPresenter implements HomeScreenOutputBoundary {

    private final HomeScreenViewModel homeVM;
    private final ViewManagerModel viewManagerModel;

    public HomeScreenPresenter(HomeScreenViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.homeVM = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(HomeScreenOutputData outputData) {

        HomeScreenState state = homeVM.getState();
        state.setCreationSuccess(true);
        state.setRemainingBudget(outputData.getRemainingBudget());
        state.setTotalExpenses(outputData.getTotalExpenses());
        state.setTotalIncome(outputData.getTotalIncome());
        this.homeVM.setState(state);
        homeVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView() {
        HomeScreenState state = homeVM.getState();
        state.setCreationSuccess(false);
        this.homeVM.setState(state);
        homeVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

}


