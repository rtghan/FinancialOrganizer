package interface_adapter.add_income;

import back_end.add_income.AddIncomeOutputBoundary;
import back_end.add_income.AddIncomeOutputData;
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
    @Override
    public void prepareSuccessView(AddIncomeOutputData outputData){
        AddIncomeState state = addIncVM.getState();
        state.setCreationSuccess(true);
        this.addIncVM.setState(state);
        addIncVM.firePropertyChanged();

        // update the homescreen with the income
        homeScreenVM.update();
        
        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
