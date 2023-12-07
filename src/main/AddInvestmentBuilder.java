package main;
import back_end.add_investment.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_investment.AddInvestmentController;
import interface_adapter.add_investment.AddInvestmentPresenter;
import interface_adapter.add_investment.AddInvestmentViewModel;
import interface_adapter.add_investment.AddInvestmentController;
import interface_adapter.add_investment.AddInvestmentViewModel;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddBudgetView;
import view.AddExpenseView;
import view.AddInvestmentView;

public class AddInvestmentBuilder {
    public static AddInvestmentView create(AddInvestmentViewModel addInvVM, ViewManagerModel viewMM,
                                    AddInvestmentDataAccessInterface addDAO, HomeScreenViewModel homeScreenVM) {
        AddInvestmentController addInvCon = createAddInvestmentUseCase(viewMM, addDAO, addInvVM, homeScreenVM);
        return new AddInvestmentView(addInvCon, addInvVM);
    }
    public static AddInvestmentController createAddInvestmentUseCase(
            ViewManagerModel viewMM, AddInvestmentDataAccessInterface addDAO,
            AddInvestmentViewModel addInvVM, HomeScreenViewModel homeScreenVM) {
        AddInvestmentOutputBoundary addInvestmentOutputBoundary = new AddInvestmentPresenter(viewMM, addInvVM, homeScreenVM);
        AddInvestmentInputBoundary addInvestmentInteractor = new AddInvestmentInteractor(addDAO, addInvestmentOutputBoundary);

        return new AddInvestmentController(addInvestmentInteractor);
    }
}
