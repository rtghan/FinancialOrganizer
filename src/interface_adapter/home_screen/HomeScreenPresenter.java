package interface_adapter.home_screen;

import home_screen.HomeScreenOutputBoundary;
import home_screen.HomeScreenOutputData;
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
        this.homeVM.setState(state);
        homeVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

}


