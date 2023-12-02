package interface_adapter.add_income;

import add_income.back_end.AddIncomeInteractor;
import add_income.back_end.AddIncomeOutputBoundary;
import add_income.back_end.AddIncomeOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenViewModel;

public class AddIncomePresenter implements AddIncomeOutputBoundary{
    private final AddIncomeViewModel addIncVM;
    private ViewManagerModel viewManagerModel;
    private HomeScreenViewModel homeScreenVM;
    public AddIncomePresenter(AddIncomeViewModel addIncVM, ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenVM) {
        this.addIncVM = addIncVM;
        this.viewManagerModel = viewManagerModel;
        this.homeScreenVM = homeScreenVM;
    }

    public void prepareSuccessView(AddIncomeOutputData outputData){
        AddIncomeState state = addIncVM.getState();
        state.setCreationSuccess(true);
        this.addIncVM.setState(state);
        addIncVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
