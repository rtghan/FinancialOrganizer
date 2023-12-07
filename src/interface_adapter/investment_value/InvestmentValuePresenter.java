package interface_adapter.investment_value;

import back_end.investment_value.InvestmentValueOutputBoundary;
import back_end.investment_value.InvestmentValueOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_investment.AddInvestmentViewModel;
import interface_adapter.home_screen.HomeScreenViewModel;

public class InvestmentValuePresenter implements InvestmentValueOutputBoundary {
    private final ViewManagerModel viewMM;
    private final InvestmentValueViewModel invValVM;
    private final HomeScreenViewModel homeScreenVM;
    public InvestmentValuePresenter(ViewManagerModel viewMM, InvestmentValueViewModel invValVM, HomeScreenViewModel homeScreenVM) {
        this.viewMM = viewMM;
        this.invValVM = invValVM;
        this.homeScreenVM = homeScreenVM;
    }

    @Override
    public void displayPortfolio(InvestmentValueOutputData outputData) {
        // update state
        InvestmentValueState state = invValVM.getState();
        state.setErrorString(outputData.getError());
        state.setInvestmentValues(outputData.getInvestmentValues());
        state.setInitialValue(outputData.getInitialValue());
        this.invValVM.setState(state);
        this.invValVM.firePropertyChanged();

        this.viewMM.setActiveView(homeScreenVM.getViewName());
        this.viewMM.firePropertyChanged();
    }

    @Override
    public void returnHome() {
        this.viewMM.setActiveView(homeScreenVM.getViewName());
        this.viewMM.firePropertyChanged();
    }
}
