package interface_adapter.add_income;

import back_end.add_income.AddIncomeOutputBoundary;
import back_end.add_income.AddIncomeOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenViewModel;

/**
 * implements the output boundary helps move the output data to the user
 */
public class AddIncomePresenter implements AddIncomeOutputBoundary{
    private final AddIncomeViewModel addIncVM;
    private ViewManagerModel viewManagerModel;
    private HomeScreenViewModel homeScreenVM;

    /**
     * constructor for the class
     * @param addIncVM AddIncomeViewModel
     * @param viewManagerModel ViewManagerModel
     * @param homeScreenVM HomeScreenViewModel
     */
    public AddIncomePresenter(AddIncomeViewModel addIncVM, ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenVM) {
        this.addIncVM = addIncVM;
        this.viewManagerModel = viewManagerModel;
        this.homeScreenVM = homeScreenVM;
    }

    /**
     * uses the output data and passes it to the view model to prepare a success view
     * @param outputData AddIncomeOutputData
     */
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

    /**
     * tells the view manager model to present the cancel screen
     */
    @Override
    public void cancel(){
        this.viewManagerModel.setActiveView(homeScreenVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * tells the view model to display the screen when there is no appropriate budget to save the income to
     */
    @Override
    public void noBudget() {
        AddIncomeState state = addIncVM.getState();
        state.setCreationSuccess(false);
        this.addIncVM.setState(state);
        addIncVM.firePropertyChanged();
    }
}
