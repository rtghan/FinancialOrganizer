package interface_adapter.home_screen;

import back_end.home_screen.HomeScreenOutputBoundary;
import back_end.home_screen.HomeScreenOutputData;
import interface_adapter.ViewManagerModel;
import back_end.chart_visualisation.back_end.ChartBuilder;

public class HomeScreenPresenter implements HomeScreenOutputBoundary {

    private final HomeScreenViewModel homeVM;
    private final ViewManagerModel viewManagerModel;

    public HomeScreenPresenter(HomeScreenViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.homeVM = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(HomeScreenOutputData outputData) throws Exception {
        HomeScreenState state = homeVM.getState();
        double budRemain = outputData.getRemainingBudget();
        double totalExp = outputData.getTotalExpenses();
        double totalInc = outputData.getTotalIncome();

        // update state with relevant financial data
        state.setBudgetNull(true);
        state.setRemainingBudget(budRemain);
        state.setTotalExpenses(totalExp);
        state.setTotalIncome(totalInc);

        //update state with image
        state.setStatGraph(ChartBuilder.build(totalExp, totalInc, 0));

        this.homeVM.setState(state);
        homeVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView() {
        HomeScreenState state = homeVM.getState();
        state.setBudgetNull(false);
        //update state with image
        try{
            state.setStatGraph(ChartBuilder.build(0, 0, 0));
        } catch (Exception e) {

        }

        this.homeVM.setState(state);
        homeVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

}


