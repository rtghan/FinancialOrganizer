package main;

import back_end.add_investment.AddInvestmentDataAccessInterface;
import back_end.investment_value.InvestmentValueDataAccessInterface;
import back_end.investment_value.InvestmentValueInputBoundary;
import back_end.investment_value.InvestmentValueInteractor;
import back_end.investment_value.InvestmentValueOutputBoundary;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenViewModel;
import interface_adapter.investment_value.InvestmentValueController;
import interface_adapter.investment_value.InvestmentValuePresenter;
import interface_adapter.investment_value.InvestmentValueViewModel;
import view.InvestmentValueView;

public class InvestmentValueBuilder {
    public static InvestmentValueView create(InvestmentValueViewModel invValVM, ViewManagerModel viewMM,
                                             AddInvestmentDataAccessInterface investDAO, InvestmentValueDataAccessInterface stockDAO,
                                             HomeScreenViewModel homeScreenVM) {
        InvestmentValueController investmentValueController = createInvestmentValueUseCase(viewMM, investDAO,
                invValVM, stockDAO, homeScreenVM);
        return new InvestmentValueView(investmentValueController, invValVM);
    }
    private static InvestmentValueController createInvestmentValueUseCase(
            ViewManagerModel viewMM, AddInvestmentDataAccessInterface investDAO, InvestmentValueViewModel invValVM,
            InvestmentValueDataAccessInterface stockDAO, HomeScreenViewModel homeScreenVM) {
        InvestmentValueOutputBoundary investmentValueOutputBoundary = new InvestmentValuePresenter(viewMM,invValVM, homeScreenVM);
        InvestmentValueInputBoundary investmentValueInputBoundary = new InvestmentValueInteractor(investDAO, stockDAO,
                investmentValueOutputBoundary);
        return new InvestmentValueController(investmentValueInputBoundary);
    }
}
