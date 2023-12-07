package interface_adapter.home_screen;

import back_end.chart_visualisation.ChartOutputData;
import back_end.home_screen.HomeScreenOutputBoundary;
import back_end.home_screen.HomeScreenOutputData;
import interface_adapter.ViewManagerModel;
import back_end.chart_visualisation.helpers.ChartBuilderFacade;

/**
 * presenter for home screen - outputs data and prepares view for home screen
 */
public class HomeScreenPresenter implements HomeScreenOutputBoundary {

    private final HomeScreenViewModel homeVM;
    private final ViewManagerModel viewManagerModel;

    /**
     * constructor for home screen presenter with specified view model + view manager model
     * @param viewModel         home screen view model
     * @param viewManagerModel  view manager model
     */
    public HomeScreenPresenter(HomeScreenViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.homeVM = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * prepares success view with specified output data
     * @param outputData  output data
     * @throws Exception
     */
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
        state.setStatGraph(ChartBuilderFacade.build("bar", totalExp, totalInc));

        this.homeVM.setState(state);
        homeVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * prepares the failed view version
     */
    @Override
    public void prepareFailView() {
        HomeScreenState state = homeVM.getState();
        state.setBudgetNull(false);
        //update state with image
        try{
            state.setStatGraph(ChartBuilderFacade.build("bar",0, 0));
        } catch (Exception e) {

        }

        this.homeVM.setState(state);
        homeVM.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeVM.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * prepares the popup by the specified output data (stats)
     * @param outputData
     */
    @Override
    public void preparePopup(ChartOutputData outputData) {
        HomeScreenState state = homeVM.getState();
        try{
            state.setExpenseGraph(ChartBuilderFacade.build("doughnut", new String[]{"Expense"},outputData.getData(), 400, 400));
        }catch (Exception e){

        }
    }
}


